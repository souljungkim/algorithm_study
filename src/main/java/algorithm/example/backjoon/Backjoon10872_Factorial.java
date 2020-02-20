package algorithm.example.backjoon;

import java.util.*;
import java.io.*;

public class Backjoon10872_Factorial {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        int input = Integer.valueOf(br.readLine());
        System.out.print( factorial(input) );
    }

    public static int factorial(int num){
        if (num < 2)
            return 1;
        return num * factorial(num -1);
    }

}