import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class Assessment_2 {
    
     static class StudentRecord {
        String fullName;
        String studentId;
        }
   public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
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
