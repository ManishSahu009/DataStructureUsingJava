package org.ms.ds.linkedlist;

public class SortLinkedList {

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode<Integer> middleNode=middleNode(head);
        LinkedListNode<Integer> secondHalf = middleNode.next;
        middleNode.next=null;
        return mergeTwoSortedLinkedList(mergeSort(head),mergeSort(secondHalf));
    }

    public static LinkedListNode<Integer> middleNode(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slowPointer=head, fastPointer= head.next;
        while (fastPointer != null && fastPointer.next !=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    private static LinkedListNode<Integer>  mergeTwoSortedLinkedList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> head3=new LinkedListNode<>();
        LinkedListNode<Integer> temp=head3;


        while(head1!=null && head2!=null){
            if(head1.data < head2.data){
                temp.next=head1;
                head1=head1.next;
            }else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        temp.next=(head1==null)?head2:head1;
        return head3.next;
    }

    public static void main(String[] args) {
        MyLinkedList mll1 = new MyLinkedList();
        mll1.insertAtEnd(22);
        mll1.insertAtEnd(11);
        mll1.insertAtEnd(18);
        mll1.insertAtEnd(45);
        mll1.insertAtEnd(203);
        mll1.insertAtEnd(97);
        mll1.insertAtEnd(102);
        mll1.insertAtEnd(240);



        MyLinkedList mll3= new MyLinkedList();
        mll3.head=mergeSort(mll1.head);
        mll3.printLinkedList();

    }

}
