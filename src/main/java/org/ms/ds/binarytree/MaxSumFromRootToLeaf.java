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

import java.util.concurrent.atomic.AtomicInteger;

public class MaxSumFromRootToLeaf {

    private static void getMaxSumFromRootToLeaf(TreeNode<Integer> root, AtomicInteger maxSum, int tempSum) {

        if(root == null){
            return;
        }
        if(root.left ==null && root.right==null && (tempSum+root.data > maxSum.get())){
           maxSum.set(tempSum+root.data);
           return;
        }
        getMaxSumFromRootToLeaf(root.left,maxSum,tempSum + root.data);
        getMaxSumFromRootToLeaf(root.right,maxSum,tempSum + root.data);
    }


    public static void main(String[] args)
    {
        AtomicInteger maxSum=new AtomicInteger(0);
        int tmpSum=0;
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);
        getMaxSumFromRootToLeaf(root,maxSum,tmpSum);
        System.out.println("MaxSumFromRootToLeaf "+maxSum.get());
    }


}
