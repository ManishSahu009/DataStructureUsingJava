package org.ms.ds.linkedlist;

public class ReverseLinkedList {

    public static void reverse(MyLinkedList mll){
        LinkedListNode<Integer> prevNode=null;
        LinkedListNode<Integer> currentNode=mll.head;
        LinkedListNode<Integer> nextNode=mll.head;

        while (nextNode!=null){
            nextNode=nextNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;

        }
        mll.head=prevNode;

    }

    public static void reverseUsingRecursion(MyLinkedList mll){
        mll.head=reverseUsingRecursionUtil(mll.head);
    }

    public static LinkedListNode<Integer> reverseUsingRecursionUtil(LinkedListNode<Integer> node){
        if(node == null || node.next==null){
            return node;
        }
        LinkedListNode<Integer> head=reverseUsingRecursionUtil(node.next);
        node.next.next=node;
        node.next=null;
        return head;

    }



    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtEnd(11);
        mll.insertAtEnd(18);
        mll.insertAtEnd(22);
        mll.insertAtEnd(45);
        mll.insertAtEnd(97);
        mll.insertAtEnd(102);

        mll.printLinkedList();
        reverse(mll);
        System.out.println();
        mll.printLinkedList();
        System.out.println();
        reverseUsingRecursion(mll);
        mll.printLinkedList();

    }

}
