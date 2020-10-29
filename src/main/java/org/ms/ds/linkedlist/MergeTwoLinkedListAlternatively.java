package org.ms.ds.linkedlist;

public class MergeTwoLinkedListAlternatively {

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

    public static LinkedListNode<Integer> mergeTwoListAlternatively(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2){
        LinkedListNode<Integer> newList=new LinkedListNode<>();
        LinkedListNode<Integer> result=newList;
        while(head1!=null && head2!=null){
            newList.next=head1;
            newList=newList.next;
            head1=head1.next;

            newList.next=head2;
            newList=newList.next;
            head2=head2.next;
        }
        if(head1!=null){
            newList.next=head1;
        }
        if (head2!=null){
            newList.next=head2;
        }
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
        head1.next.next = new LinkedListNode<>(4);
        head1.next.next.next = new LinkedListNode<>(31);
        head1.next.next.next.next = new LinkedListNode<>(89);

        printLinkedList(head1);
        System.out.println();

        LinkedListNode<Integer> newList=mergeTwoListAlternatively(head,head1);
        printLinkedList(newList);

    }
}
