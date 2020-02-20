package algorithm.example.backjoon;

import java.io.*;
import java.util.*;
public class Backjoon11651 {

    public static void main (String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int[][] points = new int[count][2];
        for (int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        SortHelper.sort(points, 0, count -1);
//        SortHelper.arraySort(points);

        int[] point;
        for (int i=0; i<points.length; i++){
            point = points[i];
            sb.append(point[0]).append(" ").append(point[1]).append(System.lineSeparator());
        }
        System.out.print(sb);
    }





    static class SortHelper {

        public static void arraySort(int[][] array){
            Arrays.sort(array, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[1] == b[1])
                        return Integer.compare(a[0], b[0]);
                    else
                        return Integer.compare(a[1], b[1]);
                }
            });
        }

        public static void sort(int[][] array, int s, int e){
            int pivot = partitioning(array, s, e);
            if (s < pivot -1)
                sort(array, s, pivot -1);
            if (pivot < e)
                sort(array, pivot, e);
        }

        public static int partitioning(int[][] array, int s, int e){
            int[] pivotValue = array[(s + e)/2];
            while (s <= e){
                while(array[s][1] < pivotValue[1] || (array[s][1] == pivotValue[1] && array[s][0] < pivotValue[0]))
                    s++;
                while(array[e][1] > pivotValue[1] || (array[e][1] == pivotValue[1] && array[e][0] > pivotValue[0]))
                    e--;
                if (s <= e){
                    swap(array, s, e);
                    s++;
                    e--;
                }
            }
            return s;
        }

        public static void swap(int[][] array, int a, int b){
            int[] tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }

    }

}

