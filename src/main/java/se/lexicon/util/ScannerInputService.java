package se.lexicon.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;



@Component("userInputService")
public class ScannerInputService implements UserInputService {
    private Scanner scanner;



    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }



    @Override
    public String getString() {
        System.out.println(" Enter name of the student: ");
        String scannerValue = scanner.nextLine();

        if(scannerValue.length() < 1) throw new IllegalArgumentException(" Name is too short ");
        if(scannerValue.length() > 20) throw new IllegalArgumentException(" Name is too long ");

        return scannerValue;
    }



    @Override
    public int getInt() {
        int tmpInt = 0;
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



}
