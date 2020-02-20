package algorithm.example.backjoon;

import java.io.*;
import java.util.*;

public class Backjoon2108_statistics {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        int input = Integer.parseInt(br.readLine());
        int[] dataArray = new int[input];
        for (int i=0; i<input; i++)
            dataArray[i] = Integer.parseInt(br.readLine());
        br.close();

        String enter = System.lineSeparator();
        Arrays.sort(dataArray);
        sb.append(avg(dataArray)).append(enter)
            .append(center(dataArray)).append(enter)
            .append(popular(dataArray)).append(enter)
            .append(range(dataArray)).append(enter);
        System.out.print(sb);
    }


    public static int avg(int[] array){
        int sum = 0;
        for (int i=0; i<array.length; i++)
            sum += array[i];
        return (int) Math.round((double) sum / array.length);
    }

    public static int center(int[] sortedArray){
        return sortedArray[sortedArray.length /2];
    }

    public static int popular(int[] array){
        int valueForMaxCount = 0, maxCount = 0, secondValueForMaxCount = 0;
        boolean hasSecond = false;
        int[] tempArray = new int[8001];
        for (int i=0; i<array.length; i++)
            tempArray[array[i] +4000]++;
        for (int i=0; i<tempArray.length; i++){
            if (maxCount < tempArray[i]){
                maxCount = tempArray[i];
                valueForMaxCount = i -4000;
                hasSecond = false;
            }else if(maxCount == tempArray[i] && !hasSecond){
                secondValueForMaxCount = i -4000;
                hasSecond = true;
            }
        }
        return (hasSecond) ? secondValueForMaxCount : valueForMaxCount;
    }

    public static int range(int[] sortedArray){
        return sortedArray[sortedArray.length -1] - sortedArray[0];
    }

}
