package algorithm.example.backjoon;


import java.util.*;

public class Backjoon1316 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = Integer.parseInt(in.nextLine());
        String[] words = new String[input];

        WordManager wordManager;
        int countForGroupWord = 0;
        for (int i=0; i<input; i++){
            wordManager = new WordManager(in.nextLine());
            if (wordManager.checkGroupWord())
                countForGroupWord++;
        }

        System.out.println(countForGroupWord);
    }


}


class WordManager {

    WordManager(String word){
        this.word = word;
        this.length = word.length();
    }
    private String word;
    private int length;
    private int codeLowerA = (int)'a';

    public boolean checkGroupWord(){
        char[] charArray = word.toCharArray();
        int[] checkerArray = new int[26];
        char prevChar = '0', curChar;
        int indexToCheck;
        for (int i=0; i<length; i++){
            curChar = charArray[i];
            if (prevChar == curChar)
                continue;
            indexToCheck = ((int)curChar) -codeLowerA;
            if (checkerArray[indexToCheck] > 0)
                return false;
            checkerArray[indexToCheck]++;
            prevChar = curChar;
        }
        return true;
    }

}
