package Uczelnia.Main;

import Uczelnia.GUI.MenuGL;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(MenuGL::new);
    }
}