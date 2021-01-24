package org.ms.ds.recursion;

/*
odd no. of elements m=n/2
even number of elements m=n/2+1 =
 */

import java.util.Stack;

public class DeleteMiddleElementStack {

    private static void deleteMiddleEle(Stack<Integer> eles,Integer k) {
        if(k==1){
            eles.pop();
            return;
        }
        Integer temp=eles.pop();
        deleteMiddleEle(eles,k-1);
        eles.push(temp);
    }

    private static void deleteMiddleEle(Stack<Integer> eles) {
       Integer k = (int) Math.ceil(eles.size()/2);
       deleteMiddleEle(eles,k);
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
        deleteMiddleEle(eles);
        eles.forEach(e -> System.out.println(e + " "));
    }


}

