package se.lexicon;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.StudentDao;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring" );

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean("studentD", StudentDao.class);


    }
}
