package org.ms.ds.binarysearchtree;

/*
case 1: if the node "p" has the right subtree then
jump to that right child and go to the left most node (node with least value)
case 2: if the node "p" does not have the right subtree then
search that node from the root and the node from where we take the last left is the answer
 */

import org.ms.ds.binarytree.TreeNode;

public class FindInorderSuccessor {


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

    // Helper function to find minimum value node in given BST
    public static TreeNode<Integer> findMinimum(TreeNode<Integer> root)
    {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }


    public static TreeNode<Integer> findSuccessor(TreeNode<Integer> root, TreeNode<Integer> succ, int key)
    {
        // base case
        if (root == null) {
            return null;
        }

        // if node with key's value is found, the successor is minimum
        // value node in its right subtree (if any)
        if (root.data == key)
        {
            if (root.right != null) {
                return findMinimum(root.right);
            }
        }

        // if given key is less than the root node, recur for left subtree
        else if (key < root.data)
        {
            // update successor to current node before recursing in
            // left subtree
            succ = root;
            return findSuccessor(root.left, succ, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            return findSuccessor(root.right, succ, key);
        }

        return succ;
    }

    public static TreeNode<Integer> findSuccessor(TreeNode<Integer> root, int key)
    {
        TreeNode<Integer> succ = null;

        while (true)
        {
            // if given key is less than the root node, visit left subtree
            if (key < root.data)
            {
                // update successor to current node before visiting
                // left subtree
                succ = root;
                root = root.left;
            }

            // if given key is more than the root node, visit right subtree
            else if (key > root.data)
            {
                root = root.right;
            }

            // if node with key's value is found, the successor is minimum
            // value node in its right subtree (if any)
            else
            {
                if (root.right != null) {
                    succ = findMinimum(root.right);
                }
                break;
            }

            // if key doesn't exist in binary tree
            if (root == null)
                return null;
        }

        // return Successor if any
        return succ;
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
            TreeNode<Integer> prec = findSuccessor(root, null, key);

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
