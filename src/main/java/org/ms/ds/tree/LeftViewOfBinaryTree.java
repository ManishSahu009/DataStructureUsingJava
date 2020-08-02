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

import java.util.*;

public class LeftViewOfBinaryTree {



    private static void leftView(Node<Integer> root,int level, Map<Integer,Integer> map){

        if(root == null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level,root.data);
        }
        leftView(root.left,level+1,map);
        leftView(root.right,level+1,map);
    }

    public static void printLeftViewUsingRecursion(Node<Integer> root) {
        Map<Integer,Integer> map=new HashMap<>();
        leftView(root,1,map);
        map.forEach((k,v)->System.out.print(v+" "));
    }



    public static void printLeftViewUsingIterative(Node<Integer> root) {
        List<List<Node<Integer>>> result=new ArrayList<>();
        Queue<Node<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Node<Integer>> current=new ArrayList<>();
        while(!queue.isEmpty()){
            Node<Integer> tempNode=queue.poll();
            if(tempNode!=null){
                current.add(tempNode);
                if(tempNode.left!=null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    queue.offer(tempNode.right);
                }
            }else{
                List<Node<Integer>> tempList=new ArrayList<>(current);
                result.add(tempList);
                current.clear();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }

        result.forEach(e-> {
            System.out.print(e.get(0).data+" ");
        });

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
        printLeftViewUsingRecursion(root);
        System.out.println();
        printLeftViewUsingIterative(root);
        System.out.println();


    }
}
