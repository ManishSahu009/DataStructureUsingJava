package org.ms.ds.array;

/*
https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/

 */
public class MinimumSumSubarrayOfSizeK {



    public static void findSubarray(int[] arr, int k){
        int minWindow=Integer.MAX_VALUE;
        int currentWindowSum=0;
        int last=0;
        for(int i=0 ; i < arr.length ; i++){
            currentWindowSum=currentWindowSum+arr[i];
            if(i+1 >=k){
                if(minWindow > currentWindowSum){
                    minWindow=currentWindowSum;
                    last=i;
                }
                currentWindowSum=currentWindowSum- arr[i+1-k];
            }
        }
        System.out.printf("Minimum sum sub-array is (%d, %d)", last - k + 1, last); System.out.println("");

    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
        int k = 3;
        findSubarray(arr, k);
    }

}
