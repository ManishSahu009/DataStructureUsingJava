package org.ms.ds.tree;

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

    public static void printLeftView(Node<Integer> root){
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

    public static void printRightView(Node<Integer> root){
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


    public static void printLeaf(Node<Integer> root){
        if(root == null){
            return;
        }
        printLeaf(root.left);
        if(root.left==null && root.right==null){
            System.out.print(root.data);
        }printLeaf(root.right);
    }

    private static void printBoundaryViewRecursion(Node<Integer> root) {

        printLeftView(root);
        printLeaf(root);
        printRightView(root);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        printBoundaryViewRecursion(root);

    }



}
