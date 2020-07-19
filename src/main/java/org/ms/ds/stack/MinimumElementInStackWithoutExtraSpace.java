package org.ms.ds.stack;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
implement a function to find minimum element in stack with push and pop support

 */
public class MinimumElementInStackWithoutExtraSpace {

    public static void main(String[] args) {
        MinStackWithoutExtraSpace minStack = new MinStackWithoutExtraSpace();
        minStack.push(10);
        minStack.push(8);
        minStack.push(18);
        minStack.push(11);
        minStack.push(22);
        minStack.push(2);
        minStack.push(-1);
        System.out.println("Min => " + minStack.getMin());
        minStack.pop();
        System.out.println("Min => " + minStack.getMin());
        minStack.pop();
        System.out.println("Min => " + minStack.getMin());
    }

}

class MinStackWithoutExtraSpace {
    Stack<Integer> stack = new Stack();
    int min = -1;

    //while popping we will check with popped element is lower than min means its not actual value but a flag so we will return
    int pop() {
        if (stack.size() == 0) {
            return -1;
        }else{
            if(stack.peek() >= min) {
                return stack.pop();
            }else if(stack.peek()< min){
                int temp=min;
                min=2*min-stack.pop();
                return temp;
            }else {
                return -1;
            }
        }
    }

    int top(){
        if (stack.size() == 0) {
            return -1;
        }else{
            if(stack.peek() >= min) {
                return stack.peek();
            }else if(stack.peek()< min){
                return min;
            }else {
                return -1;
            }
        }
    }

    void push(int ele) {
        if (stack.size() == 0) {
            stack.push(ele);
            min = ele;
        } else {
            if (ele >= min) {
                stack.push(ele);
            } else if (ele < min) {
                stack.push(2*ele-min);
                min=ele;
            }
        }

    }

    int getMin() {
        if (stack.size() == 0) {
            return -1;
        } else {
            return min;
        }
    }

}
