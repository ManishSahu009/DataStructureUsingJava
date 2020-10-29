package org.ms.ds.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedList {

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

    public static Integer getIntersectionOfLL(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2){
        if(head1 == null || head2 == null){
            return -1;
        }
        LinkedListNode<Integer> temp1=head1,temp2=head2;
        int length1=0,length2=0;
        while (temp1 !=null){
            length1++;
            temp1=temp1.next;
        }
        while (temp2 !=null){
            length2++;
            temp2=temp2.next;
        }
        int diff = length1 - length2;
        //resetting
        temp1=head1;
        temp2=head2;
        while(diff > 0){
            temp1=temp1.next;
            diff--;
        }
        while(diff < 0){
            temp2=temp2.next;
            diff++;
        }
        while(temp1 !=null && temp2!=null){
            if(temp1.data.equals(temp2.data)){
                return temp1.data;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return -1;

    }



    public static LinkedListNode<Integer> getIntersectionOfLLUsingHashing(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Set<Integer> set=new HashSet<>();
        LinkedListNode<Integer> temp=new LinkedListNode<>();
        LinkedListNode<Integer> result=temp;

        while (head1 !=null){
            set.add(head1.data);
            head1=head1.next;
        }
        while(head2 !=null){
            if(set.contains(head2.data)){
                temp.next=head2;
                temp=temp.next;
            }
            head2=head2.next;
        }
        temp.next=null;
        return result.next;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(24);
        head.next.next = new LinkedListNode<>(34);
        head.next.next.next = new LinkedListNode<>(9);
        head.next.next.next.next = new LinkedListNode<>(8);
        head.next.next.next.next.next = new LinkedListNode<>(37);
        head.next.next.next.next.next.next = new LinkedListNode<>(5);

        printLinkedList(head);
        System.out.println();

        LinkedListNode<Integer> head1 = new LinkedListNode<>(12);
        head1.next = new LinkedListNode<>(99);
        head1.next.next = new LinkedListNode<>(8);
        head1.next.next.next = new LinkedListNode<>(37);
        head1.next.next.next.next = new LinkedListNode<>(5);

        printLinkedList(head1);
        System.out.println();

        System.out.println("Intersection point : " + getIntersectionOfLL(head,head1));
        System.out.println();
        printLinkedList(getIntersectionOfLLUsingHashing(head,head1));

    }
}
