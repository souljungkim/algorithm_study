package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class TwoDArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE, cur;
        for (int y=1; y<arr.length-1; y++){
            for (int x=1; x<arr[y].length-1; x++){
                cur = sumOneHourglassFromCenter(arr, x, y);
                if (cur > max)
                    max = cur;
            }
        }
        return max;
    }

    static int sumOneHourglassFromCenter(int[][] arr, int x, int y){
        return arr[y-1][x-1] + arr[y-1][x] + arr[y-1][x+1]
                + arr[y][x]
                + arr[y+1][x-1] +arr[y+1][x] + arr[y+1][x+1];
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

