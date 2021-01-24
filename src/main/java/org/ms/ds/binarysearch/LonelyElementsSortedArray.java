package org.ms.ds.binarysearch;

/*
here logic is to apply binary search
if middle element is not lonely then decide on where to move. left or right ?
if first occurrence is not on even or second occurrence of each element is not on odd position in left
thn move right else move at right
 */
public class LonelyElementsSortedArray {

    private static int fineLonely(int[] arr) {
        int left=0, right=arr.length-1;
        if(arr.length==1){
            return arr[0];
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(isLonely(arr,mid)){
                return arr[mid];
            }
            if(mid+1< arr.length && arr[mid]==arr[mid+1]){
                if(mid%2==0 ){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }if(mid>=1 && arr[mid]==arr[mid-1]){
                if(mid%2==1){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return arr[left];
    }

    public static boolean isLonely(int []arr, int mid){
        if(mid==0 && arr[mid] !=arr[mid+1]){
            return true;
        }if(mid==arr.length-1 && arr[mid]!=arr[mid-1]){
            return true;
        }
        if(arr[mid] !=arr[mid+1] && arr[mid]!=arr[mid-1]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int []arr=new int[]{2,2,3,3,5,5,7,9,9};
        System.out.println(fineLonely(arr));
    }


}
