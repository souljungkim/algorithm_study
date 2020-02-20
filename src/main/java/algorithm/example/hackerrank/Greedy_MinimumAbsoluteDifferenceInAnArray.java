package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Greedy_MinimumAbsoluteDifferenceInAnArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        /** Method A - Not Good **/
//        int length = arr.length;
//        int minAbsDifValue = Integer.MIN_VALUE;
//        for (int i=0; i<length; i++){
//            for (int j=i+1, chk; j<length; j++){
//                chk = Math.abs(arr[i] - arr[j]);
//                if (minAbsDifValue > chk)
//                    minAbsDifValue = chk;
//            }
//        }
//        return minAbsDifValue;

        /** Method B - Good **/
        int length = arr.length;
        Arrays.sort(arr);
        int minAbsDifValue = Integer.MAX_VALUE;
        for (int i=0, chk; i<length-1; i++){
            chk = Math.abs(arr[i] - arr[i+1]);
            if (minAbsDifValue > chk)
                minAbsDifValue = chk;
        }
        return minAbsDifValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        int[] arr = {3 , -7, 0};
        int result = minimumAbsoluteDifference(arr);
        System.out.println (result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
