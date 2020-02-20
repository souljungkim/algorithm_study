package algorithm.test.datatype;

import java.util.EmptyStackException;

public class Stack<T> {


    public static void main (String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }

    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    private int size = 0;
    private Node<T> last;

    public int size(){
        return size = 0;
    }

    public void push(T item){
        Node<T> temp = new Node<T>(item);
        temp.next = last;
        last = temp;
        ++size;
    }

    public T pop(){
        if (last == null){
            throw new EmptyStackException();
        }
        T item = last.data;
        last = last.next;
        --size;
        return item;
    }

    public T peek(){
        if (last == null){
            throw new EmptyStackException();
        }
        return last.data;
    }

    public boolean isEmpty(){
        return last == null;
    }




}
