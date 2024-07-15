
/**
 * Write a description of class Student_scores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Student_scores {
     
    public static void main(String[] args) {
    int numberOfStudents = 5;
    float[] marks = new float[numberOfStudents];

        Scanner scanner = new Scanner(System.in);
        
            System.out.print("What is the name of the Assignment: ");
            //Enabling input from user
            String whatIsAssignmentName = scanner.nextLine();
            //Trim function to get rid of unwanted space characters
            System.out.println("The name of the Assignment is " + whatIsAssignmentName.trim());
            
            System.out.println("Input marks for 30 students in " + whatIsAssignmentName + ": ");
            
            for(int i = 0; i < numberOfStudents; i++){
              boolean validInput = false;
              while (!validInput){
                  try{
                      System.out.println("Enter marks)
                  }
              }
            Scanner scanner_1 = new Scanner(System.in);
            int mark = scanner_1.nextInt();
            // try to write an error mesage code for wrong input, if it's a string and not an integer
            if (mark < 0 || mark > 30){
                 System.out.println("Invalid mark. Please enter a number from 0 to 30.");
                  i--;
                    } else {
                        marks[i] =mark;
                    }
                }
                

            System.out.println("Entered marks of 30 students: ");
            for(int i = 0; i < numberOfStudents; i++){
            System.out.println(marks[i]);
            
        }
            // algorithm for highest marks of marks[] array
            
            float largest = marks[0];
            float smallest = marks[0];
            
            for(int i = 1; i < marks.length; i++){
                if (marks[i] > largest){
                    largest = marks[i];
                }
        }
            // problem: it displays negative numbers. gotta fix that.
            // problem: it always displays 0 as the smallest number.
            for (int i = 0; i < marks.length; i++){
                if (marks[i] < smallest){
                    smallest = marks[i];
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
