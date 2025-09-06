package Menus;

import game.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsMenu extends JFrame {
    private SoundManager soundManager;
    private JSlider volumeSlider;
    private JButton applyButton;
    private JButton backButton;
    private JCheckBox muteCheckbox;

    public SettingsMenu(JFrame parentFrame) {
        // Get the sound manager instance
        soundManager = SoundManager.getInstance();

        // Setup the frame
        setTitle("Game Settings");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parentFrame);

        // Create main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create title label
        JLabel titleLabel = new JLabel("Game Settings", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create settings panel
        JPanel settingsPanel = new JPanel(new GridLayout(3, 1, 10, 20));

        // Volume control
        JPanel volumePanel = new JPanel(new BorderLayout(10, 0));
        JLabel volumeLabel = new JLabel("Volume: ");
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, (int)(soundManager.getVolume() * 100));
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumePanel.add(volumeLabel, BorderLayout.WEST);
        volumePanel.add(volumeSlider, BorderLayout.CENTER);

        // Mute checkbox
        muteCheckbox = new JCheckBox("Mute", soundManager.isMuted());
        muteCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable/disable the volume slider based on mute status
                volumeSlider.setEnabled(!muteCheckbox.isSelected());
            }
        });

        // Add components to settings panel
        settingsPanel.add(volumePanel);
        settingsPanel.add(muteCheckbox);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        // Apply button
        applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }
        });

        // Back button
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close settings window
            }
        });

        buttonPanel.add(applyButton);
        buttonPanel.add(backButton);

        // Add panels to main panel
        mainPanel.add(settingsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set content pane
        setContentPane(mainPanel);

        // Make visible
        setVisible(true);
    }

    private void applySettings() {
        // Apply volume settings
        float volume = volumeSlider.getValue() / 100f;
        soundManager.setVolume(volume);

        // Apply mute settings
        soundManager.setMuted(muteCheckbox.isSelected());
        soundManager.playSoundEffect("sounds/button_click.wav");
        // Show confirmation
        JOptionPane.showMessageDialog(this,
                "Settings applied successfully!",
                "Settings Saved",
                JOptionPane.INFORMATION_MESSAGE);
    }
}