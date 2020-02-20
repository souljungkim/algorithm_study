package algorithm.example.backjoon;

import java.util.*;
import java.io.*;

public class Backjoon1181 {

    public static void main (String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        HashSet set = new HashSet();
        int input = Integer.parseInt(br.readLine());
        for (int i=0; i<input; i++)
            set.add( br.readLine() );
        br.close();

        String[] strings = (String[]) set.toArray(new String[set.size()]);
        TextNodeList textNodeList = new TextNodeList(strings);
        textNodeList.sort();

        System.out.println(textNodeList);
    }





    static public class TextNodeList {

        TextNodeList(String[] textArray){
            this(textArray.length);
            for (int i=0; i<textArray.length; i++){
                add(textArray[i]);
            }
        }

        TextNodeList(int size){
            this.size = size;
            this.nodes = new Node[size];
        }



        private int size = 0;
        private Node[] nodes;
        private HashMap<String, Boolean> map = new HashMap<>();
        private int index = -1;

        public class Node {
            Node(String text){
                this.text = text;
                this.length = text.length();
            }
            private String text;
            private int length;
            public String getText(){
                return this.text;
            }
            public int getLength(){
                return this.length;
            }
        }


        public void add(String text){
            this.add(new Node(text));
        }

        public void add(Node node){
            nodes[++this.index] = node;
        }

        public void put(String text){
            this.put(new Node(text));
        }

        public void put(Node node){
            if (map.containsKey(node.text))
                return;
            map.put(node.text, true);
        }

        public void sort(){
            Arrays.sort(this.nodes, new Comparator<Node>(){
                public int compare(Node a, Node b){
                    int lengthA = a.getLength(), lengthB = b.getLength();
                    if (lengthA == lengthB){
                        return compareAlphabet(a, b);
                    }else{
                        return lengthA - lengthB;
                    }
                }
            });
        }

        public int compareAlphabet(Node a, Node b){
            return compareAlphabet(a.getText(), b.getText());
        }

        public int compareAlphabet(String a, String b){
            char[] dataA = a.toCharArray();
            char[] dataB = b.toCharArray();
            int numCodeA, numCodeB;
            for (int i=0; i<dataA.length && i<dataB.length; i++){
                numCodeA = (int) dataA[i];
                numCodeB = (int) dataB[i];
                int res = numCodeA - numCodeB;
                if (res > 0){
                    return 1;
                }else if (res < 0){
                    return -1;
                }
            }
            return 0;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            String enter = System.lineSeparator();
            for (int i=0; i<this.size; i++)
                sb.append(this.nodes[i].getText()).append(enter);
            return sb.toString();
        }


    }

}



