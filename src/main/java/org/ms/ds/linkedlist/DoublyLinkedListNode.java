package org.ms.ds.linkedlist;

import lombok.Data;

@Data
public class DoublyLinkedListNode<T> {

    public T data;
    public DoublyLinkedListNode<T> next;
    public DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }
}
