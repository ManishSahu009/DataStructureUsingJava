package org.ms.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

public class PrintLevelOrderInReverse {

    /*public static void printLevel(Node<Integer> root,int level){
        if (root == null) {
            return ;
        }
        if (level == 1)
        {
            System.out.print(root.data + " ");
            return;
        }
        printLevel(root.left, level - 1);
        printLevel(root.right, level - 1);
    }

    public static void reverseLevelOrderTraversalRecursion(Node root)
    {
        for (int i=HeightOfABinaryTree.getHeigthRecursive(root); i>=0;i-- ) {
            printLevel(root,i+1);
        }
    }*/

    public static void reverseLevelOrderTraversalIterative(Node<Integer> root){
        Queue<Node> queue=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            Node<Integer> temp=queue.poll();
            if(temp !=null){
                stack.push(temp.data);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right !=null){
                    queue.offer(temp.right);
                }

            }else{
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }



    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        reverseLevelOrderTraversalIterative(root);
        System.out.println();
        //reverseLevelOrderTraversalRecursion(root);

    }
}
