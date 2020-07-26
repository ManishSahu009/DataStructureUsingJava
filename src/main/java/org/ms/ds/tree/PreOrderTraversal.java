package org.ms.ds.tree;

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

    public static void preorderTraversalRecursion(Node<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);
    }

    public static void preorderTraversalIterative(Node<Integer> root){
        List<Integer> eleList=new ArrayList<>();
        Stack<Node<Integer>> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<Integer> temp=stack.pop();
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
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        preorderTraversalRecursion(root);
        System.out.println();
        preorderTraversalIterative(root);

    }
}
