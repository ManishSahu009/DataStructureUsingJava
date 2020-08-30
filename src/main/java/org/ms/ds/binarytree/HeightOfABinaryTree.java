package org.ms.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */
public class HeightOfABinaryTree {

    public  static  int getHeigthRecursive(TreeNode<Integer> root){
     if(root == null){
         return 0;
     }
     return 1+Math.max(getHeigthRecursive(root.left),getHeigthRecursive(root.right));
    }

    public static int getHeigthInterative(TreeNode<Integer> root){
        int count=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode<Integer> temp=queue.poll();
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
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println(getHeigthRecursive(root));
        System.out.println(getHeigthInterative(root));

    }
}
