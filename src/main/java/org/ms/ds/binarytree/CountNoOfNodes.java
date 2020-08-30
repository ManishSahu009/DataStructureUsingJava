package org.ms.ds.binarytree;

public class CountNoOfNodes {


    public static int getNumberOfNodes(TreeNode<Integer> root) {

        if(root == null){
            return 0;
        }
        int lv=getNumberOfNodes(root.left);
        int rv=getNumberOfNodes(root.right);
        return 1 + (lv+rv);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println(getNumberOfNodes(root));

    }
}
