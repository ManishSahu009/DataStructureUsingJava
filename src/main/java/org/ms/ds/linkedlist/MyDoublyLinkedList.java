package org.ms.ds.linkedlist;

public class MyDoublyLinkedList {

    DoublyLinkedListNode<Integer> head=null;

    public void insertAtStart(Integer key){
        DoublyLinkedListNode<Integer> newNode=new DoublyLinkedListNode<>(key);
        if(head == null){
            head=newNode;
            return;
        }
        newNode.next = head;
        head.prev=newNode;
        head = newNode;

    }

    public void insertAtEnd(int key){
        DoublyLinkedListNode<Integer> newNode=new DoublyLinkedListNode<>(key);
        if(head == null){
            head=newNode;
            return;
        }
        DoublyLinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev=temp;

    }

    public void insertAtGivenPosition(int key, int pos){
        DoublyLinkedListNode<Integer> newNode=new DoublyLinkedListNode<>(key);
        if(head == null && pos == 1){
            head=newNode;
            return;
        }
        if((head == null && pos > 1) || (head != null  && pos > size())){
            System.out.println("Invalid position to insert node");
        }
        DoublyLinkedListNode<Integer> temp = head;
        int cout=1;
        while (cout< pos-1) {
            cout++;
            temp = temp.next;
        }
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next.prev=newNode;
        temp.next=newNode;

    }

    public DoublyLinkedListNode<Integer> deleteFirst(){
        if(head == null){
            System.out.println("List is null");
            return null;
        }
        DoublyLinkedListNode<Integer> temp=head;
        head=head.next;
        temp.next=null;
        head.prev=null;
        return temp;
    }

    public DoublyLinkedListNode<Integer> deleteLast(){
        DoublyLinkedListNode<Integer> temp=head,prev=head;
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
        temp.prev=null;
        return temp;
    }

    public DoublyLinkedListNode<Integer> deleteElementAtGivenPosition(int pos){
        if(head == null && pos == 1){
            return null;
        }
        if((head == null && pos > 1) || (head!=null  && pos > size())){
            System.out.println("Invalid position to delete node");
        }
        DoublyLinkedListNode<Integer> tempN = head,tempP=head;
        int cout=1;
        while (cout< pos) {
            cout++;
            tempP=tempN;
            tempN = tempN.next;
        }
        tempP.next=tempN.next;
        tempN.next.prev=tempP;
        tempN.prev=null;
        tempN.next=null;
        return tempN;

    }

    public int size(){
        int size=0;
        DoublyLinkedListNode<Integer> temp=head;
        while (temp !=null){
            size++;
            temp=temp.next;
        }
        return size;

    }

    public void printLinkedList(){
        DoublyLinkedListNode<Integer> tempN=head;
        DoublyLinkedListNode<Integer> tempP=tempN;
        if(head == null){
            System.out.println("Nothing to print");
            return;
        }
        while(tempN!=null){
            System.out.print("-->" + tempN.data);
            tempP=tempN;
            tempN=tempN.next;
        }
        System.out.println();
        while (tempP!=null){
            System.out.print(tempP.data+"<--");
            tempP=tempP.prev;
        }
    }
}



class MyDoublyLinkedListClient {

    public static void main(String[] args) {
        MyDoublyLinkedList mll = new MyDoublyLinkedList();
        mll.insertAtStart(9);
        mll.insertAtStart(8);
        mll.insertAtEnd(11);
        mll.insertAtGivenPosition(10,3);
        mll.deleteElementAtGivenPosition(3);
        mll.printLinkedList();
    }
}
