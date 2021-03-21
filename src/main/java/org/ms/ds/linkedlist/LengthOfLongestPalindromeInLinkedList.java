package org.ms.ds.linkedlist;

/*
https://www.geeksforgeeks.org/length-longest-palindrome-list-linked-list-using-o1-extra-space/

 */

public class LengthOfLongestPalindromeInLinkedList {

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

    private static int countCommon(LinkedListNode<Integer> root1,LinkedListNode<Integer> root2){
        int count=0;
        while (root1!=null && root2!=null){
            if(root1.data == root2.data){
                ++count;
            }else{
                break;
            }
            root1=root1.next;
            root2=root2.next;
        }
        return count;
    }

    private static int findLongestPalindromeLength(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current=head,prev=null;
        int result=0;
        while (current !=null){
            LinkedListNode<Integer> next;

            next = current.next;
            current.next = prev;
            result = Math.max(result,2*countCommon(prev,next)+1);

            result = Math.max(result,2*countCommon(current,next));
            prev = current;
            current = next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(2);
        head.next = new LinkedListNode<Integer>(4);
        head.next.next = new LinkedListNode<Integer>(3);
        head.next.next.next = new LinkedListNode<Integer>(4);
        head.next.next.next.next = new LinkedListNode<Integer>(2);
        head.next.next.next.next.next = new LinkedListNode<Integer>(5);


        printLinkedList(head);
        System.out.println("LengthOfLongestPalindromeInLinkedList" + findLongestPalindromeLength(head));


    }



}
