package org.ms.ds.twopointer;

import java.sql.Array;
import java.util.Arrays;

public class TripletSumClosestToTarget {

    public static int threeSumClosest(int[] arr, int targetSum) {
        int i = 0;
        int closestDiff = Integer.MAX_VALUE, closestSum = 0;
        while (i <= arr.length - 3) {
            int j = i + 1, k = arr.length - 1;
            int sum = arr[i] + arr[j] + arr[k];
            while (j < k) {
                if (Math.abs(targetSum - sum) < closestDiff) {
                    closestDiff = Math.abs(targetSum - sum);
                    closestSum = sum;
                }
                if (targetSum > sum) {
                    sum = sum - arr[j]; //remove previous value
                    j++;
                    sum = sum + arr[j];

                } else if (targetSum < sum) {
                    sum = sum - arr[k]; //remove previous value
                    k--;
                    sum = sum + arr[k];

                } else {
                    return sum;
                }
            }
            i++;
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 1, -4};
        int targetSum = 1;
        Arrays.sort(arr);
        System.out.println(threeSumClosest(arr, targetSum));

    }
}
