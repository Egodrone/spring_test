package se.lexicon.util;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.Scanner;



@Component("userInputService")
public class ScannerInputService implements UserInputService {
    private Scanner scanner;



    @Override
    public String getString() {
        //string from the scanner
        scanner = getScanner();
        System.out.println(" Enter name of the student: ");
        String scannerValue = scanner.nextLine();

        if(scannerValue.length() < 1) throw new IllegalArgumentException(" Name is too short ");
        if(scannerValue.length() > 20) throw new IllegalArgumentException(" Name is too long ");

        return scannerValue;
    }



    @Override
    public int getInt() {
        //int from the scanner
        int tmpInt = 0;
        scanner = getScanner();
        System.out.println(" Enter id of the student: ");
        String scannerValue = scanner.nextLine();

        try {
            tmpInt = Integer.parseInt(scannerValue);
        } catch(NumberFormatException e) {
            System.out.println(" Not a valid number ");
        } catch(NullPointerException e) {
            System.out.println(" Please write a number ");
        }

        return tmpInt;
    }


    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }



}
