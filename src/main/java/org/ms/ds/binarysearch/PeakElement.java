package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours.
For corner elements, we need to consider only one neighbour.
Input: array[]= {5, 10, 20, 15}
Output: 20
in case of multiple element any one can be answer
Why to apply binary search?
find mid element
we need to decide on which side is more promising ro move left or right
type of problem : binary search on answer
 */
public class PeakElement {

    private static int PeakElement(int[] arr) {
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
        int []arr={5, 10, 20, 15};
        System.out.println("PeakElement " + PeakElement(arr));
    }
}
