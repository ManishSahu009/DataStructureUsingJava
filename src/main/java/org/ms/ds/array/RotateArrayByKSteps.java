package org.ms.ds.array;

import java.util.Arrays;

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

    public static void leftRotate(int[] arr, int r)
    {
        reverse(arr, 0, r - 1);
        reverse(arr, r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void rightRotate(int[] A, int k, int n)
    {
        reverse(A, n - k, n - 1);
        reverse(A, 0, n - k - 1);
        reverse(A, 0, n - 1);
    }


    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(A));
        rightRotate(A, k, A.length);
        System.out.println("rightRotate: "+Arrays.toString(A));
        leftRotate(A,k);
        System.out.println("leftRotate: "+Arrays.toString(A));
    }

}
