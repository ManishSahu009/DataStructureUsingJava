package org.ms.ds.binarytree;


/*
https://javabypatel.blogspot.com/2016/10/convert-sorted-linked-list-to-bst.html

Get the middle node of the linked list and make it Root Node.
Now the list is splitted into 2 parts left side of middle node and right side of middle node.
Recursively do same for left side and right side.
a) find the middle element of left side and make it Left child of Root Node created in step 1.
b) find the middle element of right side and make it Right child of Root Node created in step 1.



 */

import org.ms.ds.linkedlist.LinkedListNode;

public class SortedLinkedListToBalancedBST {

    private static TreeNode<Integer> sortedLinkedListToBalancedBSTTopDown(LinkedListNode<Integer> head){
        if(head==null){
            return null;
        }
        if(head.getNext()==null){
            return new TreeNode<Integer>(head.getData());
        }

        LinkedListNode<Integer> slowPointer = head;
        LinkedListNode<Integer> fastPointer = head;
        LinkedListNode<Integer> previousPointer = null;

        while(fastPointer!=null && fastPointer.getNext()!=null){
            fastPointer = fastPointer.getNext().getNext();
            previousPointer = slowPointer;
            slowPointer = slowPointer.getNext();
        }

        LinkedListNode<Integer> middle = slowPointer;
        if(previousPointer!=null){
            middle = previousPointer.getNext();
            previousPointer.setNext(null);
        }

        TreeNode<Integer> node = new TreeNode<>(middle.getData());
        node.setLeft(sortedLinkedListToBalancedBSTTopDown(head));
        node.setRight(sortedLinkedListToBalancedBSTTopDown(middle.getNext()));
        return node;
    }

    private static void printTreeInOrder(TreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        printTreeInOrder(rootNode.getLeft());
        System.out.print(rootNode.getData() + " ");
        printTreeInOrder(rootNode.getRight());
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> lln2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> lln3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> lln4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> lln5 = new LinkedListNode<>(5);
        LinkedListNode<Integer> lln6 = new LinkedListNode<>(6);
        LinkedListNode<Integer> lln7 = new LinkedListNode<>(7);

        head.setNext(lln2);
        lln2.setNext(lln3);
        lln3.setNext(lln4);
        lln4.setNext(lln5);
        lln5.setNext(lln6);
        lln6.setNext(lln7);

        TreeNode<Integer> balancedBSTTopDown = sortedLinkedListToBalancedBSTTopDown(head);
        printTreeInOrder(balancedBSTTopDown);

    }

}
