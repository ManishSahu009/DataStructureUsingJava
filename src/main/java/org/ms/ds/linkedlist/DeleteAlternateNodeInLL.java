package org.ms.ds.linkedlist;

public class DeleteAlternateNodeInLL {

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

    public static LinkedListNode<Integer> deleteAlternateNode(LinkedListNode<Integer> head){
        return null;
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


    }


}
