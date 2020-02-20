package algorithm.example.backjoon;
import java.util.Scanner;

class Backjoon1003 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] cnt = new int[41][2];
        cnt[0][0] = 1;
        cnt[1][1] = 1;
        for (int i =2; i<41; i++){
            for (int j=0; j<2; j++){
                cnt[i][j] = cnt[i-1][j] + cnt[i-2][j];
            }
        }
        for (int i=0; i<num; i++){
            int a = sc.nextInt();
            System.out.println(cnt[a][0]+" "+cnt[a][1]);
        }
        sc.close();
    }

}