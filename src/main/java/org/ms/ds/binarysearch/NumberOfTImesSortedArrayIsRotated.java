package org.ms.ds.binarysearch;
/*
https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
1. smaller element index will tell the no. of rotation
2. element where nearest left and right is larger will be smallest one
3. where to move (left or right ) ? - > move where subarray is not shorted
 */

public class NumberOfTImesSortedArrayIsRotated {

    private static int findNoOfRotation(int[] arr , int n) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){

            int mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            int next = (mid + 1) % n;
            int prev = (mid + n -1) % n;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                return mid;
            }else {
                if(arr[mid]>=arr[start] && arr[mid]<=arr[end]){
                    return start;
                }else if (arr[start] <= arr[mid]){
                    start=mid+1;
                }else if (arr[mid] <= arr[end]){
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int []arr={2,5,6,8,11,12,15,18};
        //rotated above array 4 times
        int []rotatedArr={11,12,15,18,2,5,6,8};
        System.out.println("count "+ findNoOfRotation(rotatedArr , arr.length));
    }

}
