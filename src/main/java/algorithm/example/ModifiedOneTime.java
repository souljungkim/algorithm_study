package algorithm.example;

public class ModifiedOneTime {

    public static void main(String[] args){
        System.out.println( modifiedOneTime("pal", "pale") );
        System.out.println( modifiedOneTime("pale", "pal") );
        System.out.println( modifiedOneTime("pale", "bale") );
        System.out.println( modifiedOneTime("p2ale", "pale") );

        System.out.println( modifiedOneTime("pal", "pales") );
        System.out.println( modifiedOneTime("pale", "pel") );
        System.out.println( modifiedOneTime("pale", "bake") );
        System.out.println( modifiedOneTime("pale", "pas") );

    }

    public static boolean modifiedOneTime(String s1, String s2){
        String ls;
        String ss;
        if (s1.length() < s2.length()){
            ss = s1;
            ls = s2;
        }else{
            ss = s2;
            ls = s1;
        }
        if (ls.length() - ss.length() > 1)
            return false;
        boolean flag = false;
        for (int i=0, j=0; i<ss.length(); i++, j++){
            if (ss.charAt(i) != ls.charAt(j)){
                if (flag){
                    return false;
                }
                flag = true;
                if (ss.length() != ls.length()){
                    if (i==ss.length()-1)
                        return false;
                    j++;
                }
            }
        }
        return true;
    }


}
