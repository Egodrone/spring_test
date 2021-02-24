package se.lexicon.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Scanner;



@Component("userInputService")
public class ScannerInputService implements UserInputService{
    private Scanner scanner;



    @Override
    public String getString() {
        String test = "test of the ScannerInputService";
        return test;
    }



    @Override
    public int getInt() {
        return 0;
    }


    /*
    @Autowired
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
    */


}
