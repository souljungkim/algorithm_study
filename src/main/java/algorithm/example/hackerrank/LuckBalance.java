package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] c) {
        /** Method A **/
//        ArrayList<Integer> imp = new ArrayList<>();
//
//        if (imp.size() > 0){
//            Collections.sort(imp, Collections.reverseOrder());
//            for (int i=0; i<k; i++){
//                if (i > imp.size() -1)
//                    break;
//                luck += imp.get(i);
//            }
//
//            for (int i=k; i<imp.size(); i++){
//                luck -= imp.get(i);
//            }
//        }
//        return luck;


        /** Method B **/
        PriorityQueue<Integer> imp = new PriorityQueue<>(Collections.reverseOrder());

        int luck = 0;
        for (int row=0; row<c.length; row++){
            if (c[row][1] == 0)
                luck += c[row][0];
            else
                imp.add(c[row][0]);
        }

         boolean decreaseLuck = false;
         while (!imp.isEmpty()){
             if (k == 0)
                 decreaseLuck = true;
             if (decreaseLuck == true)
                 luck -= imp.poll();
             else
                 luck += imp.poll();
             k--;
         }
         return luck;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
