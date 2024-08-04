import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Assessment_2 {
    
    // Static class to hold student record data
     static class StudentRecord {
        String fullName;     // Full name of the student
        String studentId;   // Student ID
        double mark1;   // Marks for assessment 1
        double mark2;   // Marks for assessment 2
        double mark3;   // Marks for assessment 3
        double total;   // Total marks (sum of mark1, mark2, and mark3)
        
        // Constructor to initialize the student record    
        StudentRecord(String fullName, String studentId, double mark1, double mark2, double mark3, double total) {
            this.fullName = fullName;
            this.studentId = studentId;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
            this.total = total;
        }
    }
     // Helper method to parse and handle missing values in the text file
    private static double parseMark(String mark) {
        try {
            return mark.isEmpty() ? 0.0 : Double.parseDouble(mark);
        } catch (NumberFormatException e) {
            System.err.println("Invalid mark format: " + mark);
            return 0.0;
        }
    }
    
   public static void main(String[] args) {
        // Create BufferedReader to read input from the console
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter the name of the text file: "); // Gets the filename
            String filename = consoleReader.readLine().trim();// Stores the value in a string. Trims the input of unnecessary spaces
            
             // Check if the filename is empty
            if (filename.isEmpty()) {
                System.out.println("No filename provided. Exiting..."); // Error check if there is no input provided
                return; // Exit if no filename is provided
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
            }
            // Reads the header line
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

                     // Parse marks and calculate total
                    double mark1 = parseMark(a1);
                    double mark2 = parseMark(a2);
                    double mark3 = parseMark(a3);
                    double total = mark1 + mark2 + mark3;
                    
                    // Add student record to the list
                    studentRecords.add(new StudentRecord(
                                firstName + " " + lastName, studentId, mark1, mark2, mark3, total));
                                
                    // Print the student record
                    System.out.printf("%-30s %-10s %-5.1f %-5.1f %-5.1f %-7.1f%n",
                                firstName + " " + lastName, studentId, mark1, mark2, mark3, total);
                    } else {
                        System.out.println("Unexpected format for student record: " + line);
                    }
                }
            } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
            }
            
        // Prompt the user for a threshold value
        System.out.print("\nEnter the threshold for total marks: ");
            double threshold;
            try {
                threshold = Double.parseDouble(consoleReader.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid threshold value. Exiting...");
                return;
            }
            
        // Print students with total marks below the threshold
        System.out.println("\nStudents with total marks less than " + threshold + ":");
        System.out.printf("%-30s %-10s %-5s %-5s %-5s %-7s%n",
                    "Name", "Student ID", "A1", "A2", "A3", "Total");
                    
        for (StudentRecord record : studentRecords) {
                if (record.total < threshold) {
                    System.out.printf("%-30s %-10s %-5.1f %-5.1f %-5.1f %-7.1f%n",
                            record.fullName, record.studentId, record.mark1, record.mark2, record.mark3, record.total);
                }
            }
            
            // Sort student records by total marks using Selection algorithm
            Selectx(studentRecords, true);  // Sort in descending order for top 5

            // Print top 5 students with the highest total marks
            System.out.println("\nTop 5 Students with Highest Total Marks:");
            System.out.printf("%-30s %-10s %-5s %-5s %-5s %-7s%n",
                    "Name", "Student ID", "A1", "A2", "A3", "Total");
            printTopNStudents(studentRecords, 5);
                    
            // Sort student records by total marks using Selection algorithm
            Selectx(studentRecords, false);  // Sort in ascending order for bottom 5

            // Print top 5 students with the lowest total marks
            System.out.println("\nTop 5 Students with Lowest Total Marks:");
            System.out.printf("%-30s %-10s %-5s %-5s %-5s %-7s%n",
                    "Name", "Student ID", "A1", "A2", "A3", "Total");
            printTopNStudents(studentRecords, 5);
            
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    
    }
    // Selection algorithm to sort student records
    private static void Selectx(List<StudentRecord> list, boolean descending) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int indexToSwap = i;
            for (int j = i + 1; j < n; j++) {
                if ((descending && list.get(j).total > list.get(indexToSwap).total) ||
                        (!descending && list.get(j).total < list.get(indexToSwap).total)) {
                    indexToSwap = j;
                }
            }
            // Swap the found minimum/maximum element with the first element
            StudentRecord temp = list.get(indexToSwap);
            list.set(indexToSwap, list.get(i));
            list.set(i, temp);
        }
    }
    
    // Helper method to print top N students from a sorted list
    private static void printTopNStudents(List<StudentRecord> sortedRecords, int topN) {
        int count = 0;
        for (StudentRecord record : sortedRecords) {
            if (count < topN) {
                System.out.printf("%-30s %-10s %-5.1f %-5.1f %-5.1f %-7.1f%n",
                        record.fullName, record.studentId, record.mark1, record.mark2, record.mark3, record.total);
                count++;
            } else {
                break;
            }
        }
    }
}

