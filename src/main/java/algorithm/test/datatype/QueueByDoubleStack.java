package algorithm.test.datatype;

public class QueueByDoubleStack<T> {

    public static void main (String[] args){
        QueueByDoubleStack<Integer> q = new QueueByDoubleStack<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }


    Stack<T> stackNewest, stackOldest;

    QueueByDoubleStack(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T data){
        stackNewest.push(data);
    }

    private void shiftStacks(){
        if (stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }

    public T peek(){
        shiftStacks();
        return stackOldest.peek();
    }


}
