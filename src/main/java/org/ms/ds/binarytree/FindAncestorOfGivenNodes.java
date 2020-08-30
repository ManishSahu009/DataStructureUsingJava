package org.ms.ds.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/* Construct below tree
	          1
	        /   \
	       /     \
	      2       3
	       \     / \
	        4   5   6
	           / \
	          7   8
	    */
public class FindAncestorOfGivenNodes {


    private static void printTopToBottomPath(Map<Integer, Integer> parentMap, Integer key) {
        while((key=parentMap.get(key))!=0){
            System.out.println(key+" ");
        }
    }

    public static void setParent(TreeNode<Integer> root, Map<Integer, Integer> parentMap){
        Deque<TreeNode<Integer>> stack=new ArrayDeque<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode<Integer> currentNode=stack.poll();
            if(currentNode.right !=null){
                parentMap.put(currentNode.right.data,currentNode.data);
                stack.add(currentNode.right);
            }
            if(currentNode.left !=null){
                parentMap.put(currentNode.left.data,currentNode.data);
                stack.add(currentNode.left);
            }
        }

    }

    public static void printAncestors(TreeNode<Integer> root, Integer key)
    {

        if (root == null)
            return;
        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(root.data, 0);
        setParent(root, parentMap);
        printTopToBottomPath(parentMap, key);
    }


    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.right.right = new TreeNode<>(8);

        int key = 7;
        printAncestors(root, key);
    }

}
