package org.ms.ds.tree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

import java.util.Stack;

public class PostOrderTraversal {
    public static void postorderTraversalRecusion(Node<Integer> root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecusion(root.left);
        postorderTraversalRecusion(root.right);
        System.out.print(root.data + " ");
    }

    public static void postorderTraversalIterative(Node<Integer> root) {
        Stack<Node<Integer>> s1 = new Stack<>();
        Stack<Node<Integer>> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node<Integer> temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        postorderTraversalRecusion(root);
        System.out.println();
        postorderTraversalIterative(root);
    }
}
