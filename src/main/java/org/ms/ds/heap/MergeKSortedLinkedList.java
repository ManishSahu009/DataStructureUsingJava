package org.ms.ds.heap;

import org.ms.ds.linkedlist.LinkedListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static void printList(LinkedListNode<Integer> node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }

    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] list, int k)
    {
        // create an empty min-heap using a comparison object for ordering the min-heap
        PriorityQueue<LinkedListNode<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> ((LinkedListNode<Integer>) a).data));
        //adding first node of each linked list
        queue.addAll(Arrays.asList(list).subList(0,k));
        LinkedListNode<Integer> head=null,last=null;
        while (!queue.isEmpty()){
            LinkedListNode<Integer> minNode=queue.poll();
            if(head == null){
                head=last=minNode;
            }else{
                last.next=minNode;
                last=minNode;
            }
            if(minNode.next !=null){
                queue.add(minNode.next);
            }


        }
        return head;
    }



    public static void main(String[] s) {
        int k = 3; // Number of linked lists

        // An array to store the head nodes of the linked lists
        LinkedListNode<Integer>[] list = new LinkedListNode[k];

        list[0] = new LinkedListNode<Integer>(1);
        list[0].next = new LinkedListNode<Integer>(5);
        list[0].next.next = new LinkedListNode<Integer>(7);

        list[1] = new LinkedListNode<Integer>(2);
        list[1].next = new LinkedListNode<Integer>(3);
        list[1].next.next = new LinkedListNode<Integer>(6);
        list[1].next.next.next = new LinkedListNode<Integer>(9);

        list[2] = new LinkedListNode<Integer>(4);
        list[2].next = new LinkedListNode<Integer>(8);
        list[2].next.next = new LinkedListNode<Integer>(10);

        // Merge all lists into one
        LinkedListNode<Integer> head = mergeKLists(list, k);
        printList(head);
    }
}
