package org.ms.ds.stack;

import java.util.Stack;

public class MyStack {
    int items[]=new int[100];
    int top=-1;

    int pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return items[top--];
        }
    }

    void push(int ele){
        if(top==items.length)
        {
            System.out.println("Stack is full");
        }else{
            items[++top]=ele;
        }
    }

    int peek(){
        return items[top];
    }

    boolean isEmpty(){
        return  top==-1 ? true:false;
    }

    void print(){
     for(int i=0; i<=top;i++){
         System.out.println(items[i]);
     }
    }
}

class MyStackTest{
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(33);
        myStack.push(90);
        myStack.print();

    }
}
