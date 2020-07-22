package org.ms.ds.dp.tree;

import java.util.concurrent.atomic.AtomicInteger;

/*
https://www.geeksforgeeks.org/diameter-of-a-binary-tree/

 */
public class DiameterOfBinaryTree {

    static int  diameter(Node root,AtomicInteger result)
    {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left,result);
        int rdiameter = diameter(root.right,result);

        //if diameter does not go thro current node
        int temp = Math.max(ldiameter,rdiameter) + 1;
        //if diameter does  go thro current node
        int ans =Math.max(temp, 1+ldiameter+rdiameter);
        result.set(Math.max(result.get(),ans));
        return temp; //diameter does not go thro current node

    }

    public static int getDiameter(Node root)
    {
        AtomicInteger diameter = new AtomicInteger(0);
        diameter(root, diameter);

        return diameter.get();
    }




    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        int result=Integer.MIN_VALUE;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + getDiameter(root));
    }
}

class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
