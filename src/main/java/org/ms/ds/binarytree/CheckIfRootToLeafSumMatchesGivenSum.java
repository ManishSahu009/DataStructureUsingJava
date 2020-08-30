package org.ms.ds.binarytree;

    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     /
		    4   5   6
	    */

public class CheckIfRootToLeafSumMatchesGivenSum {

    private static boolean checkIfSumMatches(TreeNode<Integer> root, int sum) {
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
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        System.out.println("SUm matches : " + checkIfSumMatches(root,sum));
    }


}
