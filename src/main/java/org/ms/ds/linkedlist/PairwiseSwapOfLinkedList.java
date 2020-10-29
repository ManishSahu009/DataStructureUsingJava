package org.ms.ds.linkedlist;

public class PairwiseSwapOfLinkedList {



    public static LinkedListNode<Integer> pairswap(LinkedListNode<Integer> head){
        LinkedListNode<Integer> prevNode=null;
        LinkedListNode<Integer> currentNode=head;
        LinkedListNode<Integer> nextNode=head;
        int count=0;

        while (nextNode!=null && count < 2){
            nextNode=nextNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
            count++;
        }
        if(nextNode!=null){
            head.next=pairswap(nextNode);
        }
        return prevNode;
    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtEnd(11);
        mll.insertAtEnd(18);
        mll.insertAtEnd(22);
        mll.insertAtEnd(45);
        mll.insertAtEnd(97);
        mll.insertAtEnd(102);
        mll.insertAtEnd(203);
        mll.insertAtEnd(240);

        mll.printLinkedList();
        mll.head=pairswap(mll.head);
        System.out.println();
        mll.printLinkedList();

    }

}
