package algorithm.example.backjoon;

import java.util.Scanner;

public class Backjoon2438_print_triangle {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int input = in.nextInt();
        String enter = System.lineSeparator();
        for (int i=0; i<input; i++){
            for (int j=0; j<i +1; j++){
                sb.append("*");
            }
            sb.append(enter);
        }

        System.out.println(sb);
    }
}
