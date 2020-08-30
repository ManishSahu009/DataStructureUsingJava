package org.ms.ds.binarytree;

/*
https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
              1
           /    \
          2      3
         / \    / \
        4   5  6   7

 */
public class BSTToDoublyLinkedList {

    static TreeNode<Integer> prev = null;
    TreeNode<Integer> head = null;


     void binaryTree2DoubleLinkedList(TreeNode<Integer> root)
    {
        if (root == null)
            return;
        binaryTree2DoubleLinkedList(root.left);
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryTree2DoubleLinkedList(root.right);
    }

    static void printList(TreeNode<Integer> treeNode)
    {
        while (treeNode != null)
        {
            System.out.print(treeNode.data + " ");
            treeNode = treeNode.right;
        }
    }


    public static void main(String[] args)
    {
        BSTToDoublyLinkedList bstToDoublyLinkedList=new BSTToDoublyLinkedList();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        bstToDoublyLinkedList.binaryTree2DoubleLinkedList(root);
        printList(bstToDoublyLinkedList.head);

    }



}
