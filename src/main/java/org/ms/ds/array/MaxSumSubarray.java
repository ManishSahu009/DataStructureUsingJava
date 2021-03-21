package org.ms.ds.array;

/*
https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
https://www.techiedelight.com/print-continuous-subarray-with-maximum-sum/
 */

public class MaxSumSubarray {

    private static Integer maxSubArraySum(int[] arr) {
        int maxSum=Integer.MIN_VALUE;
        int maxEnding=0;
        for(Integer a : arr){
            maxEnding = maxEnding + a;
            //a is deciding if be part of old family or start its own
            maxEnding=Integer.max(maxEnding,a);
            maxSum=Integer.max(maxSum,maxEnding);
        }
        return maxSum;

    }

    private static void printMaxSubArraySum(int[] arr) {
        int maxSum=Integer.MIN_VALUE;
        int maxEnding=0,start=0,end=0,beg=0;
        for(int i = 0; i < arr.length; i++){
            maxEnding = maxEnding + arr[i];
            if(maxEnding < 0){
                maxEnding=0;
                beg=i+1;
            }
            if(maxSum < maxEnding){
                maxSum=maxEnding;
                start=beg;
                end=i;
            }
        }
        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " +	maxSum);

        System.out.print("The contiguous sub-array with the largest sum is ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Max Sum Subarray is " + maxSubArraySum(a));
        printMaxSubArraySum(a);
    }


}
