package org.ms.ds.array;

import java.util.Arrays;

/*
https://www.youtube.com/watch?v=vB-81TB6GUc
 */
public class MultiplyAllExceptCurrent {

    public static void findProduct(int[] str){
        int[] productArray=new int[str.length];
        int left=1;
        for(int i=0 ; i < str.length ; i++){
            productArray[i]=left;
            left=left*str[i];
        }
        int right=1;
        for(int i=str.length-1 ; i >= 0 ; i--){
            productArray[i] = right*productArray[i];
            right=right*str[i];
        }
        System.out.println(Arrays.toString(productArray));

    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 2, 6, 8 };
        findProduct(arr);

    }
}
