package org.ms.ds.tree;


/*
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

public class MinDistanceLeafToRoot {

    private static int getMinDistanceLeafToRoot(Node<Integer> root) {

        if(root == null)
            return 0;

        if(root.left==null && root.right==null){
            return 0;
        }
        return 1 + Math.min(getMinDistanceLeafToRoot(root.left),getMinDistanceLeafToRoot(root.right));

    }

    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        System.out.println(getMinDistanceLeafToRoot(root));
    }


}
