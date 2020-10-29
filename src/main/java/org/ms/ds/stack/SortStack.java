package org.ms.ds.stack;

/*
Algorithm: using stack


 */

import java.util.List;
import java.util.Stack;

public class SortStack {

    private static Stack<Integer> sortstack(Stack<Integer> input) {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!input.isEmpty()){
            int temp=input.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }

    public static void main(String args[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack=sortstack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        }
    }



}
