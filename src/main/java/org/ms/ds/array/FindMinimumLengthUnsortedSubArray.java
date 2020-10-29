package org.ms.ds.array;

/*
https://www.youtube.com/watch?v=89tB1oillAc

 */

import java.util.Arrays;
import java.util.Stack;

public class FindMinimumLengthUnsortedSubArray {


    public static int findUnsortedSubarray(int []arr){
        int []copy=arr.clone();
        Arrays.sort(copy);

        int min=arr.length;
        int max=0;

        for(int i=0 ; i<copy.length;i++){
           if(arr[i] != copy[i]){
               min=Math.min(i,min);
               max=Math.max(i,max);
           }
        }
      return max-min+1;
    }

    public static int findUnsortedSubarrayUsingStack(int []arr){
        Stack<Integer> stack=new Stack<>();
        int min=arr.length;
        int max=0;

        //find start index
        for(int i=0;i<arr.length ;i++){
            while (!stack.empty() && arr[i] < arr[stack.peek()]){
                min=Math.min(min , stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        //find end index
        for(int i=arr.length-1 ;i>=0 ;i--){
            while (!stack.empty() && arr[i] > arr[stack.peek()]){
                max=Math.max(max , stack.pop());
            }
            stack.push(i);
        }

        return max-min+1;
    }

    public static void main(String[] args) {
        int arr[]={1,5,3,8,10,9,13};
        System.out.println("findUnsortedSubarray " + findUnsortedSubarray(arr));
        System.out.println("findUnsortedSubarrayUsingStack " + findUnsortedSubarrayUsingStack(arr));

    }
}
