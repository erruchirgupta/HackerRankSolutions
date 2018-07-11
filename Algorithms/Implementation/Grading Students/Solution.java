import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
      
        /*grades[i] = ((grades[i]+2) % 5 == 0 && grades[i] > 37) ? grades[i]+2 
                       :((grades[i]+1) % 5 == 0 && grades[i] > 37) ? grades[i]+1 : grades[i];*/
        
      /*for(int i=0; i < grades.length; i++)  
        grades[i] = (grades[i]<38 || grades[i]%5 < 3) ? grades[i] : grades[i]+(5-(grades[i]%5));
        
        return grades;*/
        
        return Arrays.stream(grades)
                .map(grade -> (grade < 38) || (grade % 5 < 3)? grade :
                 grade+(5-(grade%5))).toArray();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
