package org.ms.ds.binarytree;

	    /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     /
		    4   5   6
	    */

public class CheckHeightBalancedTree {

    private static int checkIfBalanced(TreeNode<Integer> root) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        if(checkIfBalanced(root) != -1){
            System.out.println("Yes");
        }else{
            System.out.println("Max height" + checkIfBalanced(root));
        }
    }

}
