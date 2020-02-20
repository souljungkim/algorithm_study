package algorithm.test.string;

public class AlgorithmPermutation {

    public static void main(String[] args){
        permutation("abc");
    }

    public static void permutation(String string){
        permutation(string, "");
    }

    public static void permutation(String string, String prefix){
        if (string.length() == 0){
            System.out.println(prefix);
        }else{
            for (int i=0; i<string.length(); i++){
                String rem = string.substring(0, i) + string.substring(i +1);
//                System.out.println("  ==>"+ rem);
                permutation(rem, prefix + string.charAt(i));
            }
        }
    }


}
