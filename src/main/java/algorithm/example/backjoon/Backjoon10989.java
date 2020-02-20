package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Backjoon10989 {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());
        int[] array = new int[input];
        for (int i=0; i<input; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        MergeSortHelper.sort(array);

        for (int i=0; i<input; i++){
            sb.append(array[i]).append(System.lineSeparator());
        }
        System.out.print(sb);
    }


    static class MergeSortHelper {

        public static void sort(int[] array){
            int[] tempArray = new int[array.length];
            mergeSort(array, tempArray, 0, array.length -1);
        }

        public static void mergeSort(int[] array, int[] tempArray, int s, int e){
            if (s < e){
                int m = (s + e) /2;
                mergeSort(array, tempArray, s, m);
                mergeSort(array, tempArray, m +1, e);
                merge(array, tempArray, s, m, e);
            }
        }

        public static void merge(int[] array, int[] tempArray, int s, int m, int e){
            for (int i=s; i<e +1; i++)
                tempArray[i] = array[i];
            int p1 = s;
            int p2 = m +1;
            int index = s;
            while (p1 < m +1 && p2 < e +1){
                if (tempArray[p1] <= tempArray[p2]){
                    array[index] = tempArray[p1];
                    p1++;
                }else{
                    array[index] = tempArray[p2];
                    p2++;
                }
                index++;
            }
            for (int i=0; i<m - p1 +1; i++)
                array[index +i] = tempArray[p1 +i];
        }

    }

}





