package se.lexicon.gui;



import javax.swing.*;
import java.awt.*;



public class Gui {

    public Gui() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 140, 140));
        panel.setLayout(new GridLayout());

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Student GUI ");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
