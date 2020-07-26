package org.ms.ds.tree;


import java.util.ArrayDeque;
import java.util.Deque;

public class IdenticalTreesWithIterative {

    static boolean  isIdentical(Node tree1,Node tree2){
        if(tree1 == null && tree2==null){
            return true;
        }
        if((tree1 == null && tree2 !=null) || (tree2 == null && tree1 !=null)){
            return false;
        }
        Deque<Pair<Node,Node>> stack= new ArrayDeque<>();
        stack.add(Pair.of(tree1,tree2));
        while(!stack.isEmpty()){
           tree1=stack.peekLast().first;
           tree2=stack.peekLast().second;
           stack.pollLast();

           if(tree1.data!=tree2.data){
               return false;
           }
           if(tree1.left !=null && tree2.left!=null){
               stack.add(Pair.of(tree1.left,tree2.left));
           }else if(tree1.left !=null || tree2.left!=null){
               return false;
           }
            if(tree1.right !=null && tree2.right!=null){
                stack.add(Pair.of(tree1.right,tree2.right));
            }else if(tree1.right !=null || tree2.right!=null){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Node<Integer> x = new Node<>(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);


        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        System.out.println("===> "+ isIdentical(x,y));
    }
}

class Pair<U,V>{
    public final U first;
    public final V second;

    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        return new Pair<>(a, b);
    }
}
