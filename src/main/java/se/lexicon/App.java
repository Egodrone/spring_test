package se.lexicon;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.gui.Gui;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;
import java.util.List;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( " Spring Framework " );

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        Student createdStudent = dao.save(new Student("Test", 1));
        System.out.println("createdStudent = " + createdStudent);

        Student createdStudent2 = dao.save(new Student("Test2", 2));
        System.out.println("createdStudent2 = " + createdStudent2);

        System.out.println("-----------------------------");
        Student findStudent = dao.find(1);
        System.out.println("findStudent = " + findStudent);

        System.out.println("-----------------------------");
        List<Student> listStudents = dao.findAll();
        listStudents.forEach(System.out::println);
        System.out.println("-----------------------------");

        dao.delete(1);
        listStudents.forEach(System.out::println);


        /*
         *  GUI interface
         */

        Gui gui = new Gui();
        //StudentDao gui = context.getBean("guiStudent", Gui.class);
        //gui.actionPerformed();

        StudentManagement managementService = context.getBean("studentManagementDao", StudentManagement.class);
        Student createStudent1 = managementService.create();
        System.out.println(createStudent1.toString());

        System.out.println("************************************");

        //Util
        UserInputService userInputService = context.getBean(UserInputService.class);
        String testUtil = userInputService.getString();
        System.out.println(testUtil);



    }
}
