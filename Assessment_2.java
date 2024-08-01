import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assessment_2 {
    
     static class StudentRecord {
        String fullName;
        String studentId;
        double mark1;
        double mark2;
        double mark3;
        double total;
        
            
        StudentRecord(String fullName, String studentId, double mark1, double mark2, double mark3, double total) {
            this.fullName = fullName;
            this.studentId = studentId;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
            this.total = total;
        }
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
            List<StudentRecord> studentRecords = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String line;
            String unitName = null;
            
            //Read the first line to get the unit name
             if ((line = fileReader.readLine()) != null) {
                // Extracts the unit name for the first line
                if (line.startsWith("Unit,")) {
                    unitName = line.substring("Unit,".length()).trim();
                    System.out.println("Unit Name: " + unitName);
            }else {
                 System.out.println("The file is empty or is wrongly formatted.");
            }
            
            if ((line = fileReader.readLine()) != null) {
                    // Assuming the header line is properly formatted and can be skipped
                }
            // Process student records
            System.out.println("\nStudent Records:");
            System.out.printf("%-30s %-10s %-5s %-5s %-5s %-7s%n",
                        "Name", "Student ID", "A1", "A2", "A3", "Total"); // Print out String in a specific format
            while ((line = fileReader.readLine()) != null) {
            // Skip comment lines and empty lines
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                        continue;
                    }
                    
                // Split the line by commas
                String[] parts = line.split(",");
                
                // Check if the line has the expected number of parts
                if (parts.length >= 5) {
                    String lastName = parts[0].trim();
                    String firstName = parts[1].trim();
                    String studentId = parts[2].trim();
                    String a1 = parts[3].trim();
                    String a2 = parts[4].trim();
                    String a3 = (parts.length > 5) ? parts[5].trim() : "";

    }    catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

