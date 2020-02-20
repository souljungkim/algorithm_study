package algorithm.example.backjoon;

import java.util.*;

public class Backjoon10809_char {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int codeA = (int) 'a';
        int codeZ = (int) 'z';
        for (int i=codeA, foundIndex; i<=codeZ; i++){
            char c = (char) i;
            foundIndex = input.indexOf(c);
            sb.append(foundIndex).append(" ");
        }
        System.out.print(sb);
    }
}
