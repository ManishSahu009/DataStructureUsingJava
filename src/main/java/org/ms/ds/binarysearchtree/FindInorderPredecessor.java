package org.ms.ds.binarysearchtree;

import org.ms.ds.binarytree.TreeNode;

public class FindInorderPredecessor {

    public static TreeNode<Integer> insert(TreeNode<Integer> root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode<Integer>(key);
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static TreeNode<Integer> findPredecessor(TreeNode<Integer> root, TreeNode<Integer> prec, int key)
    {
        // base case
        if (root == null) {
            return prec;
        }

        // if node with key's value is found, the predecessor is maximum
        // value node in its left subtree (if any)
        if (root.data == key) {
            if (root.left != null) {
                return findMaximum(root.left);
            }
        }

        // if given key is less than the root node, recur for left subtree
        else if (key < root.data) {
            return findPredecessor(root.left, prec, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            // update predecessor to current node before recursing
            // in right subtree
            prec = root;
            return findPredecessor(root.right, prec, key);
        }
        return prec;
    }

    public static TreeNode<Integer> findPredecessor(TreeNode<Integer> root, int key)
    {
        TreeNode<Integer> prec = null;

        while (true)
        {
            // if given key is less than the root node, visit left subtree
            if (key < root.data) {
                root = root.left;
            }

            // if given key is more than the root node, visit right subtree
            else if (key > root.data)
            {
                // update predecessor to current node before visiting
                // right subtree
                prec = root;
                root = root.right;
            }

            // if node with key's value is found, predecessor is maximum
            // value node in its left subtree (if any)
            else
            {
                if (root.left!= null) {
                    prec = findMaximum(root.left);
                }
                break;
            }

            // if key doesn't exist in binary tree
            if (root == null)
                return null;
        }

        // return predecessor if any
        return prec;
    }

    // Helper function to find maximum value node in given BST
    public static TreeNode<Integer> findMaximum(TreeNode<Integer> root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }


    public static void main(String[] args)
    {
		/* Construct below tree
				   15
				 /	\
				/	  \
			   10	   20
			  /  \	 /  \
			 /	\   /	\
			8	 12 16	25
		*/

        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        TreeNode<Integer> root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        // find in-order successor for each key
        for (int key : keys)
        {
            TreeNode<Integer> prec = findPredecessor(root, key);

            if (prec != null) {
                System.out.println("Successor of node " + key + " is "
                        + prec.data);
            } else {
                System.out.println("Successor doesn't exists for node "
                        + key);
            }
        }
    }
}
