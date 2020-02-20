package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String text) {
        ArrayList<String> list = new ArrayList<>();
        int len = text.length();
        int counter = 0;
        for (int j=0; j<len; j++){
            for (int sub=1; sub<=len-j; sub++){
                String subPart = text.substring(j, j+sub);
                list.add(subPart);
            }
        }
        for (int j=0; j<list.size(); j++){
            String element = list.get(j);
            for (int k=j+1; k<list.size(); k++){
                if (isAnagram(list.get(k), element))
                    counter++;
            }
        }
        return counter;
    }

    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length())
            return false;
        int[] lettermap = new int[26];
        for (int j=0; j<a.length(); j++){
            char ch = a.charAt(j);
            lettermap[ch - 'a']++;
            ch = b.charAt(j);
            lettermap[ch - 'a']--;
        }

        for (int j=0; j<lettermap.length; j++){
            if(lettermap[j] != 0)
                return false;
        }
        return true;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
