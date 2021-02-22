package se.lexicon.gui;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;

import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Gui implements ActionListener {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private StudentDao dao = context.getBean("studentDao", StudentDao.class);

    private int countSaved = 0;

    private final JFrame frame;
    private final JLabel jLabel;
    private final JPanel panel;

    private final JButton saveStudentBtn;
    private final JButton deleteBtn;
    private final JButton findAll;
    private final JButton exitBtn;
    private final JButton findBtn;

    private final Container container;
    private final JTextField saveTxt;



    public Gui() {
        frame = new JFrame();
        panel = new JPanel();
        container = frame.getContentPane();

        saveTxt = new JTextField(100);
        Font myFontSize = saveTxt.getFont().deriveFont(Font.BOLD,40f);
        saveTxt.setFont(myFontSize);
        container.add(saveTxt, BorderLayout.NORTH);

        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 160, 160));
        panel.setLayout(new GridLayout(4,4,4,4));



        //saveStudentBtn = new JButton("Save student", new ImageIcon("path/file.gif"));
        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        jLabel = new JLabel("Saved Students");
        panel.add(jLabel);
        panel.add(saveStudentBtn);



        findBtn = new JButton("Find student");
        findBtn.addActionListener(e -> {
            System.out.println("---------- Find Student By Id ------------");
        });
        JLabel findBtnLabel = new JLabel("Find Student by id");
        panel.add(findBtnLabel);
        panel.add(findBtn);



        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(e -> {
            System.out.println("---------- Delete ------------");
            List<Student> listOfAllStudents = dao.findAll();
            int deleteId = 0;

            if(listOfAllStudents.size() > 0) {

                for (Student studentList : listOfAllStudents) {
                    deleteId = studentList.getId();
                    dao.delete(deleteId);

                    break;
                }

                System.out.println(" Student with id: " + deleteId + " was removed ");
            } else {
                System.out.println(" There is no students left to remove ");
            }
        });
        panel.add(deleteBtn);



        findAll =  new JButton("Find All");
        findAll.addActionListener(e -> {
            System.out.println("---------- Find All ------------");
            List<Student> listOfAllStudents = dao.findAll();
            Iterator iterator = listOfAllStudents.iterator();

            if(listOfAllStudents.size() > 0) {
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } else {
                System.out.println(" There are no students to display. ");
            }
        });
        panel.add(findAll);



        exitBtn =  new JButton("Exit");
        exitBtn.addActionListener(e -> {
            System.out.println(" Bye, Bye!!! ");
            System.exit(0);
        });
        panel.add(exitBtn);



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Student GUI ");
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("----------- Save student ------------");
        Student cS = dao.save(new Student("Test2"));
        ++countSaved;
        System.out.println(" Call the function to save student " + countSaved);
        jLabel.setText("Added: " + countSaved + ", id: " + cS.getId());
        //jLabel.setText("Added: " + countSaved + ", Name:" + cS.getName() + ", id: " + cS.getId());
    }



}
