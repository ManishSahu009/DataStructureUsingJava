package org.ms.ds.binarytree;

/*
                          1
                      /        \
                     2           3
                      \        /   \
                       4      5     6
                            /   \
                           7     8
 */

public class BoundaryTraversalOfBinaryTree {

    public static void printLeftView(TreeNode<Integer> root){
        if(root == null){
            return;
        }
            if(root.left !=null){
                System.out.print(root.data+" ");
                printLeftView(root.left);
            }else if(root.right !=null){
                System.out.print(root.data+" ");
                printLeftView(root.right);
            }

    }

    public static void printRightView(TreeNode<Integer> root){
        if(root == null){
            return;
        }
            if(root.right !=null){
                System.out.print(root.data+" ");
                printRightView(root.right);
            }else if(root.left !=null){
                System.out.print(root.data+" ");
                printRightView(root.left);
            }
        }


    public static void printLeaf(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        printLeaf(root.left);
        if(root.left==null && root.right==null){
            System.out.print(root.data);
        }printLeaf(root.right);
    }

    private static void printBoundaryViewRecursion(TreeNode<Integer> root) {

        printLeftView(root);
        printLeaf(root);
        printRightView(root);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        printBoundaryViewRecursion(root);

    }



}
