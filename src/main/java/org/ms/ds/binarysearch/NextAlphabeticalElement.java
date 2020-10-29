package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=X45c37QMdX0&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=12
https://www.geeksforgeeks.org/smallest-alphabet-greater-than-a-given-character/
same as ceil problem
 */

public class NextAlphabeticalElement {

    private static char findCeilOfElementInSortedArray(char[] arr, int ele) {
        int result=Integer.MIN_VALUE;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(ele ==arr[mid] ){
                start=mid+1;
            }else if(ele < arr[mid]){
                result=mid;
                end=mid-1;
            }else if(ele > arr[mid]){
                start=mid+1;
            }
        }
        return arr[result];
    }

    public static void main(String[] args) {

        char []arr={'a','c','f','h'};
        System.out.println("index "+ findCeilOfElementInSortedArray(arr , 'f'));
    }


}
