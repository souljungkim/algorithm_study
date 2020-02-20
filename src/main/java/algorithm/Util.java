package algorithm;

public class Util {



    static void exchangeInt(int[] array, int indexA, int indexB){
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

}
