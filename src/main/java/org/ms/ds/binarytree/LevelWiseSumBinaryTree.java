package org.ms.ds.binarytree;

/* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \
		       /     \
		      7       8
		            /   \
		           /     \
		          9      10

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelWiseSumBinaryTree {

    public static void printLevelWiseSum(TreeNode<Integer> root){
        List<List<Integer>>  result=new ArrayList<>();
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> current=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode<Integer> temp=queue.poll();
            if(temp!=null) {
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
        result.forEach(e -> System.out.println(e.stream().mapToInt(Integer::intValue).sum()));
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);
        printLevelWiseSum(root);
    }
}
