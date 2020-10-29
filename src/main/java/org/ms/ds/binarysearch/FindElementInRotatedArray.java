package org.ms.ds.binarysearch;

/*
https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8
find smallest element

 */
public class FindElementInRotatedArray {

    public static int findEleBS(int []arr, int ele,int s,int e){
        int start=s;
        int end=e;
        while(start<=end){
            int mid=(start+end)/2;
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

    private static int findEleInRotation(int[] arr , int ele) {
        int start=0;
        int mid=-1;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){

            mid=(start+end)/2;
            /*
            if in case test case failes bcoz of integer limit
            int mid= start + (end-start)/2;
             */
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length -1) % arr.length;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                result= mid;
                break;
            }else {
                if(arr[mid]>=arr[start] && arr[mid]<=arr[end]){
                    result= start;
                    break;
                }else if (arr[start] <= arr[mid]){
                    start=mid+1;
                }else if (arr[mid] <= arr[end]){
                    end=mid-1;
                }
            }
        }
        if(ele < arr[arr.length-1] ){
            return findEleBS(arr,ele,result+1,arr.length-1);
        }else{
            return findEleBS(arr,ele,0,result-1);
        }
    }

    public static void main(String[] args) {

        int []arr={2,5,6,8,11,12,15,18};
        //rotated above array 4 times
        int []rotatedArr={11,12,15,18,2,5,6,8};
        System.out.println("index "+ findEleInRotation(rotatedArr , 12));
    }

}
