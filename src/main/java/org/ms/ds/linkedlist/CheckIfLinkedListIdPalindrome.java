package org.ms.ds.linkedlist;

import java.util.Stack;

public class CheckIfLinkedListIdPalindrome {

    public static boolean isPalindrome(LinkedListNode<Integer> head){
        Stack<Integer> stack=new Stack<>();
        LinkedListNode<Integer> temp=head;
        while (temp != null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp !=null){
            int top=stack.pop();
            if(top !=temp.data){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next = new LinkedListNode<>(1);
        System.out.println("is palindrome : "+isPalindrome(head));

    }

}
