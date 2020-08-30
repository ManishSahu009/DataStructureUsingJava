package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */


public class EvenOddLevelDiff {


    public static int getDifferenceEvenOddvalues(TreeNode<Integer> root) {

        if(root == null){
            return 0;
        }
        int lv=getDifferenceEvenOddvalues(root.left);
        int rv=getDifferenceEvenOddvalues(root.right);
        return root.data - (lv+rv);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println(getDifferenceEvenOddvalues(root));

    }
}

