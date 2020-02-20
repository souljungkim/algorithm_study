package algorithm.test.string;

public class RotateString {

    public static void main(String[] args){
        System.out.println(isRotated("String","tringS"));
        System.out.println(isRotated("String","ringSt"));
        System.out.println(isRotated("String","ingStr"));
        System.out.println(isRotated("String","ngStri"));
        System.out.println(isRotated("String","ngStrdi"));
        System.out.println(isRotated("String","ng3Strdi"));
        System.out.println(isRotated("String","ngS3tri"));
    }

    public static boolean isRotated(String a, String b){
        if (a.length() != b.length())
            return false;
        return (isSubstring((a + a), b));
    }

    public static boolean isSubstring(String a, String b){
        return a.contains(b);
    }




}
