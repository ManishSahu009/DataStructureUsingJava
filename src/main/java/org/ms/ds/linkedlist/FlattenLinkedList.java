package org.ms.ds.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenLinkedList {

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        if (head == null) {
            System.out.println("Nothing to print");
            return;
        }
        while (temp != null) {
            System.out.print("-->" + temp.data);
            temp = temp.down;
        }
    }

    public static LinkedListNode<Integer> flattenUsingProirityQueue(LinkedListNode<Integer> head){
        LinkedListNode<Integer> ptr=head;
        LinkedListNode<Integer> newHead=null;
        PriorityQueue<PairFLL> queue=new PriorityQueue<>(new PairFLLComparator());
        while(ptr!=null){
            queue.add(new PairFLL(ptr,ptr.data));
            ptr=ptr.next;
        }
        while (!queue.isEmpty()){
            LinkedListNode<Integer> temp=queue.poll().root;
            if (temp.down !=null){
                queue.add(new PairFLL(temp.down,temp.down.data));
            }
            if(newHead == null){
                newHead=temp;
                ptr=temp;
            }else{
                ptr.down=temp;
                ptr=temp;
            }
        }
        return newHead;
    }

    private static LinkedListNode<Integer>  mergeTwoSortedLinkedList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
       if(head1 == null){
           return head2;
       }
        if(head2 == null){
            return head1;
        }
        LinkedListNode<Integer> result=null;
        if(head1.data < head2.data){
            result=head1;
            result.down=mergeTwoSortedLinkedList(head1.down,head2);
        }else{
            result=head2;
            result.down=mergeTwoSortedLinkedList(head1,head2.down);
        }
        return result;
    }

    public static LinkedListNode<Integer> flatten(LinkedListNode<Integer> head){
        if(head == null || head.next==null){
            return head;
        }
        head.next=flatten(head.next);
        head=mergeTwoSortedLinkedList(head,head.next);
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> one = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> two = new LinkedListNode<Integer>(2);
        LinkedListNode<Integer> three = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> four = new LinkedListNode<Integer>(4);
        LinkedListNode<Integer> five = new LinkedListNode<Integer>(5);
        LinkedListNode<Integer> six = new LinkedListNode<Integer>(6);
        LinkedListNode<Integer> seven = new LinkedListNode<Integer>(7);
        LinkedListNode<Integer> eight = new LinkedListNode<Integer>(8);
        LinkedListNode<Integer> nine = new LinkedListNode<Integer>(9);
        LinkedListNode<Integer> ten = new LinkedListNode<Integer>(10);
        LinkedListNode<Integer> eleven = new LinkedListNode<Integer>(11);
        LinkedListNode<Integer> twelve = new LinkedListNode<Integer>(12);


        // set next pointers
        one.next = two;
        two.next = five;
        five.next = ten;


        // set down pointers
        one.down = four;
        four.down = six;
        six.down = eight;
        two.down = three;
        three.down = seven;
        five.down = nine;
        ten.down = eleven;
        eleven.down=twelve;

        // set head node
        LinkedListNode<Integer> head = one;


        LinkedListNode<Integer > newHead=flattenUsingProirityQueue(head);
        printLinkedList(newHead);

        System.out.println();

        //LinkedListNode<Integer > newHead1=flatten(head);
        //printLinkedList(newHead1);

    }
}

class PairFLL {
    int value;
    LinkedListNode<Integer> root;

    public PairFLL(LinkedListNode<Integer> root,int value) {
        this.value = value;
        this.root = root;
    }
}

class PairFLLComparator implements Comparator<PairFLL>
{

    @Override
    public int compare(PairFLL o1, PairFLL o2) {
        return o1.value - o2.value;
    }
}
