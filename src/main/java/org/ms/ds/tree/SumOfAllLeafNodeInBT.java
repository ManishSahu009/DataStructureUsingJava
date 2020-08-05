package org.ms.ds.tree;

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

    private static void getSumOfAllLeaf(Node<Integer> root, AtomicInteger sum) {
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
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        getSumOfAllLeaf(root,sum);
        System.out.println("SUm matches : " + sum.get());
    }


}
