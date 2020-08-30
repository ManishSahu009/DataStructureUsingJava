package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public static void preorderTraversalRecursion(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);
    }

    public static void preorderTraversalIterative(TreeNode<Integer> root){
        List<Integer> eleList=new ArrayList<>();
        Stack<TreeNode<Integer>> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<Integer> temp=stack.pop();
            eleList.add(temp.data);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
        eleList.forEach(e-> System.out.print(e+" "));
    }



    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        preorderTraversalRecursion(root);
        System.out.println();
        preorderTraversalIterative(root);

    }
}
