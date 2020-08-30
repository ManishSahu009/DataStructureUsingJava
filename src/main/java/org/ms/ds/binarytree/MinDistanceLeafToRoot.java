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

public class MinDistanceLeafToRoot {

    private static int getMinDistanceLeafToRoot(TreeNode<Integer> root) {

        if(root == null)
            return 0;

        if(root.left==null && root.right==null){
            return 0;
        }
        return 1 + Math.min(getMinDistanceLeafToRoot(root.left),getMinDistanceLeafToRoot(root.right));

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
        System.out.println(getMinDistanceLeafToRoot(root));
    }


}
