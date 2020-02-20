package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Candies {

    // Complete the candies function below.
    static long candies(int length, int[] children) {
        int[] candies = new int[length];
        candies[0] = 1;

        // search forward sequences
        for (int i=1; i<length; i++){
            candies[i] = 1;
            if (children[i] > children[i -1])
                candies[i] = candies[i -1] +1;
        }

        // search reverse sequences
        for (int i=length -1; i>0; i--){
            if (children[i] < children[i -1])
                candies[i -1] = Math.max(candies[i -1], candies[i] +1);
        }

        long sum = 0;
        for (int i=0; i<candies.length; i++){
            sum += candies[i];
        }

        return sum;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
