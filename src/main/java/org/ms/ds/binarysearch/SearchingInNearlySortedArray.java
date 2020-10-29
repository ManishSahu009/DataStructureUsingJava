package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
nearly sorted array means:
if element suppose to be on Ith position can also be on ont of the position (ith - 1 , ith , ith + 1)
so it will same as binary search only changes will be comparing element only with i index value
we will compare will i,i-1,i+1
That's all done

 */

public class SearchingInNearlySortedArray {

    private static int findEleInNearlySorted(int[] arr, int ele) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            if(ele ==arr[mid] ){
                return mid;
            }else if(mid-1 > start && arr[mid-1] == ele){
                return mid-1;
            }else if(mid+1 < end && arr[mid+1] == ele){
                return mid+1;
            }else if(ele < arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int []arr={5,10,30,20,40};
        System.out.println("index "+ findEleInNearlySorted(arr , 30));
    }

}
