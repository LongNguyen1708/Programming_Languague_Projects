package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SoundManager {
    /**
     * Gets singleton instance
     * @return SoundManager instance
     */
    private static SoundManager instance;

    private Clip musicClip;
    private boolean muted = false;
    private float currentVolume = 1.0f;
    private String currentMusicPath = null;

    // Cache for sound effects to improve performance
    private Map<String, Clip> soundEffectCache = new HashMap<>();

    // Private constructor for singleton pattern
    private SoundManager() {}


    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

       /**
     * Plays a sound effect
     * @param soundPath Path to sound file
     */
    public void playSoundEffect(String soundPath) {
        if (muted) return;

        try {
            // Check if the sound is already cached
            Clip clip = soundEffectCache.get(soundPath);

            // If not in cache, load and cache it
            if (clip == null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                soundEffectCache.put(soundPath, clip);
            }

            // Stop the clip if it's still playing from before
            if (clip.isRunning()) {
                clip.stop();
            }

            // Reset to beginning
            clip.setFramePosition(0);

            // Set volume if needed
            if (currentVolume < 1.0f) {
                setClipVolume(clip, currentVolume);
            }

            // Play the sound
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound effect: " + e.getMessage());
        }
    }
     /**
     * Plays background music
     * @param musicPath Path to music file
     */
    public void playBackgroundMusic(String musicPath) {
        // Don't restart the same music
        if (currentMusicPath != null && currentMusicPath.equals(musicPath) &&
                musicClip != null && musicClip.isRunning()) {
            return;
        }

        stopBackgroundMusic(); // Stop any currently playing music

        if (muted) return;

        try {
            File musicFile = new File(musicPath);
            if (!musicFile.exists()) {
                System.err.println("Cannot find music file: " + musicPath);
                return;
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);

            // Set volume
            if (currentVolume < 1.0f) {
                setClipVolume(musicClip, currentVolume);
            }

            // Loop continuously
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();

            // Save current music path
            currentMusicPath = musicPath;

        } catch (Exception e) {
            System.err.println("Error playing music: " + e.getMessage());
            e.printStackTrace();
        }
    }    
     /**
     * Stops current background music
     */
    public void stopBackgroundMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
            musicClip.close();
        }
        currentMusicPath = null;
    }

     /**
     * Sets volume level
     * @param volume Volume from 0.0 to 1.0
     */
    public void setVolume(float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume out of range");

        currentVolume = volume;

        // Update music volume if playing
        if (musicClip != null && musicClip.isRunning() && !muted) {
            setClipVolume(musicClip, volume);
        }
    }


    private void setClipVolume(Clip clip, float volume) {
        try {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Convert to decibels
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        } catch (IllegalArgumentException e) {
            // Some clips might not support volume control
            System.err.println("Cannot set volume: " + e.getMessage());
        }
    }
    /**
     * Sets muted state
     * @param muted True to mute all sounds
     */
    public void setMuted(boolean muted) {
        this.muted = muted;

        if (muted) {
            stopBackgroundMusic();
        } else if (currentMusicPath != null) {
            // Restart the music if we have a current track
            playBackgroundMusic(currentMusicPath);
        }
    }

     /**
     * Checks if audio is muted
     * @return True if muted
     */
    public boolean isMuted() {
        return muted;
    }


    public void cleanup() {
        stopBackgroundMusic();

        // Clean up cached sound effects
        for (Clip clip : soundEffectCache.values()) {
            clip.close();
        }
        soundEffectCache.clear();
    }
    public float getVolume() {
        return currentVolume;
    }
}
