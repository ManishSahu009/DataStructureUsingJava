package org.ms.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */
public class HeightOfABinaryTree {

    public  static  int getHeigthRecursive(Node<Integer> root){
     if(root == null){
         return 0;
     }
     return 1+Math.max(getHeigthRecursive(root.left),getHeigthRecursive(root.right));
    }

    public static int getHeigthInterative(Node<Integer> root){
        int count=1;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            Node<Integer> temp=queue.poll();
            if(temp !=null){
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right !=null){
                    queue.offer(temp.right);
                }

            }else{
                if(!queue.isEmpty()){
                   count++;
                   queue.offer(null);
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println(getHeigthRecursive(root));
        System.out.println(getHeigthInterative(root));

    }
}
