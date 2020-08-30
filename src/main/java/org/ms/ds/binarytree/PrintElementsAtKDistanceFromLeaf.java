package org.ms.ds.binarytree;

/* Construct below tree
		          15
		        /    \
		       /      \
		      10       20
		     / \      /  \
		    8   12   16  25
		            /
		           18
		*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintElementsAtKDistanceFromLeaf {

    public static boolean isLeaf(TreeNode<Integer> treeNode) {
        return (treeNode.left == null && treeNode.right == null);
    }

    public static void leafNodeDistance(TreeNode<Integer> treeNode, List<TreeNode<Integer>> path,
                                        Set<TreeNode<Integer>> set, int dist)
    {
        if (treeNode == null) {
            return;
        }
        if (isLeaf(treeNode) && path.size() >= dist)
        {
            set.add(path.get(path.size() - dist));
            return;
        }
        path.add(treeNode);

        leafNodeDistance(treeNode.left, path, set, dist);
        leafNodeDistance(treeNode.right, path, set, dist);

        path.remove(treeNode);
    }

    public static void leafNodeDistance(TreeNode<Integer> treeNode, int dist)
    {
        // list to store root to leaf path
        List<TreeNode<Integer>> path = new ArrayList<>();

        // create an empty set to store distinct nodes at given
        // distance from leaf nodes
        Set<TreeNode<Integer>> set = new HashSet<>();

        // find all nodes
        leafNodeDistance(treeNode, path, set, dist);

        // print output
        for (TreeNode<Integer> e: set) {
            System.out.print(e.data + " ");
        }
    }


    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        root.right.left.left = new TreeNode<>(18);

        int dist = 1;
        leafNodeDistance(root, dist);
    }
}
