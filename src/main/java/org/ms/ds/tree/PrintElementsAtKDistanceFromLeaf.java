package org.ms.ds.tree;

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

    public static boolean isLeaf(Node<Integer> node) {
        return (node.left == null && node.right == null);
    }

    public static void leafNodeDistance(Node<Integer> node, List<Node<Integer>> path,
                                        Set<Node<Integer>> set, int dist)
    {
        if (node == null) {
            return;
        }
        if (isLeaf(node) && path.size() >= dist)
        {
            set.add(path.get(path.size() - dist));
            return;
        }
        path.add(node);

        leafNodeDistance(node.left, path, set, dist);
        leafNodeDistance(node.right, path, set, dist);

        path.remove(node);
    }

    public static void leafNodeDistance(Node<Integer> node, int dist)
    {
        // list to store root to leaf path
        List<Node<Integer>> path = new ArrayList<>();

        // create an empty set to store distinct nodes at given
        // distance from leaf nodes
        Set<Node<Integer>> set = new HashSet<>();

        // find all nodes
        leafNodeDistance(node, path, set, dist);

        // print output
        for (Node<Integer> e: set) {
            System.out.print(e.data + " ");
        }
    }


    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        root.right.left.left = new Node<>(18);

        int dist = 1;
        leafNodeDistance(root, dist);
    }
}
