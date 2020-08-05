package org.ms.ds.tree;

	    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     /
		    4   5   6
	    */

import java.util.Map;

public class CheckHeightBalancedTree {

    private static int checkIfBalanced(Node<Integer> root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int lh=checkIfBalanced(root.left);
        int rh=checkIfBalanced(root.right);
         if(Math.abs(lh-rh) > 1){
             return -1;
         }
         return Math.max(lh , rh) +1;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        if(checkIfBalanced(root) != -1){
            System.out.println("Yes");
        }else{
            System.out.println("Max height" + checkIfBalanced(root));
        }
    }

}
