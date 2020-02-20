package algorithm.test.string;

public class AlgorithmSortedString {

    public static void main(String[] args){
        printSortedStrings(2);
    }

    public static final int C = 26;

    public static void printSortedStrings(int length){
        printSortedStrings(length, "");
    }

    public static void printSortedStrings(int length, String prefix){
        if (length == 0){
            if (isInOrder(prefix))
                System.out.println(prefix);
        }else{
            for (int i=0; i<C; i++){
                char c = ithLetter(i);
                printSortedStrings(length -1, prefix +c);
            }
        }
    }

    public static boolean isInOrder(String letter){
        for (int i=1; i<letter.length(); i++){
            int prev = ithLetter(letter.charAt(i -1));
            int curr = ithLetter(letter.charAt(i));
            if (prev > curr)
                return false;
        }
        return true;
    }

    public static char ithLetter(int i){
        return (char) (((int) 'a') +i);
    }

}
