package algorithm.example.hackerrank;
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        /** Method A **/
        // if (b.score == a.score)
        //     return compareAlphabet(a.name, b.name);
        // return b.score - a.score;

        /** Method B **/
        return (b.score != a.score) ? b.score - a.score : a.name.compareTo(b.name);
    }

    private int compareAlphabet(String a, String b){
        int lenA = a.length();
        int lenB = b.length();
        int len  = (lenA < lenB) ? lenA : lenB;
        int chk = 0;
        for (int i=0; i<len; i++){
            chk = ((a.charAt(i) -'a') - (b.charAt(i) -'a'));
            if (chk != 0)
                return chk;
        }
        return (lenA == lenB) ? chk : (lenA < lenB) ? -1 : 1;
    }
}


public class Sorting_Comparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}