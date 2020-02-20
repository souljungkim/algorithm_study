package algorithm.example.hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Sorting_BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        /** Method A **/
        int swapCount = 0;
        int len = a.length;
        for (int i=0; i<len; i++){
            for (int j=1; j<len -i; j++){
                if (a[j] < a[j -1]){
                    swap(a, j, j -1);
                    swapCount++;
                }
            }
        }

        /** Method B **/
        // int swapCount = 0;
        // int len = a.length;
        // for (int i=0; i<len; i++){
        //     for (int j=0; j<len -1; j++){
        //         if (a[j] > a[j +1]){
        //             swap(a, j, j +1);
        //             swapCount++;
        //         }
        //     }
        // }

        System.out.println("Array is sorted in " +swapCount+ " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
