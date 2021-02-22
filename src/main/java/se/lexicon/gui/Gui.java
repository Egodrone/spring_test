package se.lexicon.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Gui implements ActionListener {
    private int countSaved = 0;
    private final JFrame frame;
    private final JLabel jLabel;
    private final JPanel panel;
    private final JButton saveStudentBtn;



    public Gui() {
        frame = new JFrame();

        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        jLabel = new JLabel("Saved Students");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 160, 160));
        panel.setLayout(new GridLayout());
        panel.add(saveStudentBtn);
        panel.add(jLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Student GUI ");
        frame.pack();
        frame.setVisible(true);
    }


    /*
    public static void main(String[] args) {
        Gui gui = new Gui();
    }*/



    @Override
    public void actionPerformed(ActionEvent e) {
        ++countSaved;
        System.out.println("Call the function to save student " + countSaved);
        jLabel.setText("Added: " + countSaved + " times");

    }



}
