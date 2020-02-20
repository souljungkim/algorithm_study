package algorithm.test.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFS {


    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
//        g.dfs();
//        g.bfs();
//        g.dfsR(0);
//        g.dfs(3);
//        g.bfs(3);
        g.dfsR(3);

        testSearch(g);
    }

    private static void testSearch(Graph g){
        System.out.println("\n=========================");
        System.out.println(g.search(0, 5));
    }




    /** Graph **/
    static class Graph {

        /** Node **/
        class Node{
            int data;
            LinkedList<Node> adjacent;
            boolean marked;
            Node(int data){
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>();
            }
        }

        Node[] nodes;

        Graph(int size){
            nodes = new Node[size];
            for (int i =0; i<size; i++){
                nodes[i] = new Node(i);
            }
        }
        void addEdge(int from, int to){
            Node n1 = nodes[from];
            Node n2 = nodes[to];
            if (!n1.adjacent.contains(n2))
                n1.adjacent.add(n2);
            if (!n2.adjacent.contains(n1))
                n2.adjacent.add(n1);
        }

        void dfs(){
            dfs(0);
        }
        void dfs(int index){
            Node root = nodes[index];
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            root.marked = true;
            while (!stack.isEmpty()){
                Node r = stack.pop();
                for (Node n : r.adjacent){
                    if (n.marked)
                        continue;
                    n.marked = true;
                    stack.push(n);
                }
                visit(r);
            }
        }

        void bfs(){
            bfs(0);
        }
        void bfs(int index){
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.marked = true;
            while (!queue.isEmpty()){
                Node r = queue.poll();
                for (Node n : r.adjacent){
                    if (n.marked)
                        continue;
                    n.marked = true;
                    queue.offer(n);
                }
                visit(r);
            }
        }

        void dfsR(int index){
            Node r = nodes[index];
            dfsR(r);
        }

        void dfsR(Node r){
            if (r == null)
                return;
            r.marked = true;
            visit(r);
            for (Node n : r.adjacent){
                if (n.marked)
                    continue;
                dfsR(n);
            }
        }


        void visit(Node n){
            System.out.print(n.data + " ");
        }

        void initMarks(){
            for (Node n : nodes)
                n.marked = false;
        }


        boolean search(int i1, int i2){
            return search(nodes[i1], nodes[i2]);
        }

        boolean search(Node start, Node end){
            initMarks();
            LinkedList<Node> q = new LinkedList<Node>();
            q.add(start);
            while (!q.isEmpty()){
                Node root = q.removeFirst();
                if (root == end)
                    return true;
                for (Node n : root.adjacent){
                    if (n.marked)
                        continue;
                    n.marked = true;
                    q.add(n);
                }
            }
            return false;
        }


    }


}
