package org.ms.ds.slidingwindow.fixedsize;

public class MaximumSumSubarrayOfSizeK {
    public static void maxSumSubarrayOfSizeK(int []arr, int k){
        int j=0, i=0, max=Integer.MIN_VALUE,sum=0;
        while(j < arr.length){
            sum=sum+arr[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                max=Math.max(max,sum);
                sum=sum-arr[i];
                i++;
                j++;
            }
        }
        System.out.println("max sum: " + max);
    }

    public static void main(String[] args) {
        int []arr={1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k=4;
        maxSumSubarrayOfSizeK(arr,k);

    }

    
}
