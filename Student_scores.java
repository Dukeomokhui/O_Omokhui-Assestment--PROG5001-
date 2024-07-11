
/**
 * Write a description of class Student_scores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Student_scores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
            System.out.print("What is the name of the Assignment: ");
            //Enabling input from user
            String whatIsAssignmentName = scanner.nextLine();
            //Trim function to get rid of unwanted space characters
            System.out.println("The name of your Assignment is " + whatIsAssignmentName.trim());
            
            System.out.println("Input marks for 30 students in " + whatIsAssignmentName + ": ");
            
            for(int i = 0; i < numberOfStudents; i++){
            Scanner scanner_1 = new Scanner(System.in);
            marks[i] = scanner_1.nextFloat();
        }

            
            
    }
}
