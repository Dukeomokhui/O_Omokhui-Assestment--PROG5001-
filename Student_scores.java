import java.util.Scanner;
import java.util.InputMismatchException;

public class Student_scores {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Enables input from the user through the computers portal
        int numberOfStudents = 5; // variable for number of students
        float[] marks = new float[numberOfStudents]; //Array called marks to contain input of numbers 
        
        System.out.print("What is the name of the Assignment: ");
        String whatIsAssignmentName = scanner.nextLine().trim(); //Trim function to get rid of unwanted space characters
        System.out.println("The name of the Assignment is " + whatIsAssignmentName + ".");
        
        System.out.println("Please input marks for " + numberOfStudents + " students in " + whatIsAssignmentName + " Assignment: ");
        
        
        for(int i = 0; i < numberOfStudents; i++) {
            boolean validInput = false; // creating a boolean value for input validation
            
            while (!validInput) {
                try {
                    System.out.print("Enter marks for student " + (i + 1) + ": ");
                    int mark = scanner.nextInt(); // Algorithm to identify a mark to a specific student e.g student 1 = 2
                    // input validation for a specific range of marks
                    if (mark < 0 || mark > 30) {
                        System.out.println("Invalid mark. Please enter a number from 0 to 30.");
                    } else {
                        marks[i] = mark;
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number from 0 to 30. Do not enter a word.");
                    scanner.next(); // Clear the previous invalid input
                } //Algorithm to handle the input error 
            }
        }
        
        System.out.println("Entered marks of " + numberOfStudents + " students: "); // Displays entered marks of 30 students
        for(int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]); //Algorithm to identify a mark to a specific student e.g student 1 = 2
        }
        
        float largest = marks[0]; // Find largest and smallest marks
        float smallest = marks[0]; // Find largest and smallest marks
        
        for(int i = 1; i < marks.length; i++) {
            if (marks[i] > largest) {
                largest = marks[i];
            }
            if (marks[i] < smallest) {
                smallest = marks[i];
            }
        }
        
        // Mean calculation
        float sum = 0;
        for (float mark : marks) {
            sum += mark;
        }
        float mean = sum / numberOfStudents;
        
        // Standard deviation calculation
        float summedDiff = 0;
        for (float mark : marks) {
            summedDiff += (mark - mean) * (mark - mean);
        }
        float standardDeviation = (float) Math.sqrt(summedDiff / numberOfStudents);

        // Output results of my calculations
        System.out.println("The highest score out of the 30 students is " + largest);
        System.out.println("The lowest score out of the 30 students is " + smallest);
        System.out.println("The mean of the scores is: " + mean);
        System.out.println("Standard Deviation is: " + standardDeviation);
        
        scanner.close(); // Close the scanner at the end of the program to prevent further input
    }
}
