package org.ms.ds.linkedlist;

import lombok.Data;

import java.beans.ExceptionListener;

public class MyLinkedList {

    LinkedListNode<Integer> head=null;

    public void insertAtStart(Integer key){
        LinkedListNode<Integer> newNode=new LinkedListNode<>(key);
        if(head == null){
             head=newNode;
             return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void insertAtEnd(int key){
        LinkedListNode<Integer> newNode=new LinkedListNode<>(key);
        if(head == null){
            head=newNode;
            return;
        }
        LinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void insertAtGivenPosition(int key, int pos){
        LinkedListNode<Integer> newNode=new LinkedListNode<>(key);
        if(head == null && pos == 1){
            head=newNode;
            return;
        }
        if((head == null && pos > 1) || (head != null  && pos > size())){
            System.out.println("Invalid position to insert node");
        }
        LinkedListNode<Integer> temp = head;
        int cout=1;
        while (cout< pos-1) {
            cout++;
            temp = temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }

    public LinkedListNode<Integer> deleteFirst(){
        if(head == null){
            System.out.println("List is null");
            return null;
        }
        LinkedListNode<Integer> temp=head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    public LinkedListNode<Integer> deleteLast(){
        LinkedListNode<Integer> temp=head,prev=head;
        if(head ==null){
            System.out.println("List is null");
            return null;
        }
        if(head.next==null){
            head=null;
            return temp;
        }
         while (temp.next!=null){
             prev=temp;
             temp=temp.next;
         }
         prev.next=null;
         return temp;
    }

    public LinkedListNode<Integer> deleteElementAtGivenPosition(int pos){
        if(head == null && pos == 1){
            return null;
        }
        if((head == null && pos > 1) || (head!=null  && pos > size())){
            System.out.println("Invalid position to delete node");
        }
        LinkedListNode<Integer> temp = head,prev=head;
        int cout=1;
        while (cout< pos) {
            cout++;
            prev=temp;
            temp = temp.next;
        }
        prev.next=temp.next;
        temp.next=null;
        return temp;

    }

    public int size(){
        int size=0;
        LinkedListNode<Integer> temp=head;
        while (temp !=null){
            size++;
            temp=temp.next;
        }
        return size;

    }

    public void printLinkedList(){
        LinkedListNode<Integer> temp=head;
        if(head == null){
            System.out.println("Nothing to print");
            return;
        }
        while(temp!=null){
            System.out.print("-->" + temp.data);
            temp=temp.next;
        }
    }
}


class MyLinkedListClient {

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertAtStart(9);
        mll.insertAtStart(8);
        mll.insertAtEnd(11);
        mll.insertAtGivenPosition(10,3);
        mll.deleteElementAtGivenPosition(3);
        mll.printLinkedList();
    }
}


