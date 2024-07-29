import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Assessment_2 {
   public static void main(String[] args) {
        String fileName = "prog5001_students_grade_2022.csv"; // Name of the file to read
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
                if (parts.length == 5) {
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
