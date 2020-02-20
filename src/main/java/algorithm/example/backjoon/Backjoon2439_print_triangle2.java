package algorithm.example.backjoon;

import java.util.*;

public class Backjoon2439_print_triangle2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        StringBuilder sb = new StringBuilder();
        String enter = System.lineSeparator();
        for (int i=0; i<input; i++){
            for (int j=0; j<input -i -1; j++){
                sb.append(" ");
            }
            for (int j=0; j<i+1; j++){
                sb.append("*");
            }
            sb.append(enter);
        }
        System.out.println(sb);
    }
}
