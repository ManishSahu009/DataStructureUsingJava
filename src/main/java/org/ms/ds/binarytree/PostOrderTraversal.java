package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

import java.util.Stack;

public class PostOrderTraversal {
    public static void postorderTraversalRecusion(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecusion(root.left);
        postorderTraversalRecusion(root.right);
        System.out.print(root.data + " ");
    }

    public static void postorderTraversalIterative(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        Stack<TreeNode<Integer>> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode<Integer> temp = s1.pop();
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
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        postorderTraversalRecusion(root);
        System.out.println();
        postorderTraversalIterative(root);
    }
}
