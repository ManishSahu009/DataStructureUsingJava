package org.ms.ds.array;

import java.util.Arrays;
//Leetcode:189 :  Rotate Array
/*  assume +ve k indicate right rotation
    and -ve k indicate left rotation
    note : if left rotation is required thn
    left rotation+length = right rotation
    means is 10 size array is given and 2 step left rotation is asked thn k=-2
    you can make 8 step right rotation = -2+10 = 8

    step 1: reverse from 0 to length-k
    step 2: reverse length-k+1 to length
    step 3: reverse full array
* */
public class RotateArrayByKSteps {

    public static void swap(int[] arr, int i, int j)
    {
        int data = arr[i];
        arr[i] = arr[j];
        arr[j] = data;
    }

    public static void reverse(int[] arr, int low, int high)
    {
        for (int i = low, j = high; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    public static void rotate(int[] arr, int k)
    {
        k=k%arr.length;
        if(k<0){
            k=k+arr.length;
        }
        //reverse first part
        reverse(arr, 0, arr.length-k-1);
        //reverse second part
        reverse(arr, arr.length-k,arr.length - 1);
        //reverse full array
        reverse(arr, 0, arr.length - 1);
    }


    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(A));
        rotate(A, k);
        System.out.println("rightRotate: "+Arrays.toString(A));
        rotate(A,-k); // negative
        System.out.println("leftRotate: "+Arrays.toString(A));
    }

}
