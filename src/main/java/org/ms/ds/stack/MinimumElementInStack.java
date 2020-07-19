package org.ms.ds.stack;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
implement a function to find minimum element in stack with push and pop support
1. maintain a supporting array
2. push both array if empty
3. push in main stack and check if element is lower than supporting stack top if yes push in supporting stack also
4. pop from both stack if popped element is equal to supporting top element
5. get min by peeking supporting top
 */
public class MinimumElementInStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(8);
        minStack.push(18);
        minStack.push(11);
        minStack.push(22);
        minStack.push(2);
        System.out.println("Min => "+minStack.getMin());
        minStack.pop();
        System.out.println("Min => "+minStack.getMin());
    }

}

class MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> supportingStack = new Stack();

    int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        int a = stack.pop();
        if (a == supportingStack.peek()) {
            supportingStack.pop();
        }
        return a;
    }

    void push(int ele) {
        stack.push(ele);
        if (supportingStack.size() == 0 || supportingStack.peek() >= ele) {
            supportingStack.push(ele);
        }
    }

    int getMin() {
      if(supportingStack.size()==0){
          return -1;
      }else{
          return supportingStack.peek();
      }
    }

}
