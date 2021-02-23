package se.lexicon.util;



import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Scanner;



//@Configuration
@Component("userInputService")
public class ScannerInputService implements UserInputService{
    private Scanner scanner = new Scanner(System.in);



    @Override
    public String getString() {
        String test = "test of the ScannerInputService";
        return test;
    }



    @Override
    public int getInt() {
        return 0;
    }


}
