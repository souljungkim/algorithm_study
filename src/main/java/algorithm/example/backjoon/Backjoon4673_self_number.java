package algorithm.example.backjoon;

public class Backjoon4673_self_number {

    public static void main(String[] args){
        boolean[] nonSelfNumberArray = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i=1; i<=10000; i++){
            result = cal(i);
            if (result <= 10000)
                nonSelfNumberArray[result] = true;
        }

        String enter = System.lineSeparator();
        for (int i=1; i<nonSelfNumberArray.length; i++){
            if (!nonSelfNumberArray[i])
                sb.append(i).append(enter);
        }
        System.out.print(sb);
    }

    private static int cal(int num){
        int result = num;
        while (num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }

}
