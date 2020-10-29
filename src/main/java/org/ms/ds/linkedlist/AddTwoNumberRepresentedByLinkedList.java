package org.ms.ds.linkedlist;

public class AddTwoNumberRepresentedByLinkedList {

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

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> node) {
        if(node == null || node.next == null) {
            return node;
        }
        LinkedListNode<Integer> temp = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return temp;
    }

    private static LinkedListNode<Integer> addLinkList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        head1=reverse(head1);
        head2=reverse(head2);
        LinkedListNode<Integer> newHead=null, previous=null;
        LinkedListNode<Integer> temp=null;
        int sum=0,carry=0;
        while(head1 !=null || head2!=null){
            sum=carry + ( head1!=null ? head1.data : 0) + ( head2!=null ? head2.data : 0);
            carry=(sum > 10) ? 1:0;
            sum=sum%10;
            temp=new LinkedListNode<>(sum);
            if(newHead==null){
                newHead=temp;
            }else{
                previous.next=temp;
            }
            previous=temp;
            if(head1!=null){
                head1=head1.next;
            }
            if(head2!=null){
                head2=head2.next;
            }
        }
        if(carry > 0){
            temp.next=new LinkedListNode<>(carry);
        }
        return reverse(newHead);
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(7);
        head.next.next = new LinkedListNode<>(8);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(5);

        printLinkedList(head);
        System.out.println();

        LinkedListNode<Integer> head1 = new LinkedListNode<>(5);
        head1.next = new LinkedListNode<>(6);
        head1.next.next = new LinkedListNode<>(7);


        printLinkedList(head1);
        System.out.println();

        LinkedListNode<Integer> newList=addLinkList(head,head1);
        printLinkedList(newList);
    }



}
