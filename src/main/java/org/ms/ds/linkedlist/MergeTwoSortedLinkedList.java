package org.ms.ds.linkedlist;

public class MergeTwoSortedLinkedList {


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
        mll1.insertAtEnd(11);
        mll1.insertAtEnd(18);
        mll1.insertAtEnd(22);
        mll1.insertAtEnd(45);
        mll1.insertAtEnd(97);
        mll1.insertAtEnd(102);
        mll1.insertAtEnd(203);
        mll1.insertAtEnd(240);

        MyLinkedList mll2 = new MyLinkedList();
        mll2.insertAtEnd(6);
        mll2.insertAtEnd(55);
        mll2.insertAtEnd(63);
        mll2.insertAtEnd(81);
        mll2.insertAtEnd(97);
        mll2.insertAtEnd(101);
        mll2.insertAtEnd(220);
        mll2.insertAtEnd(241);

        MyLinkedList mll3= new MyLinkedList();
        mll3.head=mergeTwoSortedLinkedList(mll1.head,mll2.head);
        mll3.printLinkedList();

    }

}
