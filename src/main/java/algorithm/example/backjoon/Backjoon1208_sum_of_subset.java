package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * https://a1010100z.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1208-%EB%B6%80%EB%B6%84%EC%A7%91%ED%95%A9%EC%9D%98-%ED%95%A9-2-java%EC%9E%AC%EA%B7%80%ED%98%B8%EC%B6%9C?category=796136
 */
public class Backjoon1208_sum_of_subset {
    static void makePre(int[] arr, int idx, int e, int sum, ArrayList<Integer> array) {
        if (idx >= e){ //끝까지 다 돌았다면
            array.add(sum);//추가
            return;
        }
        makePre(arr, idx + 1, e, sum, array);
        //현재 인덱스를 포함할 때
        makePre(arr, idx + 1, e, sum + arr[idx], array);
        //현재 인덱스를 포함하지 않을 때
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        stringTokenizer = new StringTokenizer(br.readLine());
        int k = 0;
        while (stringTokenizer.hasMoreTokens()) arr[k++] = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> first_arr = new ArrayList<>();
        ArrayList<Integer> second_arr = new ArrayList<>();

        makePre(arr, 0, N / 2, 0, first_arr);
        makePre(arr, N / 2, arr.length, 0, second_arr);
        Collections.sort(first_arr);
        Collections.sort(second_arr);

        int left = 0;
        int right = second_arr.size() - 1;
        long ans = 0;
        while (left < first_arr.size() && right >= 0){
            long ls = first_arr.get(left);
            long rs = second_arr.get(right);
            if (ls + rs == S){
                //S와 일치하면, 각 분할 집합에서 해당 합을 지니는 원소의 개수를 셈
                long lc = 0;
                while (left < first_arr.size() && first_arr.get(left) == ls){
                    lc++;
                    left++;
                }
                long rc = 0;
                while (right >= 0 && second_arr.get(right) == rs){
                    rc++;
                    right--;
                }
                ans += lc * rc;
            }
            if (ls + rs > S)
                right--;
            if (ls + rs < S)
                left++;
        }
        if (S == 0)
            ans -= 1;
        System.out.println(ans);
    }

}
