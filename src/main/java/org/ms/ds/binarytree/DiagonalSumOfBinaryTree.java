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

root =0
left=root+1
right=root

Horizontal distance :
0 : 1+3+6 = 10
1 : 2 + 5 + 8 + 10 = 25
2 : 7+9 = 16

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalSumOfBinaryTree {

    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    private static void printDiagonalSum(TreeNode<Integer> root, int hdist, Map<Integer, List<Integer>> map) {

        if(root==null){
            return;
        }
        insertIntoMultiMap(map,hdist,root.data);
        printDiagonalSum(root.left,hdist+1,map);
        printDiagonalSum(root.right,hdist,map);

    }

    private static void printDiagonalSum(TreeNode<Integer> root) {
        Map<Integer,List<Integer>> map=new TreeMap<>();
        printDiagonalSum(root,0,map);
        map.forEach((k,v) -> System.out.println(k+"-->"+ v.stream().mapToInt(i -> i.intValue()).sum()));

    }

    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);
        printDiagonalSum(root);
    }


}
