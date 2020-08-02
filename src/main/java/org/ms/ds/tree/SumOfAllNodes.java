package org.ms.ds.tree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

public class SumOfAllNodes {

    public static int getSumUsingRecursion(Node<Integer> root){
        if(root == null){
            return 0;
        }
        int lsum=getSumUsingRecursion(root.left);
        int rsum=getSumUsingRecursion(root.right);
        return root.data + lsum + rsum;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println(getSumUsingRecursion(root));

    }
}