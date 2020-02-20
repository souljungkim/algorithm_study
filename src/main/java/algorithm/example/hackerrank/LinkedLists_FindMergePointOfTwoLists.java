package algorithm.example.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class LinkedLists_FindMergePointOfTwoLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        /** Method A **/
        int n1Len = getLength(head1);
        int n2Len = getLength(head2);
        int gapLen = n1Len - n2Len;
        if (n1Len < n2Len){
            head2 = getNodeFromHead(head2, n2Len -n1Len);
        }else{
            head1 = getNodeFromHead(head1, n1Len -n2Len);
        }
        while (head1 != null && head2 != null){
            if (head1 == head2)
                return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;

        /** Method B **/
        // HashSet<SinglyLinkedListNode> set = new HashSet<>();
        // while (head1 != null){
        //     set.add(head1);
        //     head1 = head1.next;
        // }
        // while (head2 != null){
        //     if (set.contains(head2))
        //         return head2.data;
        //     head2 = head2.next;
        // }
        // return -1;

        /** Method C **/
        // SinglyLinkedListNode current1 = head1;
        // SinglyLinkedListNode current2 = head2;
        // while (current1 != current2) {
        //     current1 = current1.next != null ? current1.next : head2;
        //     current2 = current2.next != null ? current2.next : head1;
        // }
        // return current1.data;
    }

    static int getLength(SinglyLinkedListNode head){
        if (head == null)
            return 0;
        int length = 1;
        SinglyLinkedListNode node = head;
        while ((node = node.next) != null){
            length++;
        }
        return length;
    }

    static SinglyLinkedListNode getNodeFromHead(SinglyLinkedListNode head, int targetIndex){
        if (targetIndex == 0)
            return head;
        SinglyLinkedListNode node = head;
        int currentIndex = 0;
        while ((node = node.next) != null && ++currentIndex != targetIndex){}
        return node;
    }

    private static final Scanner scanner = new Scanner(System.in);

    //...

}
