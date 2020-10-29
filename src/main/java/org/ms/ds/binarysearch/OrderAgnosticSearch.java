package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=gY2b-Q6wDEM&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=4
order agnostic : order not known(Asc/Desc) of given array to search

 */

public class OrderAgnosticSearch {

    public static int findEleAsc(int []arr, int ele){
        int start=0;
        int end=arr.length-1;
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

    public static int findEleDesc(int []arr, int ele){
        int start=0;
        int end=arr.length-1;
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

    public static int findEle(int []arr, int ele){
        if(arr[0] < arr[arr.length-1]){
           return findEleAsc(arr,ele);
        }else{
            return findEleDesc(arr,ele);
        }
    }

    public static void main(String[] args) {
        int []arr={2,5,7,9,14,17,20};
        System.out.println(findEle(arr,17));

    }
}
