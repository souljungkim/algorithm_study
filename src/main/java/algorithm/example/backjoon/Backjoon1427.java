package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Backjoon1427 {

    public static void main (String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        String input = br.readLine();
        int dataLength = input.length();
        Integer[] dataArray = new Integer[dataLength];
        for (int i=0; i<dataLength; i++)
            dataArray[i] = input.charAt(i) -'0';

        Arrays.sort(dataArray, Collections.reverseOrder());

        for (int i=0; i<dataLength; i++)
            sb.append(dataArray[i]);
        System.out.print(sb);
    }

}
