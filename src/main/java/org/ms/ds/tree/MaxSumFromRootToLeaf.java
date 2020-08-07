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

 */

import java.util.concurrent.atomic.AtomicInteger;

public class MaxSumFromRootToLeaf {

    private static void getMaxSumFromRootToLeaf(Node<Integer> root, AtomicInteger maxSum,int tempSum) {

        if(root == null){
            return;
        }
        if(root.left ==null && root.right==null && (tempSum+root.data > maxSum.get())){
           maxSum.set(tempSum+root.data);
           return;
        }
        getMaxSumFromRootToLeaf(root.left,maxSum,tempSum+root.data);
        getMaxSumFromRootToLeaf(root.right,maxSum,tempSum+root.data);
    }


    public static void main(String[] args)
    {
        AtomicInteger maxSum=new AtomicInteger(0);
        int tmpSum=0;
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        getMaxSumFromRootToLeaf(root,maxSum,tmpSum);
        System.out.println("MaxSumFromRootToLeaf "+maxSum.get());
    }


}
