package algorithm.example.backjoon;



import java.util.Scanner;


/**
 * https://a1010100z.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1182-%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9%EC%9D%98-%ED%95%A9-java%EC%9E%AC%EA%B7%80%ED%98%B8%EC%B6%9C%EB%B6%80%EC%A0%9C%EC%98%A4%EB%9E%9C%EB%A7%8C%EC%97%90-%EC%82%BD%EC%A7%88%EC%9D%BC%EA%B8%B0
 */
class Backjoon1182_subset{

    static int max=0;

    static public void set(int[] arr, int S,int cur, int idx, int count) {
        if (idx >= arr.length){
            if (cur == S && count > 0)
                max++;
            return;
        }
        //현재 인덱스를 포함한다
        set(arr, S, cur+arr[idx], idx+1, count+1);
        //포함하지 않는다
        set(arr, S, cur , idx+1, count);
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int S=scan.nextInt();

        int[] arr=new int[N];
        for(int i=0; i<N; i++) {
            arr[i]=scan.nextInt();
        }

        set(arr, S, 0, 0,0 );
        System.out.println(max);
    }

}