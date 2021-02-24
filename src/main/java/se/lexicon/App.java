package se.lexicon;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.gui.Gui;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.service.StudentManagementConsoleImpl;
import se.lexicon.util.UserInputService;
import java.util.List;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( " Spring Framework " );

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*
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
        */

        /*
         *  GUI interface
         */

        //Gui gui = new Gui();
        //StudentDao gui = context.getBean("guiStudent", Gui.class);
        //gui.actionPerformed();

        System.out.println("************************************");
        //StudentManagement managementService = context.getBean("studentManagementService", StudentManagement.class);
        //Student createStudent1 = managementService.create();
        //System.out.println(createStudent1.toString());

        System.out.println("************************************");

        //Util
        /*
        UserInputService userInputService = context.getBean(UserInputService.class);
        String testUtil = userInputService.getString();
        System.out.println(testUtil);
        */

        //Service
        System.out.println("+++++++++ Service layer +++++++++++++");
        StudentManagementConsoleImpl studentManagementConsole =
                context.getBean("studentManagementService", StudentManagementConsoleImpl.class);
        System.out.println("------------------- Create new student -------------------");

        System.out.println("------------------- Save new student -------------------");
        Student createdStudent3 = studentManagementConsole.save(new Student("Nils", 900));
        Student createdStudent30 = studentManagementConsole.save(new Student("Joe"));
        //Student createdStudent4 = studentManagementConsole.save(new Student());
        System.out.println(createdStudent3.toString());

        System.out.println("------------------- Find student by id -------------------");
        Student findStudentById = studentManagementConsole.find(900);
        System.out.println(findStudentById.toString());

        System.out.println("------------------- Find all students -------------------");
        List<Student> listOfAllStudents = studentManagementConsole.findAll();
        listOfAllStudents.forEach(System.out::println);

        System.out.println("------------------- Remove student -------------------");
        Student studentToRemove = studentManagementConsole.remove(900);
        System.out.println(" Removed student: " + studentToRemove);

        System.out.println("------------------- Scanner (Create Student) -------------------");
        Student testStudent8 = studentManagementConsole.create();
        System.out.println(testStudent8.toString());
        //call save method
        Student createdStudent31 = studentManagementConsole.save(testStudent8);

        System.out.println("------------------- Scanner (Edit Student) -------------------");
        Student editStudent = studentManagementConsole.edit(createdStudent31);
        System.out.println(editStudent.toString());


    }
}
