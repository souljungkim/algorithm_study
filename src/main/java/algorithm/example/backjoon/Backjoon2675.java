package algorithm.example.backjoon;

import java.util.*;

public class Backjoon2675 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int inputForCount = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();

        int repeatCount = 0;
        String word;
        int length;
        String enter = System.lineSeparator();
        for (int i=0; i<inputForCount; i++){
            String inputForData = in.nextLine();
            StringTokenizer st = new StringTokenizer(inputForData);
            repeatCount = Integer.parseInt(st.nextToken());
            word = st.nextToken();
            length = word.length();
            for (int j=0; j<length; j++){
                for (int r=0; r<repeatCount; r++)
                    sb.append(word.charAt(j));
            }
            sb.append(enter);
        }
        in.close();

        System.out.print(sb);
    }
}
