package se.lexicon;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import java.util.List;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Spring" );

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
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




    }
}
