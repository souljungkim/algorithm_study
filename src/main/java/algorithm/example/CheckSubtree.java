package algorithm.example;

public class CheckSubtree {

    public static void main (String[] args){
        Tree t1 = new Tree();
        Tree t2 = new Tree();

        t1.root = t1.makeBST(0,9);
        t2.root = t2.makeBST(5,9);
        System.out.println( t1.containsTree(t1.root, t2.root) );

        t2.root = t2.makeBST(7, 9);
        System.out.println( t1.containsTree(t1.root, t2.root) );
    }

}


class Tree {

    Node root;
    Node makeBST(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) /2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid -1);
        node.right = makeBST(mid +1, end);
        return node;
    }

    boolean containsTree(Node t1, Node t2){
        if (t2 == null)
            return true;
        return subTree(t1, t2);
    }

    boolean subTree(Node t1, Node t2){
        if (t1 == null){
            return false;
        }else if (t1.data == t2.data && matchTree(t1, t2)){
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    boolean matchTree(Node t1, Node t2){
        if (t1 == null && t2 == null) {
            return true;
        }else if (t1 == null || t2 == null) {
            return false;
        }else if (t1.data != t2.data) {
            return false;
        }else{
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }

}

