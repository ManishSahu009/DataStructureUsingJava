package org.ms.ds.array;
/*
https://www.youtube.com/watch?v=LuLCLgMElus
or next greater element

logic :
find 1st index (called idx1) where a[i] < a[i+1] from last
find idx2 where a[idx1] < a[idx2] just next greater element
reverse from idx1 to idx2
 */

import java.util.Arrays;

public class NextPermutaion {

    public static void findNextPermutation(int []arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int i=arr.length-2;
        //find first index
        while(i >=0 && arr[i] >= arr[i+1]){
            i--;
        }
        //find second index
        if(i >= 0){
            int j=arr.length-1;
            while(arr[i] >= arr[j] ){
                j--;
            }
            swap(arr,i,j);
        }
        //reverse the array after finding first element
        reverse(arr, i+1, arr.length-1);
    }
    private static void swap(int []arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void reverse (int []arr, int i, int j)
    {
        while(i<j){
            swap(arr,i++,j--);
        }
    }
    public static void main(String[] args) {
      int ele=158476531;
        int[] arr = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
        findNextPermutation(arr);
        Arrays.asList(ele).forEach(System.out::println);
    }
}
