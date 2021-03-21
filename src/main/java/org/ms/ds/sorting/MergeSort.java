package org.ms.ds.sorting;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int []left, int []right){
        int []arr =new int[left.length + right.length];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
            while(i < left.length){
                arr[k]=left[i];
                i++;
                k++;
            }
            while(j < right.length){
                arr[k]=right[j];
                j++;
                k++;
        }
        return arr;
    }

    private static int[] mergeSort(int []arr, int low, int high){
        if(low == high){
            int []ba = new int[1];
            ba[0]=arr[low]; //or  ba[0]=arr[high];
            return ba;
        }
        int mid=(low+high)/2;
        int []left= mergeSort(arr,low,mid);
        int []right= mergeSort(arr, mid+1,high);
        int []ans = merge(left,right);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={12,5,22,9,55,80,21,63,9,10};
        int []ans=mergeSort(arr,0,arr.length-1);
        Arrays.stream(ans).forEach(System.out::println);

    }
}
