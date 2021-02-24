package se.lexicon.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Scanner;



@Component("userInputService")
public class ScannerInputService implements UserInputService {
    private Scanner scanner;



    @Override
    public String getString() {
        //string from the scanner
        String test = "test of the ScannerInputService";
        return test;
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



    public Scanner getScanner() {
        return new Scanner(System.in);
    }



}
