package algorithm.test.string;

public class Compression {

    public static void main (String[] args){
        System.out.println(compressString("aabbbbbccccdd"));
        System.out.println(compressString("abcd"));
    }

    public static String compressString(String originalString){
        String newString = compress(originalString);
        return (originalString.length() > newString.length()) ? newString : originalString;
    }

    public static String compress(String originalString){
        int count = 0;
        StringBuilder newString = new StringBuilder(getTotal(originalString));
        for (int i=0; i<originalString.length(); i++){
            count++;
            if (i +1 >= originalString.length() || originalString.charAt(i) != originalString.charAt(i +1)){
                newString.append(originalString.charAt(i));
                newString.append(count);
                count = 0;
            }
        }
        return newString.toString();
    }

    private static int getTotal(String originalString){
        int total = 0;
        int count = 0;
        for (int i=0; i<originalString.length(); i++){
            count++;
            if (i +1 >= originalString.length() || originalString.charAt(i) != originalString.charAt(i +1)){
                total += 1 +String.valueOf(count).length();
                count = 0;
            }
        }
        return total;
    }
}
