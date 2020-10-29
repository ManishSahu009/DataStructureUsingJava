package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10
ceil of s => smallest element greater than s
we need to keep maintain all mid which are greater than element
 */

public class FindCeilOfElementInSortedArray {

   private static int findCeilOfElementInSortedArray(int[] arr, int ele) {
       int result=Integer.MIN_VALUE;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(ele ==arr[mid] ){
                result= mid;
                break;
            }else if(ele < arr[mid]){
                result=mid;
                end=mid-1;
            }else if(ele > arr[mid]){
                start=mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int []arr={1,2,3,4,8,10,12,19};
        System.out.println("index "+ findCeilOfElementInSortedArray(arr , 5));
    }


}
