package se.lexicon.gui;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagementConsoleImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;



//@Component("guiService")
public class GuiService implements ActionListener {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    StudentManagementConsoleImpl studentManagementService =
            context.getBean("studentManagementService", StudentManagementConsoleImpl.class);

    private int countSaved = 0;

    private final JPanel panel;
    private final JFrame frame;
    //private final JLabel jLabel;
    //private final JLabel createLabel;

    private final JButton saveStudentBtn;
    private final JButton createStudentBtn;
    private final JButton deleteBtn;
    private final JButton findAll;
    private final JButton exitBtn;
    private final JButton findBtn;

    private final Container container;
    private final JTextField saveTxt;

    private Student studentTmp;
    private Student studentSaved;



    public GuiService() {
        frame = new JFrame();
        panel = new JPanel();
        container = frame.getContentPane();

        saveTxt = new JTextField(50);
        Font myFontSize = saveTxt.getFont().deriveFont(Font.BOLD,40f);
        saveTxt.setFont(myFontSize);
        container.add(saveTxt, BorderLayout.NORTH);

        panel.setBorder(BorderFactory.createEmptyBorder(100, 160, 160, 160));
        panel.setLayout(new GridLayout(4,4,4,4));


        JLabel displayInfo = new JLabel(" Information ");
        displayInfo.setBounds(400,400,400,400);




        //saveStudentBtn = new JButton("Save student", new ImageIcon("path/file.gif"));
        /*
        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(this::actionPerformed);
        jLabel = new JLabel("Saved Students");
        panel.add(jLabel);
        panel.add(saveStudentBtn);
        */



        JTextField createText = new JTextField(20);
        createText.setBounds(100, 20, 165, 25);
        createText.addActionListener(e -> {
            System.out.println("---------- Create field ------------");
        });
        panel.add(createText);



        createStudentBtn = new JButton("Create student");
        createStudentBtn.addActionListener(e -> {
            System.out.println("---------- Create Student GUI ------------");
            //String newName = createText.getText();
            studentTmp = studentManagementService.create();
            System.out.println(studentTmp.toString());
        });
        panel.add(createStudentBtn);



        saveStudentBtn = new JButton("Save student");
        saveStudentBtn.addActionListener(e -> {
            System.out.println("---------- Save Student GUI ------------");

            if(studentTmp.getId() < 1) {
                displayInfo.setText("Student was not saved, invalid id");
                throw new IllegalArgumentException("Student was not saved");
            }
            studentSaved = studentManagementService.save(studentTmp);
            System.out.println("Student was saved: " + studentSaved.getName() + ", and id: " + studentSaved.getId());
            displayInfo.setText("Student was saved: " + studentSaved.getName() + ", and id: " + studentSaved.getId());
        });
        panel.add(saveStudentBtn);



        JTextField findText = new JTextField(20);
        findText.setBounds(100, 20, 165, 25);
        findText.addActionListener(e -> {
            System.out.println("---------- Test field ------------");
        });
        panel.add(findText);



        findBtn = new JButton("Find student");
        findBtn.addActionListener(e -> {
            System.out.println("---------- Find Student By Id GUI ------------");
        });
        panel.add(findBtn);



        deleteBtn = new JButton("Remove");
        deleteBtn.addActionListener(e -> {
            System.out.println("---------- Remove student GUI ------------");
            java.util.List<Student> listOfAllStudents = studentManagementService.findAll();
            int deleteId = 0;

            if(listOfAllStudents.size() > 0) {

                for (Student studentList : listOfAllStudents) {
                    deleteId = studentList.getId();
                    displayInfo.setText(" Student with name: " + studentList.getName()
                            .toUpperCase(Locale.ROOT) + " was removed");
                    studentManagementService.remove(deleteId);

                    break;
                }

                System.out.println(" Student with id: " + deleteId + " was removed ");
            } else {
                System.out.println(" There is no students left to remove ");
                displayInfo.setText(" There is no students left to remove ");
            }
        });
        JLabel deleteBtnLabel = new JLabel("Remove Student by id");
        panel.add(deleteBtnLabel);
        panel.add(deleteBtn);



        findAll =  new JButton("Find All");
        findAll.addActionListener(e -> {
            System.out.println("---------- Find All GUI ------------");
            List<Student> listOfAllStudents = studentManagementService.findAll();
            Iterator iterator = listOfAllStudents.iterator();

            if(listOfAllStudents.size() > 0) {
                while(iterator.hasNext()) {
                    System.out.println(iterator.next());
                    //String tmpName = iterator.next().toString().trim();
                    //System.out.println(tmpName);
                    //displayInfo.setText(iterator.next().toString());
                }
            } else {
                System.out.println(" There are no students to display ");
                displayInfo.setText(" There are no students to display ");
            }
        });
        panel.add(findAll);



        exitBtn =  new JButton("Exit");
        exitBtn.addActionListener(e -> {
            System.out.println(" Bye, Bye!!! ");
            System.exit(0);
        });
        panel.add(exitBtn);




        panel.add(displayInfo);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Student GUI ");
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("----------- Save student ------------");
        Student cS = studentManagementService.save(new Student("Test2"));
        ++countSaved;
        System.out.println(" Call the function to save student " + countSaved);
        //JLabel jLabel;
        //jLabel.setText("Added: " + countSaved + ", id: " + cS.getId());
    }



}
