package algorithm.example.backjoon;

import java.util.*;
import java.io.*;


public class Backjoon11650 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        StringTokenizer st;
        int input = Integer.parseInt(br.readLine());
        int[][] points = new int[input][2];
        for (int i=0; i<input; i++){
            st = new StringTokenizer(br.readLine());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort( points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[1] == b[1]){
                    return Integer.compare(a[0], b[0]);
                }else{
                    return Integer.compare(a[1], b[1]);
                }
            }
        });

        String enter = System.lineSeparator();
        for (int i=0; i<input; i++){
            sb.append(points[i][1]).append(" ").append(points[i][0]).append(enter);
        }

        System.out.print(sb);
    }
}