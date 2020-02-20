package algorithm.test.sort;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {3,9,4,7,5,0,1,6,8,5,6};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] array) {
        bubbleSort(array, array.length -1);
    }

    private static void bubbleSort(int[] array, int endIndex) {
        if (endIndex > 0){
            for (int i=1; i<endIndex +1; i++){
                if (array[i -1] > array[i]){
                    exchange(array, i -1, i);
                }
            }
            bubbleSort(array, endIndex -1);
        }
    }

    private static void exchange(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr){
            System.out.print(data  + ", ");
        }
        System.out.println();
    }

}
