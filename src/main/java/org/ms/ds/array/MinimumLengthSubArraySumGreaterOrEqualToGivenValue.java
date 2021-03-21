package org.ms.ds.array;

/*
https://webrewrite.com/minimum-size-subarray-sum/
sheet code : LB36
 */

public class MinimumLengthSubArraySumGreaterOrEqualToGivenValue {

    public static int minSubArrayLengthBruteForce(int[] nums, int k){
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum >= k ) {
                    minLength = Math.min(minLength, (j-i)+1);
                    break;
                }
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static int minSubArrayLength(int[] nums, int k) {

        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= k && start <= end) {
                minLength = Math.min(minLength, (end - start) + 1);
               sum = sum - nums[start++];
             }
          }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }


    public static void main(String[] args) {
        int[] arr = { 7, 2, 1, 1, 6, 5 };
        int k = 11;

        int length = minSubArrayLength(arr, k);
        System.out.println(length);

    }
}
