package se.lexicon;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;



public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring" );

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        Student createdStudent = dao.save(new Student("Test", 1));
        System.out.println("createdStudent = " + createdStudent);

    }
}
