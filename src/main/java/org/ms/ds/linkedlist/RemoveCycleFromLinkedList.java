package org.ms.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveCycleFromLinkedList {

    public static LinkedListNode<Integer> isCycleFound(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }

    public static void removeCycle(LinkedListNode<Integer> meetingPOint,LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp=head;
        while (meetingPOint.next!=temp){
            temp=temp.next;
            meetingPOint=meetingPOint.next;
        }
        meetingPOint.next=null;

    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head=new LinkedListNode<>(1);
        head.next=new LinkedListNode<>(2);
        head.next.next=new LinkedListNode<>(3);
        head.next.next.next=new LinkedListNode<>(4);
        head.next.next.next.next=new LinkedListNode<>(5);
        head.next.next.next.next.next=new LinkedListNode<>(6);
        head.next.next.next.next.next.next=head.next.next.next;

        LinkedListNode<Integer> meetingPoint=isCycleFound(head);
        removeCycle(meetingPoint,head);


    }
}
