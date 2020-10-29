package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15
{1,3,8,10,15} for key=12
{11,9,4,,2,3} => result: 10 as 2 is loweest diff
 */
public class MinimumDifferenceElementInSortedArrayForGivenKey {

    private static int minimumDifferenceElementInSortedArrayForGivenKey(int[] arr, int ele) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(ele ==arr[mid] ){
                return arr[mid];
            }else if(ele < arr[mid]){
                end=mid-1;
            }else if(ele > arr[mid]){
                start=mid+1;
            }
        }
        if(Math.abs(arr[start] - ele) < Math.abs(arr[end] - ele)){
            return arr[start];
        }else{
            return arr[end];
        }
    }

    public static void main(String[] args) {
        int []arr={1,3,8,10,15};
        int key=12;
        System.out.println("minimumDifferenceElementInSortedArrayForGivenKey " + minimumDifferenceElementInSortedArrayForGivenKey(arr,key));
    }
}
