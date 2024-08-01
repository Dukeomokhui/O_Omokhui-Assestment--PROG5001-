import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assessment_2 {
    
     static class StudentRecord {
        String fullName;
        String studentId;
        }
   public static void main(String[] args) {
        // Create BufferedReader to read input from the console
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter the name of the text file: "); // Gets the filename
            String filename = consoleReader.readLine().trim();// Stores the value in a string. Trims the input of unnecessary spaces
            
            if (filename.isEmpty()) {
                System.out.println("No filename provided. Exiting..."); // Error check if there is no input provided
                return;
            }
            // Reads the file and process student records
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String line;
            String unitName = null;
            
            if ((line = reader.readLine()) != null) {
                unitName = line.split(":")[1].trim();
                System.out.println("Unit Name: " + unitName);
            }else {
                 System.out.println("The file is empty or is wrongly formatted.");
                return;
            }
            
             System.out.println("Student Marks:");
             while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String studentName = parts[0].trim();
                    String marks = parts[1].trim();
                    System.out.println(studentName + ": " + marks);
                } else {
                    System.out.println("Incorrect format for line: " + line);
                }
        }
    } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
