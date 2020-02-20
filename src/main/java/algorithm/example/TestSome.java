package algorithm.example;

import java.util.Scanner;

public class TestSome {

    public static void main (String[] args) {
        Scanner sc;
        int[] arr = {1, 1, 1, 1, 1};
        int cnt = 0;
        try{
            sc = new Scanner(System.in);
            System.out.println("==>");
            int delIdx = sc.nextInt();
            for(int i=delIdx; i<cnt-1; i++) {
                arr[i] = arr[i + 1];
            }
            cnt = cnt - 1;
            sc.close();
            for (int i=0;i<arr.length;i++){
                System.out.println (i +":  "+arr[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
}
