package algorithm.example.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StringManipulation_SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        /** Method A **/
        int[] alphabets = new int[26];
        int length = s.length();
        for (int i=0; i<length; i++){
            alphabets[s.charAt(i) -'a']++;
        }
        int countForAlphabet = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<alphabets.length; i++){
            if (alphabets[i] == 0)
                continue;
            countForAlphabet++;
            min = Math.min(min, alphabets[i]);
            max = Math.max(max, alphabets[i]);
        }
        int countForMax = 0, countForMin = 0;
        for (int i=0; i<alphabets.length; i++){
            if (alphabets[i] == max)
                countForMax++;
            if (alphabets[i] == min)
                countForMin++;
        }
        if (min - max == 0
        || (countForMax == countForAlphabet -1 && min == 1)
        || (countForMin == countForAlphabet -1 && max - min == 1)
        ){
            return "YES";
        }
        return "NO";

        /** Method B **/
        // //- Count
        // //- Maximum
        // HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        // int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // for (int i=0;i<s.length();i++){
        //     if (map.containsKey(s.charAt(i)))
        //         map.put(s.charAt(i), map.get(s.charAt(i))+1);
        //     else
        //         map.put(s.charAt(i),1);
        //     max = Math.max( max, map.get(s.charAt(i)) );
        // }

        // //- Minimum
        // int countForMax = 0, countForMin = 0;
        // for (Map.Entry m : map.entrySet())
        //     min = Math.min(min, (int) m.getValue());

        // //- Count max and min
        // for (Map.Entry m : map.entrySet()){
        //     int val = (int) m.getValue();
        //     if (val == max)
        //         countForMax++;
        //     else if (val == min)
        //         countForMin++;
        // }

        // //- Result
        // if (max - min == 0
        // || (countForMax == map.size() -1 && min == 1)
        // || (countForMin == map.size() -1 && max - min == 1)){
        //     return "YES";
        // }
        // return "NO";
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
