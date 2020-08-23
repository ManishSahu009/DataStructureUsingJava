package org.ms.ds.tree;

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

    static int getLevel(Node<Integer> root, int data)
    {
        Queue<Node<Integer>> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty())
        {
            Node<Integer> temp = q.poll();
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

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        root.right.right.right=new Node<>(11);
        System.out.println(getLevel(root,6));


    }
}
