package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

import java.util.*;

public class SpiralOrderTraversal {

    private static List<List<Integer>> levelOrderTraversalIterative(TreeNode<Integer> root){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            TreeNode<Integer> temp=queue.poll();
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

    public static void printSpiralOrderIteative(TreeNode<Integer> treeNode){
       List<List<Integer>> lists=levelOrderTraversalIterative(treeNode);
       for(int i=0 ; i<lists.size();i++){
           if(lists.get(i)!=null){
               if(i%2 == 0){
                   lists.get(i).forEach(e-> System.out.print(e + " "));
               }else{
                   Collections.reverse(lists.get(i));
                   lists.get(i).forEach(e-> System.out.print(e + " "));
               }
               System.out.println();
           }

       }
    }

    /*
    1. push root in s1
    2. pop from s1 and print
    3. push in s2
    4. pop from s2 and print
    5. push in s1

    */
    public static void printSpiralOrderUsingStack(TreeNode<Integer> root){
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode<Integer> temp=s1.pop();
                System.out.print(temp.data +" ");
                if(temp.left!=null){
                    s2.push(temp.left);
                }
                if(temp.right!=null){
                    s2.push(temp.right);
                }
            }
            while(!s2.isEmpty()){
                TreeNode<Integer> temp=s2.pop();
                System.out.print(temp.data + " ");
                if(temp.right!=null){
                    s1.push(temp.right);
                }
                if(temp.left!=null){
                    s1.push(temp.left);
                }
            }
        }


    }



    public static void printSpiralOrderRecursion(TreeNode<Integer> root){

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        printSpiralOrderIteative(root);
        printSpiralOrderRecursion(root);
        printSpiralOrderUsingStack(root);

    }

}
