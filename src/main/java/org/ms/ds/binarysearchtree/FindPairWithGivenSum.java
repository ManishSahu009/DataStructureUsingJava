package org.ms.ds.binarysearchtree;

import org.ms.ds.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {

    public static boolean findPair(TreeNode<Integer> root, Integer sum, Map<Integer, Integer> map) {
        if (root ==null) {
            return false;
        }
        findPair(root.left,sum,map);

        if(map.containsKey(root.data)){
            System.out.println((sum-root.data) +" - "+ root.data);
            return true;
        }else{
            map.put(sum-root.data,root.data);
        }
        return findPair(root.right,sum,map);

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
        root.right.right.right = new TreeNode<>(11);

        Integer sum = 11;
        Map<Integer, Integer> map = new HashMap<>();
        if (!findPair(root, sum, map)) {
            System.out.println("Pair not found");
        }

    }
}
