package algorithm.example.backjoon;
import java.io.*;
import java.util.*;

public class Backjoon1110 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        String input = br.readLine();
        int startNum = Integer.parseInt(input);
        int a, b, answer;
        int newNum = startNum;
        int count = 0;
        while (newNum != startNum || count == 0){
            count++;
            a = getRadixTwo(newNum);
            b = getRadixOne(newNum);
            answer = a + b;
            newNum = ((b * 10) + (answer % 10));
        }

        System.out.println(count);
    }

    public static int getRadixOne(int number){
        return number % 10;
    }

    public static int  getRadixTwo(int number){
        if (number < 10)
            return 0;
        return number / 10;
    }

}