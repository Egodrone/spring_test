package se.lexicon.gui;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import java.util.List;
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

        // save student btn
        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        jLabel = new JLabel("Saved Students");

        JButton findBtn = new JButton("Find student");
        JLabel findBtnLabel = new JLabel("Find Student by id");

        // save student
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 160, 160));
        panel.setLayout(new GridLayout());
        panel.add(saveStudentBtn);
        panel.add(jLabel);

        //find student by id btn
        panel.add(findBtn);
        panel.add(findBtnLabel);

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


    // Save student
    @Override
    public void actionPerformed(ActionEvent e) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        Student cS = dao.save(new Student("Test2"));
        ++countSaved;
        System.out.println("Call the function to save student " + countSaved);
        jLabel.setText("Added: " + countSaved + ", id: " + cS.getId());
        //jLabel.setText("Added: " + countSaved + ", Name:" + cS.getName() + ", id: " + cS.getId());
    }



}
