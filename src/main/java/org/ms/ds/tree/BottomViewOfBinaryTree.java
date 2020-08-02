package org.ms.ds.tree;

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

public class BottomViewOfBinaryTree {



    private static void printBottomView(Node<Integer> root, int level, int hdist, Map<Integer,Pair<Integer,Integer>> map) {

        if(root == null){
            return;
        }
        if(!map.containsKey(hdist) || level >= map.get(hdist).second){
            map.put(hdist,Pair.of(root.data,level));
        }
        printBottomView(root.left,level+1,hdist-1,map);
        printBottomView(root.right,level+1,hdist+1,map);

    }

    public static void printBottomViewRecursion(Node<Integer> root) {
        Map<Integer,Pair<Integer,Integer>> map=new TreeMap<>();
        printBottomView(root,0,0,map);
        map.forEach((k,v) -> System.out.println(k + "--->" + v.first));

    }

    public static void printBottomViewIterative(Node<Integer> root){

        if(root ==  null){
            return;
        }
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<Integer> temp=queue.poll();
            int hd=temp.horizontalDistance;
            map.put(hd,temp.data);

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
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        printBottomViewRecursion(root);
        printBottomViewIterative(root);
    }
}
