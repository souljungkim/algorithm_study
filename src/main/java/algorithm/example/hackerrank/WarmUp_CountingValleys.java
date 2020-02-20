package algorithm.example.hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class WarmUp_CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int depth = 0;
        int countValley = 0;
        for (int i=0; i<n; i++){
            if (s.charAt(i) == 'D'){
                depth--;
            }else{
                depth++;
                if (depth == 0)
                    countValley++;
            }
        }
        return countValley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
