package game;
import city.cs.engine.*;

import javax.swing.*;

import Menus.GameMenu;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameMenu());
    }
}