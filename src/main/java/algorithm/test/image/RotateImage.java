package algorithm.test.image;

public class RotateImage {

    public static void main(String[] args){
        int[][] array2D = {
            {1,0,0,0,1},
            {0,1,0,1,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
        printArray2D(array2D);
        rotateArray2D(array2D);
        printArray2D(array2D);
        rotateArray2D(array2D);
        printArray2D(array2D);
        rotateArray2D(array2D);
        printArray2D(array2D);
        rotateArray2D(array2D);
        printArray2D(array2D);
    }


    private static int[][] rotateArray2D(int[][] array2D){
        int tmp;
        for (int s=0, e=array2D.length -1; s<e; s++, e--){
            for (int i=s, j=e; i<e; i++, j--){
                tmp = array2D[s][i];
                array2D[s][i] = array2D[i][e];
                array2D[i][e] = array2D[e][j];
                array2D[e][j] = array2D[j][s];
                array2D[j][s] = tmp;
            }
        }
        return array2D;
    }

    private static void printArray2D(int[][] array2D){
        for (int i=0; i<array2D.length; i++){
            for (int j=0; j<array2D[i].length; j++){
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
