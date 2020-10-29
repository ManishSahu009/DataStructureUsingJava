package org.ms.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInLinkedList {

    public static boolean isCycleFound(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleFoundUsingHash(LinkedListNode<Integer> head){
        LinkedListNode<Integer> current=head;
        Set<LinkedListNode<Integer>> set=new HashSet<>();
        while(current !=null){
            if(set.contains(current)){
                return true;
            }
            set.add(current);
            current=current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head=new LinkedListNode<>(1);
        head.next=new LinkedListNode<>(2);
        head.next.next=new LinkedListNode<>(3);
        head.next.next.next=new LinkedListNode<>(4);
        head.next.next.next.next=new LinkedListNode<>(5);
        head.next.next.next.next.next=new LinkedListNode<>(6);
        head.next.next.next.next.next.next=head.next.next.next;
        System.out.println("Is loop found "+ isCycleFound(head));
        System.out.println("Is loop found using hash"+ isCycleFoundUsingHash(head));
    }
}
