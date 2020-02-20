package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon10870_Fibonacci {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        int input = Integer.parseInt(br.readLine());
        System.out.println( fibonacci(input) );
        br.close();
    }


    public static int fibonacci(int num){
        if (num == 0){
            return 0;
        }else if (num == 1){
            return 1;
        }
        return fibonacci(num -2) + fibonacci(num -1);
    }

}
