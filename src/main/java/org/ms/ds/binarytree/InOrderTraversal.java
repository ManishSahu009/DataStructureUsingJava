package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */


import java.util.Stack;

public class InOrderTraversal {

    public static void inorderTraversalRecursion(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursion(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRecursion(root.right);
    }

    public static void inorderTraversalIterative(TreeNode<Integer> root) {
        if(root == null){
            return;
        }
        Stack<TreeNode<Integer>> stack=new Stack<>();
        while (true){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                root=stack.pop();
                System.out.print(root.data + " ");
                root=root.right;
            }
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
        inorderTraversalRecursion(root);
        System.out.println();
        inorderTraversalIterative(root);
    }


}
