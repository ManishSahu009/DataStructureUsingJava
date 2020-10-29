package org.ms.ds.array;

/*
https://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/

Find difference array arr[] such that arr[i] = arr1[i] – arr2[i].
Largest subarray with equal number of 0s and 1s in the difference array.

 */

import java.util.HashMap;

public class LongestSpanWithSameSumInTwoBinaryArrays {

    static int longestCommonSum(int[] arr1, int[] arr2, int n)
    {
        // Find difference between the two
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = arr1[i] - arr2[i];

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0)
                max_len = i + 1;

            if (hM.containsKey(sum)) {
                max_len = Math.max(max_len, i - hM.get(sum));
            }else {
                hM.put(sum, i);
            }
        }
        return max_len;
    }


    public static void main(String args[])
    {
        int[] arr1 = {0, 1, 0, 1, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 1, 1, 0, 1};
        int n = arr1.length;
        System.out.println(longestCommonSum(arr1, arr2, n));
    }

}
