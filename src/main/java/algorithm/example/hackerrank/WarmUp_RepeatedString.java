package algorithm.example.hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class WarmUp_RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] chrIn = s.toCharArray();
        int i = -1;
        int originalLength = chrIn.length;
        long foundCount = 0;
        long quo = n / originalLength;
        long rem = n % originalLength;
        while (++i < originalLength){
            if (chrIn[i] == 'a')
                foundCount++;
        }
        foundCount *= quo;
        i = -1;
        while (++i < rem){
            if (chrIn[i] == 'a')
                foundCount++;
        }
        return foundCount;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

