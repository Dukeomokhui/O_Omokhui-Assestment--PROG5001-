
/**
 * Write a description of class Student_scores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Student_scores {
    static final int numberOfStudents = 30;
    static float[] marks = new float[numberOfStudents];
    static float largest = marks[0];
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
            System.out.print("What is the name of the Assignment: ");
            //Enabling input from user
            String whatIsAssignmentName = scanner.nextLine();
            //Trim function to get rid of unwanted space characters
            System.out.println("The name of your Assignment is " + whatIsAssignmentName.trim());
            // write an error mesage code for wrong input
            System.out.println("Input marks for 30 students in " + whatIsAssignmentName + ": ");
            
            for(int i = 0; i < numberOfStudents; i++){
            Scanner scanner_1 = new Scanner(System.in);
            marks[i] = scanner_1.nextFloat();
            // write an error message for wrong input
        }

            System.out.println("Entered marks: ");
            for(int j = 0; j < numberOfStudents; j++){
            System.out.println(marks[j]);
            
        }
            // algorithm for highest marks of marks[] array
    }       for(int k = 0; k < marks.length; k++){
                if (marks[k] > largest){
                    largest = marks[k];
                }
            }
    
}
