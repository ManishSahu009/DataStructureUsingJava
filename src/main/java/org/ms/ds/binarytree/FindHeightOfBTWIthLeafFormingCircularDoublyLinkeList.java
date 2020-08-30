package org.ms.ds.binarytree;

public class FindHeightOfBTWIthLeafFormingCircularDoublyLinkeList {

    public static int height(TreeNode<Integer> node)
    {
        if (node == null) {
            return 0;
        }
        if ((node.left != null && node.left.right == node) &&
                (node.right != null  && node.right.left == node)) {
            return 1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.left.left.left = new TreeNode<>(7);

        TreeNode<Integer> first = root.left.left.left;
        TreeNode<Integer> second = root.left.right;
        TreeNode<Integer> third = root.right.right;

        first.left = third;
        first.right = second;

        second.left = first;
        second.right = third;

        third.left = second;
        third.right = first;

        System.out.println("The height of given binary tree is " + height(root));
    }

}
