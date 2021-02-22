package se.lexicon.gui;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;

import java.util.Iterator;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Gui implements ActionListener {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    StudentDao dao = context.getBean("studentDao", StudentDao.class);

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
        Font myFontSize = saveTxt.getFont().deriveFont(Font.BOLD,50f);
        saveTxt.setFont(myFontSize);
        container.add(saveTxt, BorderLayout.NORTH);

        panel.setBorder(BorderFactory.createEmptyBorder(160, 160, 160, 160));
        panel.setLayout(new GridLayout(4,4,4,4));

        // save student btn
        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        jLabel = new JLabel("Saved Students");
        panel.add(jLabel);
        panel.add(saveStudentBtn);



        findBtn = new JButton("Find student");
        JLabel findBtnLabel = new JLabel("Find Student by id");
        panel.add(findBtnLabel);
        panel.add(findBtn);



        deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(e -> {
            List<Student> listOfAllStudents = dao.findAll();
            System.out.println("hhhehhehehhe");
            listOfAllStudents.forEach(System.out::println);
            Iterator iterator = listOfAllStudents.iterator();

            while(iterator.hasNext()){
                System.out.println("next \n" + iterator.next());
            }
            if(listOfAllStudents != null) {
                dao.delete(1);
            } else {
                System.out.println("Student you want to remove does not exist");
            }
            System.out.println("Delete button!");
        });
        panel.add(deleteBtn);



        findAll =  new JButton("Find All");
        findAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Find All");
            }
        });
        panel.add(findAll);



        exitBtn =  new JButton("Exit");
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Buy, Buy!!!");
                System.exit(0);
            }
        });
        panel.add(exitBtn);



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
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //StudentDao dao = context.getBean("studentDao", StudentDao.class);
        Student cS = dao.save(new Student("Test2"));
        ++countSaved;
        System.out.println("Call the function to save student " + countSaved);
        jLabel.setText("Added: " + countSaved + ", id: " + cS.getId());
        //jLabel.setText("Added: " + countSaved + ", Name:" + cS.getName() + ", id: " + cS.getId());
    }



}
