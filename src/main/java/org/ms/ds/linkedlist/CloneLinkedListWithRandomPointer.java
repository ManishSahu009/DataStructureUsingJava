package org.ms.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        if (head == null) {
            System.out.println("Nothing to print");
            return;
        }
        while (temp != null) {
            System.out.print("-->" + temp.data);
            temp = temp.next;
        }
    }


    public static void updateRandomPointers(LinkedListNode<Integer> head, Map<LinkedListNode<Integer>, LinkedListNode<Integer>> map) {
        if(map.get(head) == null){
            return;
        }
        LinkedListNode<Integer> current=head;
        while(current !=null){
            map.get(current).random=map.get(current.random);
            current=current.next;
        }
    }

    public static LinkedListNode<Integer> cloneLinkedList(LinkedListNode<Integer> head, Map<LinkedListNode<Integer>, LinkedListNode<Integer>> map) {
        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> current=head;
        while(current !=null){
            map.put(current,new LinkedListNode<>(current.data));
            map.get(current).next=current.next;
            current=current.next;
        }
        return map.get(head);
    }


    public static LinkedListNode<Integer> cloneLinkedList(LinkedListNode<Integer> head) {

        Map<LinkedListNode<Integer>, LinkedListNode<Integer>> map = new HashMap<>();
        cloneLinkedList(head, map);
        updateRandomPointers(head, map);
        return map.get(head);
    }


    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        head.random = head.next.next.next;
        head.next.next.random = head.next;

        printLinkedList(head);
        System.out.println();
        LinkedListNode<Integer> clonehead = cloneLinkedList(head);
        printLinkedList(clonehead);


    }
}
