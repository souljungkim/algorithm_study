package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;


public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int targetLength = a.length();
        int matcherLength = b.length();
        int matcherIndex = 0;
        boolean matching = false;
        for (int i=0; i<targetLength; i++){
            char target = a.charAt(i);
            char matcher = b.charAt(matcherIndex);
            if (matcherIndex < matcherLength
                    && (
                    target == matcher
                            || ((int)target -'a') == ((int)matcher -'A'))
            ){ //Matching
                matcherIndex++;
                matching = true;
            }else if (target -'a' > -1){ //Discard
            }else{ //No
                matching = false;
            }
        }
        return (matching) ? "YES" : "NO";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            String a = scanner.nextLine();
//
//            String b = scanner.nextLine();
//
//            String result = abbreviation(a, b);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();

        String result = abbreviation("beFgH", "EFH");
        System.out.println(result);
    }
}

