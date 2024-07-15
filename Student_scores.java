
/**
 * Write a description of class Student_scores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Student_scores {
    static final int numberOfStudents = 6;
    static float[] marks = new float[numberOfStudents];
    static float largest = marks[0];
    static float smallest = marks[0];
     
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
            float mark = scanner_1.nextFloat();
            // try to write an error mesage code for wrong input, if it's a string and not an integer
            if (mark < 0 || mark > 30){
                 System.out.println("Invalid mark. Please enter a number from 0 to 30.");
                  i--;
                    } else {
                        marks[i] =mark;
                    }
                }
                

            System.out.println("Entered marks of 30 students: ");
            for(int j = 0; j < numberOfStudents; j++){
            System.out.println(marks[j]);
            
        }
            // algorithm for highest marks of marks[] array
          for(int k = 0; k < marks.length; k++){
                if (marks[k] > largest){
                    largest = marks[k];
                }
        }
            // problem: it displays negative numbers. gotta fix that.
            // problem: it always displays 0 as the smallest number.
            for (int l = 0; l < marks.length; l++){
                if (marks[l] < smallest){
                    smallest = marks[l];
        
                }
        }
            float sum = 0;
            
             for (int i = 0; i < numberOfStudents; i++) {
            sum = sum + marks[i];
        }
         float mean = sum / numberOfStudents;
         
         float summedDiff = 0;
         for (int i = 0; i < numberOfStudents; i++){
            summedDiff = summedDiff + (marks[i] - mean)*(marks[i] - mean);
        }
         summedDiff = summedDiff / numberOfStudents;

        float standardDeviation = (float) Math.sqrt(summedDiff);

        System.out.println("The highest score is " + largest + " and the lowest score is " + smallest);
        System.out.println("The mean of the scores is :" + mean);
        System.out.println("Standard Deviation is " + standardDeviation);
    }
}
