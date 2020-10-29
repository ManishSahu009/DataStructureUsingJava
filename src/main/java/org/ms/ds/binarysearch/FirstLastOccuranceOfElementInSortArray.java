package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5
 */

public class FirstLastOccuranceOfElementInSortArray {


    private static int findFirstOccurance(int[] arr, int ele) {
        int start=0;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){
            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            if(ele ==arr[mid]){
                result=mid;
                end=mid-1;
            }else if(ele < arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return result;
    }

    private static int findLastOccurance(int[] arr, int ele) {
        int start=0;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){
            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            if(ele ==arr[mid]){
                result=mid;
                start=mid+1;
            }else if(ele < arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr={2,4,10,10,10,18,20};
        System.out.println(findFirstOccurance(arr,10) +" and "+findLastOccurance(arr,10));
    }

}
