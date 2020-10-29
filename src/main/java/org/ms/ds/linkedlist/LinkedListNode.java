package org.ms.ds.linkedlist;

import lombok.Data;

@Data
public class LinkedListNode<T> {

    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode<T> random;
    public LinkedListNode<T> down;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode() {
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

}
