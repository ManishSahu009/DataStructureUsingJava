package org.ms.ds.tree;

import java.util.Stack;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */


public class EvenOddLevelDiff {


    public static int getDifferenceEvenOddvalues(Node<Integer> root) {

        if(root == null){
            return 0;
        }
        int lv=getDifferenceEvenOddvalues(root.left);
        int rv=getDifferenceEvenOddvalues(root.right);
        return root.data - (lv+rv);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println(getDifferenceEvenOddvalues(root));

    }
}

