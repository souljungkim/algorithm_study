package algorithm.example.backjoon;

import java.util.*;

public class Backjoon1157 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String inputForWord = in.nextLine();

        int codeLowerA = (int) 'a';
        int codeLowerZ = (int) 'z';
        int codeUpperA = (int) 'A';
        int codeUpperZ = (int) 'Z';

        int[] alphabetCountArray = new int[codeLowerZ - codeLowerA +1];

        int length = inputForWord.length();
        int index;
        for (int i=0; i<length; i++){
            index = (int) inputForWord.charAt(i);
            if (index < codeLowerA)
                index -= (codeUpperA);
            else if (codeLowerA <= index)
                index -= (codeLowerA);
            alphabetCountArray[index]++;
        }

        int maxCount = 0, codeForMaxCount = 0;
        boolean hasSameMaxCount = false;
        for (int i=0; i<alphabetCountArray.length; i++){
            if (alphabetCountArray[i] > maxCount){
                maxCount = alphabetCountArray[i];
                codeForMaxCount = i;
                hasSameMaxCount = false;
            }else if (alphabetCountArray[i] == maxCount){
                hasSameMaxCount = true;
            }
        }

        if (hasSameMaxCount){
            System.out.println("?");
        }else{
            System.out.println((char)(codeForMaxCount + codeUpperA));
        }
    }

}
