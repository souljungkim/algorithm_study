package algorithm.example.backjoon;

import java.util.*;

public class Backjoon11720 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int inputForCount = Integer.parseInt(in.nextLine());
        String stringForNumbers = in.nextLine();

        int result = 0;
        for (int i=0; i<inputForCount; i++){
            result += (stringForNumbers.charAt(i) -'0');
        }
        System.out.print(result);
    }

}
