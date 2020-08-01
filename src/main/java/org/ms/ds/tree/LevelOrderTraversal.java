package org.ms.ds.tree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

import java.util.*;

public class LevelOrderTraversal {

    public static void printLevel(Node<Integer> root,int level){
        if (root == null) {
            return ;
        }
        if (level == 1)
        {
            System.out.print(root.data + " ");
            return;
        }
        printLevel(root.left, level - 1);
        printLevel(root.right, level - 1);
    }

    public static void levelOrderTraversalRecursion(Node root)
    {
        int level = 1;
        while (level <= HeightOfABinaryTree.getHeigthRecursive(root) ) {
            printLevel(root,level);
            level++;
        }
    }

    public static void levelOrderTraversalIterative(Node<Integer> root){

        Queue<Node<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
           Node<Integer> temp=queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    public static List<List<Integer>> levelOrderTraversalIterative2(Node<Integer> root){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            Node<Integer> temp=queue.poll();
            if(temp!=null){
                current.add(temp.data);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }else{
                List<Integer> tempList=new ArrayList<>(current);
                result.add(tempList);
                current.clear();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        levelOrderTraversalRecursion(root);
        System.out.println();
        levelOrderTraversalIterative(root);
        System.out.println();
        levelOrderTraversalIterative2(root).forEach(e->e.forEach(t-> System.out.print(t.intValue()+" ")));

    }

}
