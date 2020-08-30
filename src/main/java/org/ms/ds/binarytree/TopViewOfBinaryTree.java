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

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {



    private static void printTopView(TreeNode<Integer> root, int level, int hdist, Map<Integer,Pair<Integer,Integer>> map) {

        if(root == null){
            return;
        }
        if(!map.containsKey(hdist) || level < map.get(hdist).second){
           map.put(hdist,Pair.of(root.data,level));
        }
        printTopView(root.left,level+1,hdist-1,map);
        printTopView(root.right,level+1,hdist+1,map);

    }

    public static void printTopViewRecursion(TreeNode<Integer> root) {
       Map<Integer,Pair<Integer,Integer>> map=new TreeMap<>();
       printTopView(root,0,0,map);
       map.forEach((k,v) -> System.out.println(k + "--->" + v.first));

    }

    public static void printTopViewIterative(TreeNode<Integer> root){

        if(root ==  null){
            return;
        }
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> temp=queue.poll();
            int hd=temp.horizontalDistance;
            if(!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            if(temp.left !=null){
                temp.left.horizontalDistance=hd-1;
                queue.offer(temp.left);
            }
            if(temp.right !=null){
                temp.right.horizontalDistance=hd+1;
                queue.offer(temp.right);
            }
        }
        System.out.println(map.values());

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
        printTopViewRecursion(root);
        printTopViewIterative(root);
    }
}
