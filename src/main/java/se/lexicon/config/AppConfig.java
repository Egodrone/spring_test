package se.lexicon.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.gui.Gui;
import se.lexicon.service.StudentManagement;
import se.lexicon.service.StudentManagementConsoleImpl;



@Configuration
@ComponentScan(basePackages = "se.lexicon.*")
public class AppConfig {
    /*
    @Bean("studentDao")
    public StudentDao studentDao(){

        return new StudentDaoImpl();
    }



    @Bean("guiStudent")
    public Gui gui(){

        return new Gui();
    }



    @Bean("studentManagementDao")
    public StudentManagement studentManagement(){

        return new StudentManagementConsoleImpl();
    }*/
}