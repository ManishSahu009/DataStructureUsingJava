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

public class CheckIfTwoNodesAreSiblings {


    private static boolean isSiblings(TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b) {
        if(root ==null){
            return false;
        }
        if((root.left == a && root.right ==b) || root.left == b && root.right ==a){
            return true;
        }
        return isSiblings(root.left,a,b) || isSiblings(root.right,a,b);
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);


        if(isSiblings(root, root.right.left,root.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }


}
