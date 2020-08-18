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
https://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 */

public class RemoveNodeLessThanKLength {

    static Node<Integer> removeNodeLessThanK(Node<Integer> root, int k, int level){

        if(root == null){
           return null;
        }
        root.left=removeNodeLessThanK(root.left,k,level+1);
        root.right=removeNodeLessThanK(root.right,k,level+1);

        if(root.left == null && root.right == null && level < k){
            return null;
        }
        return root;
    }

    static void  printPreorder(Node<Integer> root){
        if(root ==null){
            return;
        }
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        printPreorder(root);
        System.out.println();
        printPreorder(removeNodeLessThanK(root,4,1));

    }


}
