package org.ms.ds.tree;


/* Construct below tree
	          1
	        /   \
	       /     \
	      2       3
	     / \     / \
	    4   5   6   7   */
public class ConvertBinaryTreeToMirror {


    public static void convertToMirror(Node<Integer> root) {
       if(root ==null){
           return;
       }
       convertToMirror(root.left);
       convertToMirror(root.right);
       swap(root);
    }

    private static void swap(Node<Integer> root){
        Node<Integer> temp=null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    public static void main(String[] args)
    {

        BinarySearchTree binarySearchTree=new BinarySearchTree();

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        binarySearchTree.inorderTraversalRecusion(root);
        convertToMirror(root);
        System.out.println();
        binarySearchTree.inorderTraversalRecusion(root);
    }


}
