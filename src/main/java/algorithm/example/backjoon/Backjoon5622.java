package algorithm.example.backjoon;

import java.util.*;


public class Backjoon5622 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        DialManager dm = new DialManager(input);
        System.out.println(dm.estimateSecond());
    }

}





class DialManager {

    DialManager(String dialCodes){
        this.size = dialCodes.length();
        this.dials = new Dial[this.size];
        for (int i=0; i<this.size; i++){
            this.add(dialCodes.charAt(i));
        }
        init();
    }

    private int size = -1;
    private int index = -1;
    private Dial[] dials;
    private HashMap<Character, Integer> map = new HashMap<>();

    class Dial {
        Dial(char dialCode){
            this.dialCode = dialCode;
        }
        private char dialCode;
        public char getDialCode(){
            return this.dialCode;
        }
    }


    private void init(){
        //Alphabet to Number
        map.put('A', 2); map.put('B', 2); map.put('C', 2);
        map.put('D', 3); map.put('E', 3); map.put('F', 3);
        map.put('G', 4); map.put('H', 4); map.put('I', 4);
        map.put('J', 5); map.put('K', 5); map.put('L', 5);
        map.put('M', 6); map.put('N', 6); map.put('O', 6);
        map.put('P', 7); map.put('Q', 7); map.put('R', 7); map.put('S', 7);
        map.put('T', 8); map.put('U', 8); map.put('V', 8);
        map.put('W', 9); map.put('X', 9); map.put('Y', 9); map.put('Z', 9);
    }

    public void add(char dialCode){
        this.dials[++this.index] = new Dial(dialCode);
    }

    public int getNumberByAlphabet(char alphabet){
        return map.get(alphabet);
    }

    public int getTimeByNumber(int number){
        if (number == 0)
            number = 10;
        return number +1;
    }

    public int getTimeByAlphabet(char alphabet){
        int number = getNumberByAlphabet(alphabet);
        return getTimeByNumber(number);
    }

    public int estimateSecond(){
        int second = 0;
        for (int i=0; i<this.index +1; i++){
            second += getTimeByAlphabet(this.dials[i].getDialCode());
        }
        return second;
    }
}





