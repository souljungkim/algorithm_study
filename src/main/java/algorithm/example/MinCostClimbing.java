package algorithm.example;

public class MinCostClimbing {

    public static void main (String[] args){
        int[] array = {5,1,2,5,0,10,30,15,10,2};
//        int[] array = {1, 30, 80, 50, 2, 50, 90};
        int result = getRowCost(array);
        int result2 = getRowCost2(array, -1, 0);
        System.out.println(result +" / "+ result2);
    }

    public static int getRowCost(int[] array){
        int costA = 0, costB = 0, current;
        for (int i=array.length -1; i>-1; i--){
            current = array[i] + Math.min(costA, costB);
            costB = costA;
            costA = current;
        }
        return Math.min(costA, costB);
    }

    public static int getRowCost2(int[] array, int i, int sum){
        if (i < array.length){
            sum += (i > -1) ? array[i] : 0;
            int caseA = getRowCost2(array, i+1, sum);
            int caseB = getRowCost2(array, i+2, sum);
            return Math.min(caseA, caseB);
        }
        return sum;
    }

}
