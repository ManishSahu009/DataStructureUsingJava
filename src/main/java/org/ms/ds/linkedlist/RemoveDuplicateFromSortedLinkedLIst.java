package org.ms.ds.linkedlist;

import java.util.HashMap;

public class RemoveDuplicateFromSortedLinkedLIst {

    public static LinkedListNode<Integer> removeDuplicateUsingHashMap(LinkedListNode<Integer> head) {
        if(head == null){
            return null;
        }
        LinkedListNode<Integer> currentNode=head;
        while(currentNode.next !=null){
            if(currentNode.data == currentNode.next.data){
                LinkedListNode<Integer> nextNode=currentNode.next.next;
                currentNode.next=nextNode;
            }else{
                currentNode=currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtEnd(11);
        mll.insertAtEnd(22);
        mll.insertAtEnd(22);
        mll.insertAtEnd(45);
        mll.insertAtEnd(102);
        mll.insertAtEnd(102);
        mll.insertAtEnd(203);
        mll.insertAtEnd(240);

        mll.printLinkedList();

        mll.head=removeDuplicateUsingHashMap(mll.head);
        System.out.println();
        mll.printLinkedList();
    }

}
