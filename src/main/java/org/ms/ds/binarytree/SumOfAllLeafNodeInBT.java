package org.ms.ds.binarytree;

  /* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     / \     /
		    4   5   6
	    */

import java.util.concurrent.atomic.AtomicInteger;

public class SumOfAllLeafNodeInBT {

    private static void getSumOfAllLeaf(TreeNode<Integer> root, AtomicInteger sum) {
        if(root==null)
            return ;
        if(root.left==null && root.right==null){
            sum.addAndGet(root.data);
        }
        getSumOfAllLeaf(root.left,sum);
        getSumOfAllLeaf(root.right,sum);

    }

    public static void main(String[] args) {
        AtomicInteger sum=new AtomicInteger(0);
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        getSumOfAllLeaf(root,sum);
        System.out.println("SUm matches : " + sum.get());
    }


}
