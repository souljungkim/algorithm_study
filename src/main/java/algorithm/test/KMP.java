package algorithm.test;

import java.util.ArrayList;
import java.util.List;


/**
 * REF: https://hskimsky.tistory.com/122
 */
public class KMP {

    public static void main(String[] args){
        KMP kmp = new KMP();
        List<Integer> foundIndexList = kmp.setString("ADFdBDC1DFDw13DfdeeDf3fDfeDfddddD").setPattern("Dfd").search();
        printAll(foundIndexList);
    }

    private static void printAll(List<Integer> list){
        for (int i=0; i<list.size(); i++){
            System.out.println( list.get(i) );
        }
    }





    public KMP(){
        //None
    }

    /**
     * O(N+M)
     */
    public KMP(String string, String pattern) {
        this.string = string;
        this.pattern = pattern;
    }

    private String string;
    private String pattern;



    public KMP setString(String string) {
        this.string = string;
        return this;
    }

    public KMP setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public List<Integer> search() {
        List<Integer> foundIndexList = new ArrayList<>();

        char[] stringArray = string.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int[] pi = getPI();
        int stringLength = string.length();
        int patternLength = pattern.length();
        int j = 0;

        for (int i=0; i<stringLength; i++){
            while (j > 0 && stringArray[i] != patternArray[j]){
                j = pi[j -1];
            }
            if (stringArray[i] == patternArray[j]){
                if (j == patternLength - 1){
                    foundIndexList.add(i - patternLength + 1);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }
        return foundIndexList;
    }

    /**
     * O(M)
     */
    public int[] getPI(){
        int patternLength = pattern.length();
        char[] patternArray = pattern.toCharArray();
        int[] pi = new int[patternLength];

        int j = 0;
        for (int i=1; i<patternLength; i++){
            while (j > 0 && patternArray[i] != patternArray[j])
                j = pi[j -1];
            if (patternArray[i] == patternArray[j])
                pi[i] = ++j;
        }
        return pi;
    }

}
