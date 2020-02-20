package algorithm.test.sort;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {3,9,4,7,5,0,1,6,8,5,6};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] array) {
        selectionSort(array, 0);
    }

    private static void selectionSort(int[] array, int startIndex) {
        if (startIndex < array.length -1){
            int minIndex = startIndex;
            int minValue = array[minIndex];
            for (int i=startIndex +1; i<array.length; i++){
                if (array[i] < minValue) {
                    minIndex = i;
                    minValue = array[minIndex];
                }
            }
            exchange(array, startIndex, minIndex);
            selectionSort(array, startIndex +1);
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
