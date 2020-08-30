package org.ms.ds.binarytree;

/*
                          1
                      /        \
                     2           3
                      \        /   \
                       4      5     6
                            /   \
                           7     8
 */

import java.util.*;

public class RightViewOfBinaryTree {



    private static void rightView(TreeNode<Integer> root, int level, Map<Integer,Integer> map){

        if(root == null){
            return;
        }
        map.put(level,root.data);
        rightView(root.left,level+1,map);
        rightView(root.right,level+1,map);
    }

    public static void printRightViewUsingRecursion(TreeNode<Integer> root) {
        Map<Integer,Integer> map=new HashMap<>();
        rightView(root,1,map);
        map.forEach((k,v)->System.out.print(v+" "));
    }

    public static void printrightViewUsingIterative(TreeNode<Integer> root) {
        List<List<TreeNode<Integer>>> result=new ArrayList<>();
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<TreeNode<Integer>> current=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode<Integer> tempTreeNode =queue.poll();
            if(tempTreeNode !=null){
                current.add(tempTreeNode);
                if(tempTreeNode.left!=null){
                    queue.offer(tempTreeNode.left);
                }
                if(tempTreeNode.right!=null){
                    queue.offer(tempTreeNode.right);
                }
            }else{
                List<TreeNode<Integer>> tempList=new ArrayList<>(current);
                result.add(tempList);
                current.clear();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }

        result.forEach(e-> {
            System.out.print(e.get(e.size()-1).data+" ");
        });

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        printRightViewUsingRecursion(root);
        System.out.println();
        printrightViewUsingIterative(root);

    }
}
