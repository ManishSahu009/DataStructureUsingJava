package org.ms.ds.tree;

/*
https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
              1
           /    \
          2      3
         / \    / \
        4   5  6   7

 */
public class BSTToDoublyLinkedList {

    static Node<Integer> prev = null;
    Node<Integer> head = null;


     void binaryTree2DoubleLinkedList(Node<Integer> root)
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

    static void printList(Node<Integer> node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }


    public static void main(String[] args)
    {
        BSTToDoublyLinkedList bstToDoublyLinkedList=new BSTToDoublyLinkedList();
        Node<Integer> root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bstToDoublyLinkedList.binaryTree2DoubleLinkedList(root);
        printList(bstToDoublyLinkedList.head);

    }



}
