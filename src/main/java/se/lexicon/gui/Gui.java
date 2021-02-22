package se.lexicon.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Gui implements ActionListener {

    public Gui() {
        JFrame frame = new JFrame();

        JButton saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        JLabel jLabel = new JLabel("Saved Students");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 140, 140));
        panel.setLayout(new GridLayout());
        panel.add(saveStudentBtn);
        panel.add(jLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Student GUI ");
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        Gui gui = new Gui();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Call the function to save student");
    }



}
