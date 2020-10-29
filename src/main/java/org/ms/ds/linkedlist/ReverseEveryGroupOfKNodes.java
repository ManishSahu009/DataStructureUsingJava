package org.ms.ds.linkedlist;
/*
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/#:~:text=Firstly%2C%20push%20the%20k%20elements,process%2C%20until%20NULL%20is%20reached.
 */

import java.util.Stack;

public class ReverseEveryGroupOfKNodes {



    public static LinkedListNode<Integer> reverseInKGroup(LinkedListNode<Integer> head,int k){
        LinkedListNode<Integer> prevNode=null;
        LinkedListNode<Integer> currentNode=head;
        LinkedListNode<Integer> nextNode=head;
        int count=0;

        while (nextNode!=null && count < k){
            nextNode=nextNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
            count++;
        }
        if(nextNode!=null){
            head.next=reverseInKGroup(nextNode,k);
        }
        return prevNode;
    }

    public static LinkedListNode<Integer> reverseInKGroupUsingStack(LinkedListNode<Integer> head,int k){
        Stack<LinkedListNode<Integer>> stack = new Stack<>();
        LinkedListNode<Integer> current=head;
        LinkedListNode<Integer> prev=null;

        while(current!=null) {
            int count=0;
            while (current != null && count < k) {
                stack.push(current);
                current = current.next;
                count++;
            }
            while(!stack.empty()){
                if(prev == null){
                    prev=stack.peek();
                    head=prev;
                    stack.pop();
                }else{
                    prev.next=stack.peek();
                    prev=prev.next;
                    stack.pop();
                }
            }
        }
        prev.next=null;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtEnd(11);
        mll.insertAtEnd(18);
        mll.insertAtEnd(22);
        mll.insertAtEnd(45);
        mll.insertAtEnd(97);
        mll.insertAtEnd(102);
        mll.insertAtEnd(203);
        mll.insertAtEnd(240);

        mll.printLinkedList();
        mll.head=reverseInKGroup(mll.head,3);
        System.out.println();
        mll.printLinkedList();
        mll.head=reverseInKGroupUsingStack(mll.head,3);
        System.out.println();
        mll.printLinkedList();

    }

}
