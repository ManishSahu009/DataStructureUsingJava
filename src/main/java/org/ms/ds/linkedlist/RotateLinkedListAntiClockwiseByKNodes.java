package org.ms.ds.linkedlist;

public class RotateLinkedListAntiClockwiseByKNodes {

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

    public static int getSize(LinkedListNode<Integer> head){
        if(head == null){
            return 0;
        }
        return getSize(head.next) + 1;
    }

    private static LinkedListNode<Integer> rotateAntiClockwseByK(LinkedListNode<Integer> head,int k) {
        LinkedListNode<Integer> temp1=head;
        if(head == null || k < 0){
            return head;
        }
        int size=getSize(temp1);
        k=k % size;
        if(k == 0){
            return head;
        }
        int i=1;
        while(i < k){
            temp1=temp1.next;
            i++;
        }
        LinkedListNode<Integer> temp2=temp1.next;
        LinkedListNode<Integer> newHead=temp2;
        temp1.next=null;

        while (temp2.next!=null){
            temp2=temp2.next;
        }
        temp2.next=head;

        return newHead;

    }

    public static void main(String[] args)
    {

        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        MyLinkedList mll = new MyLinkedList();
        for (int i = keys.length - 1; i >= 0; i--) {
            mll.insertAtStart(keys[i]);
        }
        int k=3;
        printLinkedList(mll.head);
        LinkedListNode<Integer> head = rotateAntiClockwseByK(mll.head,k);
        System.out.println();
        printLinkedList(head);
    }

}
