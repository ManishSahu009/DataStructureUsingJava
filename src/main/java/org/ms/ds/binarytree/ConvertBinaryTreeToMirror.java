package org.ms.ds.binarytree;


import org.ms.ds.binarysearchtree.BinarySearchTree;

/* Construct below tree
	          1
	        /   \
	       /     \
	      2       3
	     / \     / \
	    4   5   6   7   */
public class ConvertBinaryTreeToMirror {


    public static void convertToMirror(TreeNode<Integer> root) {
       if(root ==null){
           return;
       }
       convertToMirror(root.left);
       convertToMirror(root.right);
       swap(root);
    }

    private static void swap(TreeNode<Integer> root){
        TreeNode<Integer> temp=null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    public static void main(String[] args)
    {

        BinarySearchTree binarySearchTree=new BinarySearchTree();

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        binarySearchTree.inorderTraversalRecursion(root);
        convertToMirror(root);
        System.out.println();
        binarySearchTree.inorderTraversalRecursion(root);
    }


}
