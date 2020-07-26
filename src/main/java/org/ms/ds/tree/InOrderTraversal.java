package org.ms.ds.tree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */


import java.util.Stack;

public class InOrderTraversal {

    public static void inorderTraversalRecursion(Node<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursion(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRecursion(root.right);
    }

    public static void inorderTraversalIterative(Node<Integer> root) {

    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);

    }


}
