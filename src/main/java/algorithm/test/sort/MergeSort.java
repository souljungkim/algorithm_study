package algorithm.test.sort;

public class MergeSort {

    public static void main(String[] args){
        int[] array = {3,9,4,7,5,0,1,6,8,5,6};
        mergeSort(array);
    }

    private static void mergeSort(int[] array) {
        int[] tempArray = new int[array.length];
        printArray(array);
        mergeSort(array, tempArray, 0, array.length -1);
        printArray(array);
    }

    private static void mergeSort(int[] array, int[] tempArray, int start, int end) {
        if (start < end){
            int mid = (start + end) /2;
            mergeSort(array, tempArray, start, mid);
            mergeSort(array, tempArray, mid +1, end);
            merge(array, tempArray, start, mid, end);
        }
    }

    private static void merge (int[] array, int[] tempArray, int start, int mid, int end){
        //Copy array to tempArray
        for (int i=start; i<end +1; i++)
            tempArray[i] = array[i];
        //Merge
        int part1 = start;
        int part2 = mid +1;
        int index = start;
        while (part1 < mid +1 && part2 < end +1){
            if (tempArray[part1] <= tempArray[part2]){
                array[index] = tempArray[part1];
                part1++;
            }else{
                array[index] = tempArray[part2];
                part2++;
            }
            index++;
        }
        for (int i=0; i<mid - part1 +1; i++)
            array[index + i] = tempArray[part1 + i];
    }

    private static void printArray(int[] arr) {
        for (int data : arr){
            System.out.print(data  + ", ");
        }
        System.out.println();
    }

}
