package org.ms.ds.linkedlist;

public class SeparateEvenOddNodes {

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

    private static LinkedListNode<Integer> rearrangeEvenOdd(LinkedListNode<Integer> head) {
        if(head == null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> evenStartingNode=null,oddStartingNode=null,evenEndNode=null,oddEndNode=null;
        while(head !=null){
            if(head.data%2 == 0){
                if(evenStartingNode == null){
                    evenStartingNode=head;
                    evenEndNode=evenStartingNode;
                }else{
                    evenEndNode.next=head;
                    evenEndNode=evenEndNode.next;
                }
            }else{
                if(oddStartingNode == null){
                    oddStartingNode=head;
                    oddEndNode=oddStartingNode;
                }else{
                    oddEndNode.next=head;
                    oddEndNode=oddEndNode.next;
                }
            }
            head=head.next;
        }
        evenEndNode.next=oddStartingNode;
        oddEndNode.next=null;
        return evenStartingNode;

    }

    public static void main(String[] args)
    {

        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        MyLinkedList mll = new MyLinkedList();
        for (int i = keys.length - 1; i >= 0; i--) {
            mll.insertAtStart(keys[i]);
        }
        printLinkedList(mll.head);
        LinkedListNode<Integer> head = rearrangeEvenOdd(mll.head);
        System.out.println();
        printLinkedList(head);
    }


}
