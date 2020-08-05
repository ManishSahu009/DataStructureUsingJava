package org.ms.ds.tree;

    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     /
		    4   5   6
	    */

public class CheckIfRootToLeafSumMatchesGivenSum {

    private static boolean checkIfSumMatches(Node<Integer> root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left==null && root.right == null && root.data == sum){
            return true;
        }
        return checkIfSumMatches(root.left ,sum-root.data)
                || checkIfSumMatches(root.right ,sum-root.data);
    }

    public static void main(String[] args) {
        int sum=8;
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        System.out.println("SUm matches : " + checkIfSumMatches(root,sum));
    }


}
