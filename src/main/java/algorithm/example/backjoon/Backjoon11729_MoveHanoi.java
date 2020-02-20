package algorithm.example.backjoon;

import java.util.Scanner;

public class Backjoon11729_MoveHanoi {


    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) { // write your code here
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        moveHanoi(1, 3, 2, count);

        System.out.println((int) Math.pow(2, count) - 1);
        System.out.println(sb);
    }

    public static void moveHanoi(int from, int to, int center, int count) {
        if (count == 0){
            return;
        }else if (count == 1){
            sb.append(from + " " + to);
            sb.append(System.lineSeparator());
        }else{
            moveHanoi(from, center, to, count - 1);
            sb.append(from + " " + to);
            sb.append(System.lineSeparator());
            moveHanoi(center, to, from, count - 1);
        }
    }


}
