package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1094 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int length = 64;

        while (x > 0){
            if (length > x){
                length /= 2;
            }else{
                count++;
                x -= length;
            }
        }
        System.out.println( sb.append(count) );
        br.close();
    }


}
