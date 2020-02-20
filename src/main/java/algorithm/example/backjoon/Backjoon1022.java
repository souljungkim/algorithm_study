package algorithm.example.backjoon;

import java.util.*;
import java.io.*;

public class Backjoon1022 {

    static int r1, c1, r2, c2;
    static int maxArraySize, maxValue, maxValueSize;
    static int count = 0;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        int width = Math.abs(c2 -c1) +1;
        int height = Math.abs(r2 -r1) +1;
        maxArraySize = width * height;
        maxValue = 0;
        int[][] soyong = new int[50][5];


        int addition = 1;
        int value = 0;
        int length = 1;
        int x=0, y=0, dir = 0;
        checkToArray(soyong, x, y, ++value);
        while (count < maxArraySize){
            //Method A
//            dir %= 4;
//            if (dir == 2 || dir == 0)
//                length++;
//            for (int i=0; i<length; i++){
//                x += moveX[dir];
//                y += moveY[dir];
//                checkToArray(soyong, x, y, ++value);
//            }
//            dir++;
            //Method B
            for (int i=0; i<length; i++){
                x += addition;
                checkToArray(soyong, x, y, ++value);
            }
            addition *= -1;
            for (int i=0; i<length; i++){
                y += addition;
                checkToArray(soyong, x, y, ++value);
            }
            length++;
        }

        maxValueSize = getLength(maxValue);

        int val = 0;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                val = soyong[i][j];
                for (int k=getLength(val); k<maxValueSize; k++)
                    sb.append(" ");
                sb.append(val + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static int getLength(int value){
        int result = 1;
        while(value >= 10){
            value /= 10;
            result++;
        }
        return result;
    }

    public static void checkToArray(int[][] soyong, int x, int y, int value){
        if (r1 <= y && y <= r2 && c1 <= x && x <= c2){
            soyong[y -r1][x -c1] = value;
            maxValue = value;
            count++;
        }
    }




}
