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
            }
        }
    }
}
