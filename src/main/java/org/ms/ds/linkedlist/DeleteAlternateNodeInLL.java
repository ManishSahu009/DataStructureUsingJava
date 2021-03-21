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

    public static LinkedListNode<Integer> deleteAlternateNode(LinkedListNode<Integer> node){
        if(node == null || node.next == null) {
            return node;
        }

        LinkedListNode<Integer> head = node;

        while(node != null && node.next != null) {
            node.next = node.next.next;
            node = node.next;
        }

        return head;
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
        deleteAlternateNode(head);
        printLinkedList(head);
        System.out.println();


    }


}
