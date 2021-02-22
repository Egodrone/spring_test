package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring" );
        /*
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        AppUserDao dao = context.getBean("userAppDao", AppUserDao.class);
        AppUser createdAppUser = dao.saveOrUpdate(new AppUser("test","test.test@test.se","123456","Vaxjo"));
        System.out.println("createdAppUser = " + createdAppUser);
        */

    }
}
