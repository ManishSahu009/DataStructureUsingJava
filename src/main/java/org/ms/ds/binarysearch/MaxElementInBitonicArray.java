package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
Bitonic Array : (will have only single peak element)
monotonically increasing and then monotonically decreasing
ex : {1,3,8,12,4,2}
its nothing but peak element only. so no code chnage
 */

public class MaxElementInBitonicArray {

    private static int maxElementInBitonicArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(mid > 0 && mid < arr.length-1) {
                if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                    return mid;
                }else if(arr[mid-1] > arr[mid]){
                    end =mid-1;
                }else{
                    start=start+1;
                }
            }else if(mid==0){
                if(arr[0]>arr[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else if(mid==arr.length-1){
                if(arr[arr.length-1]>arr[arr.length-2]){
                    return arr.length-1;
                }else{
                    return arr.length-2;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int []arr={1,3,8,12,4,2};
        System.out.println("PeakElement " + maxElementInBitonicArray(arr));
    }
}
