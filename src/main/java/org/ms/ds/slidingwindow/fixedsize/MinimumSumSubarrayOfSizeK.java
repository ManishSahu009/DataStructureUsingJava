package org.ms.ds.slidingwindow.fixedsize;

/*
https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/

 */
public class MinimumSumSubarrayOfSizeK {

        public static void minSumSubarrayOfSizeK(int []arr, int k){
            int j=0, i=0, min=Integer.MAX_VALUE,sum=0;
            while(j < arr.length){
                sum=sum+arr[j];
                if(j-i+1 < k){
                    j++;
                }else if(j-i+1 == k){
                    min=Math.min(min,sum);
                    sum=sum-arr[i];
                    i++;
                    j++;
                }
            }
            System.out.println("min sum: " + min);
        }

        public static void main(String[] args) {
            int []arr={1, 4, 2, 10, 23, 3, 1, 0, 20};
            int k=4;
            minSumSubarrayOfSizeK(arr,k);

        }

}
