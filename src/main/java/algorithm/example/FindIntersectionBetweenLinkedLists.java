package algorithm.example;

public class FindIntersectionBetweenLinkedLists {

    public static void main(String[] args){
        Node n1 = new Node(5);
        Node n2 = n1.addNext(7);
        Node n3 = n2.addNext(9);
        Node n4 = n3.addNext(10);
        Node n5 = n4.addNext(7);
        Node n6 = n5.addNext(6);

        Node m1 = new Node(1);
        Node m2 = m1.addNext(2);
        Node m3 = m2.addNext(n4);
//        Node m3 = m2.addNext(3);
//        Node m4 = m3.addNext(4);
//        Node m5 = m4.addNext(5);
//        Node m6 = m5.addNext(6);

        n1.print();
        m1.print();

        Node resultNode = getIntersection(n1, m1);
        if (resultNode != null){
            System.out.println("Intersection Data: " + resultNode.data);
        }else{
            System.out.println("Not Found");
        }
    }

    FindIntersectionBetweenLinkedLists(){

    }


    private static Node getIntersection(Node nodeA, Node nodeB){
        int len1 = getListLength(nodeA);
        int len2 = getListLength(nodeB);
        if (len1 > len2){
            nodeA = nodeA.get(len1 -len2);
        }else{
            nodeB = nodeB.get(len2 - len1);
        }

        while (nodeA != null && nodeB != null){
            if (nodeA == nodeB)
                return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    private static int getListLength(Node node){
        int length = 1;
        Node finder = node;
        while ((finder = finder.next) != null){
            length++;
        }
        return length;
    }


    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }

        Node addNext(int data){
            return addNext(new Node(data));
        }
        Node addNext(Node node){
            this.next = node;
            return node;
        }
        Node get(int count){
            Node finder = this;
            for (int i=0; i<count; i++){
                finder = finder.next;
            }
            return finder;
        }
        void print(){
            Node finder = this;
            System.out.print(this.data);
            while ((finder = finder.next) != null){
                System.out.print(" => " + finder.data);
            }
            System.out.println();
        }

    }

}
