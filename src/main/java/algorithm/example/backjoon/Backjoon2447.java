package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon2447 {

    static String[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        int input = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();
        array = new String[input][input];
        for (int i=0; i<input; i++){
            Arrays.fill(array[i], " ");
        }
        star(input, 0, 0);

        for (int i=0; i<input; i++){
            for (int j=0; j<input; j++){
                sb.append(array[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void star(int n, int x, int y){
        if (n == 1){
            array[y][x] = "*";
            return;
        }

        star(n/3, x, y);
        star(n/3, x+n/3, y);
        star(n/3, x+n/3*2, y);

        star(n/3, x, y+n/3);
        star(n/3, x+n/3*2, y+n/3);

        star(n/3, x, y+n/3*2);
        star(n/3, x+n/3, y+n/3*2);
        star(n/3, x+n/3*2, y+n/3*2);
    }


}
