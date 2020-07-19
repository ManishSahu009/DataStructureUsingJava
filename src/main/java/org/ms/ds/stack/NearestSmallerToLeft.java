package org.ms.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Identify : if we have nested loop and i depends on j then think of stack
Example : input array [1,3,2,4] => output [-1,1,1,2]
Algorithm: using stack
1. take one temporary list and stack
2. traverse given stack from start of list
3(a). if stack is empty push add -1 in list
3(b). if stack is not empty
           if stack top element is lesser than source list element
                copy stack top in temp list
           else
                keep popping element from stack until find lesser and add in temp list and if not found then add -1 in temp list
4. push new element in stack
5. return temp list
 */
public class NearestSmallerToLeft {

    List<Integer> getNSL(List<Integer> eles){
        List<Integer> temp=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int item=0;item< eles.size();item++){
            if(stack.empty()){
                temp.add(-1);
            }else if(stack.size() > 0 && stack.peek() < eles.get(item)){
                temp.add(stack.peek());
            }else if(stack.size() > 0 && stack.peek() >= eles.get(item)){
                while(stack.size() > 0 && stack.peek() >= eles.get(item)){
                    stack.pop();
                }
                if(stack.size() ==0){
                    temp.add(-1);
                }else{
                    temp.add(stack.peek());
                }
            }
            stack.push(eles.get(item));
        }
        return temp;

    }

    public static void main(String[] args) {
        NearestSmallerToLeft nearestSmallerToLeft=new NearestSmallerToLeft();
        List<Integer> sl=new ArrayList<>();
        sl.add(1);
        sl.add(3);
        sl.add(2);
        sl.add(4);
        System.out.println(nearestSmallerToLeft.getNSL(sl));
    }
}

