package org.ms.ds.linkedlist;

import java.util.HashMap;

public class RemoveDuplicateFromUnsortedLinkedList {

    public static LinkedListNode<Integer> removeDuplicateUsingHashMap(LinkedListNode<Integer> head) {
        if(head == null){
            return null;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        LinkedListNode<Integer> nextNode=head;
        LinkedListNode<Integer> prevNode=null;
        while(nextNode != null){
            if(!map.containsKey(nextNode.data)){
                map.put(nextNode.data,1);
                prevNode=nextNode;
            }else{
                prevNode.next=nextNode.next;
            }
            nextNode=nextNode.next;
        }

        return head;

    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtEnd(11);
        mll.insertAtEnd(102);
        mll.insertAtEnd(22);
        mll.insertAtEnd(22);
        mll.insertAtEnd(102);
        mll.insertAtEnd(203);
        mll.insertAtEnd(240);
        mll.insertAtEnd(45);

        mll.printLinkedList();

        mll.head=removeDuplicateUsingHashMap(mll.head);
        System.out.println();
        mll.printLinkedList();
    }

}
