package main;

import javax.swing.JFrame;
import java.awt.Component;

public class MainFrame extends JFrame {

    public MainFrame(Component component) {
        super("Game");
        add(component);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
