package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
Bitonic Array : (will have only single peak element)
monotonically increasing and then monotonically decreasing
ex : {1,3,8,12,4,2}
logic :
1.find the pak element
2. devide into 2 array based on peak element
2. do apply binary search on both one on asc and one on desc order
 */

public class SearchElementInBitonicArray {

    private static int findPeakelementIndex(int[] arr) {
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

    public static int findEleAsc(int []arr, int ele,int start, int end){
        while(start<=end){
            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            if(ele ==arr[mid]){
                return mid;
            }else if(ele < arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static int findEleDesc(int []arr, int ele,int start, int end){
        while(start<=end){
            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            if(ele ==arr[mid]){
                return mid;
            }else if(ele > arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }


    private static int searchElementInBitonicArray(int[] arr,int key) {
        int peakElementIndex=findPeakelementIndex(arr);
        int keyIndex=findEleAsc(arr,key,0,peakElementIndex-1);
        if(keyIndex != -1){
           return keyIndex;
        }
        keyIndex=findEleDesc(arr,key,peakElementIndex,arr.length-1);
        if(keyIndex != -1){
            return keyIndex;
        }
        return -1;


    }

    public static void main(String[] args) {
        int []arr={1,3,8,12,4,2};
        System.out.println("PeakElement " + searchElementInBitonicArray(arr,4));
    }


}
