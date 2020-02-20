package algorithm.example.hackerrank;



import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class StacksAndQueues_BalncedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        /*****
         * Method A //TODO: ... trash..
         *****/
        // int len = s.length();
        // int[] bracketOpenStatus = new int[3]; // 0 {} 1 () 2 []
        // int lastOpenCode = -1;
        // char a;
        // for (int i=0; i<len; i++){
        //     a = s.charAt(i);
        //     switch (a){
        //         case '{': bracketOpenStatus[0]++; lastOpenCode = 0; break;
        //         case '(': bracketOpenStatus[1]++; lastOpenCode = 1; break;
        //         case '[': bracketOpenStatus[2]++; lastOpenCode = 2; break;
        //         case '}': bracketOpenStatus[0]--; break;
        //         case ')': bracketOpenStatus[1]--; break;
        //         case ']': bracketOpenStatus[2]--; break;
        //     }
        //     if (bracketOpenStatus[0] < 0 || bracketOpenStatus[1] < 0 || bracketOpenStatus[2] < 0)
        //         break;
        // }
        // return (bracketOpenStatus[0] == 0 && bracketOpenStatus[1] == 0 && bracketOpenStatus[2] == 0) ? "YES" : "NO";

        /*****
         * Method B
         *****/
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i=0; i<s.length(); i++){
            c = s.charAt(i);
            switch (c){
                case '{': stack.push('}'); break;
                case '(': stack.push(')'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return "NO";
                    break;
            }
        }
        return (stack.isEmpty()) ? "YES" : "NO";

        /*****
         * Method C
         *****/
        // int l = s.length();
        // while (true){
        //     s = s.replaceAll("\\(\\)","").replaceAll("\\{\\}","").replaceAll("\\[]","").trim();
        //     if (s.length() == l || s.length() == 0)
        //         break;
        //     l = s.length();
        // }
        // return (s.length() == 0) ? "YES" : "NO";
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
