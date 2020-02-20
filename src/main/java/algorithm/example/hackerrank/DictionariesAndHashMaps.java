package algorithm.example.hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class DictionariesAndHashMaps {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        if (checkReplica(magazine, note))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean checkReplica(String[] magazine, String[] note){
        Hashtable<String, Integer> magazineChecker = new Hashtable<>();

        for (String s : magazine){
            if(magazineChecker.containsKey(s)){
                magazineChecker.put(s, magazineChecker.get(s) + 1);
            }else{
                magazineChecker.put(s, 1);
            }
        }

        for (String s : note){
            if(!magazineChecker.containsKey(s))
                return false;

            int counter = magazineChecker.get(s) - 1;

            if(counter == 0){
                magazineChecker.remove(s);
            }else{
                magazineChecker.put(s, counter);
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
