package org.ms.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;


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

public class FindLevelOfgivenNode {

    static int getLevel(TreeNode<Integer> root, int data)
    {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty())
        {
            TreeNode<Integer> temp = q.poll();
            if (temp == null)
            {
                if (q.peek() != null)
                {
                    q.add(null);
                }
                level += 1;
            }
            else
            {
                if (temp.data == data)
                {
                    return level;
                }
                if (temp.left != null)
                {
                    q.add(temp.left);
                }
                if (temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
        return 0;
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
        root.right.right.right=new TreeNode<>(11);
        System.out.println(getLevel(root,6));


    }
}
