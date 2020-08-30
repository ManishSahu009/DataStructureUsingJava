package org.ms.ds.binarytree;


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

    public static void printAllPathRootToLeaf(TreeNode<Integer> root , Stack<TreeNode<Integer>> stack){
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

    public static void printAllPathRootToLeaf(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack=new Stack<>();
        printAllPathRootToLeaf(root,stack);
    }


    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);
        printAllPathRootToLeaf(root);
    }

}
