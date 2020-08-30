package org.ms.ds.binarytree;

public class CountLeafNodes {

    public static int getNumberOfLeaf(TreeNode<Integer> root) {

        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        return getNumberOfLeaf(root.left) + getNumberOfLeaf(root.right);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println(getNumberOfLeaf(root));

    }
}


