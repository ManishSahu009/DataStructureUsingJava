package org.ms.ds.linkedlist;

public class SortLinkedListWithOnly_0_1_2 {

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

    public static LinkedListNode<Integer>  sortList(LinkedListNode<Integer>  head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer>  first = new LinkedListNode<>(), second = new LinkedListNode<>(), third = new LinkedListNode<>();
        LinkedListNode<Integer>  zero = first, one = second, two = third;
        LinkedListNode<Integer>  curr = head;
        while (curr != null)
        {
            if (curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else
            {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (second.next != null)? (second.next): (third.next);
        one.next = third.next;
        two.next = null;
        return first.next;
    }


    public static void main(String[] args)
    {

        int[] keys = { 1, 2, 0, 0, 1, 2, 1, 2, 1 };
        MyLinkedList mll = new MyLinkedList();
        for (int i = keys.length - 1; i >= 0; i--) {
            mll.insertAtEnd(keys[i]);
        }

        LinkedListNode<Integer> head = sortList(mll.head);
        printLinkedList(head);
    }
}
