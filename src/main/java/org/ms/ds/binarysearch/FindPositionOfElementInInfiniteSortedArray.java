package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13
challenge : how to mark end index?
Trick : here
end = start+1
and compare given element with element on end if end is small then keep doing end=end*2 and start=end
 */

public class FindPositionOfElementInInfiniteSortedArray {

    private static int findElementInInSortedArray(int[] arr, int ele,int start, int end) {
        int result=Integer.MIN_VALUE;
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

    private static int findElementInInfiniteSortedArray(int[] arr, int ele){
        int start=0;
        int end=1;
        while(ele >arr[end]){
            start=end;
            end=end*2;
        }
        return findElementInInSortedArray(arr,ele,start,end);

    }

    public static void main(String[] args) {

        int []arr={1,2,3,4,8,10,12,19};
        System.out.println("index "+ findElementInInfiniteSortedArray(arr , 8));
    }


}
