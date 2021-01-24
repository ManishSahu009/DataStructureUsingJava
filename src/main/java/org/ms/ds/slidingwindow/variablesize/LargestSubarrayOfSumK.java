package org.ms.ds.slidingwindow.variablesize;

public class LargestSubarrayOfSumK {
    public static void largestSubarrayOfSumK(int []arr, int k){
        int j=0, i=0, max=Integer.MIN_VALUE,sum=0;
        while(j < arr.length){
            sum=sum+arr[j];
            if(sum < k){
                j++;
            }else if(sum == k){
                max=Math.max(max,j-i+1);
                j++;
            }else if(sum > k){
                while(sum >= k && i <= j ){
                    sum=sum-arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println("max length: " + max);
    }

    public static void main(String[] args) {
        int []arr={10, 5, 2, 7, 1, 9};
        int k=15;
        largestSubarrayOfSumK(arr,k);

    }

}
