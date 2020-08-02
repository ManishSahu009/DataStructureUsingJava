package org.ms.ds.tree;


/*
		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \
		       /     \
		      7       8
		            /   \
		           /     \
		          9      10

 */

import java.util.Stack;

public class PrintAllPathRootToLeaf {

    public static void printAllPathRootToLeaf(Node<Integer> root , Stack<Node> stack){
       if(root == null)
           return;

       stack.push(root);

       if(root.left==null && root.right==null){
           stack.forEach(e -> System.out.print("->"+e.data));
           System.out.println();
       }

       printAllPathRootToLeaf(root.left,stack);
       printAllPathRootToLeaf(root.right,stack);
       stack.pop();

    }

    public static void printAllPathRootToLeaf(Node<Integer> root){
        Stack<Node> stack=new Stack<>();
        printAllPathRootToLeaf(root,stack);
    }


    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        printAllPathRootToLeaf(root);
    }

}
