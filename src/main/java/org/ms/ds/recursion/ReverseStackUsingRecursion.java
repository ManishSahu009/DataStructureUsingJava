package org.ms.ds.recursion;

import java.util.Stack;

//Without extra space
public class ReverseStackUsingRecursion {

    public static void reverse(Stack<Integer> temp ){
        if(temp.size()==1) {

            return;
        }
        int tempVar=temp.pop();
        reverse(temp);
        insert(temp,tempVar);
    }

    static void insert(Stack<Integer> temp,Integer tempvar){
        if(temp.empty()){
            temp.push(tempvar);
            return;
        }
        int tempVar1= temp.pop();
        insert(temp,tempvar);
        temp.push(tempVar1);
    }

    public static void main(String[] args) {
        Stack<Integer> eles = new Stack<>();
        eles.push(33);
        eles.push(3);
        eles.push(10);
        eles.push(30);
        eles.push(15);
        eles.push(9);
        eles.push(34);
        eles.push(42);
        reverse(eles);
        eles.forEach(e -> System.out.println(e + " "));
    }

}
