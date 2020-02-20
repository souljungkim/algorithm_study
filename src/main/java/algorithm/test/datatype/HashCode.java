package algorithm.test.datatype;

import java.util.LinkedList;

public class HashCode {

    public static void main(String[] args){
        HashTable hashTable = new HashTable(3);
        hashTable.put("sung", "She is pretty");
        hashTable.put("jin", "She is model");
        hashTable.put("hee", "She is an angel");
        hashTable.put("min", "She is cute");
        hashTable.put("sung", "She is beutiful");
        System.out.println(hashTable.get("sung"));
        System.out.println(hashTable.get("jin"));
        System.out.println(hashTable.get("hee"));
        System.out.println(hashTable.get("min"));
        System.out.println(hashTable.get("jae"));
    }


    static class HashTable {
        class Node{
            String key;
            String value;
            public Node(String key, String value){
                this.key = key;
                this.value = value;
            }
            String value(){
                return value;
            }
            void value(String value){
                this.value = value;
            }
        }

        LinkedList<Node>[] data;

        public HashTable(int size){
            this.data = new LinkedList[size];
        }

        int getHashCode(String key){
            int hashCode = 0;
            for (char c : key.toCharArray()){
                hashCode += c;
            }
            return hashCode;
        }

        int convertToIndex(int hashCode){
            return hashCode % data.length;
        }

        Node searchKey(LinkedList<Node> list, String key){
            if (list == null)
                return null;
            for (Node node : list){
                if (node.key.equals(key)){
                    return node;
                }
            }
            return null;
        }

        void put(String key, String value){
            int hashCode = getHashCode(key);
            int index = convertToIndex(hashCode);
            LinkedList<Node> list = data[index];
            if (list == null){
                list = new LinkedList<Node>();
                data[index] = list;
            }
            Node node = searchKey(list, key);
            if (node == null) {
                list.addLast(new Node(key, value));
            }else{
                node.value(value);
            }
        }

        String get(String key){
            int hashCode = getHashCode(key);
            int index = convertToIndex(hashCode);
            LinkedList<Node> list = data[index];
            Node node = searchKey(list, key);
            return node == null ? "Not Found" : node.value();
        }
    }

}

