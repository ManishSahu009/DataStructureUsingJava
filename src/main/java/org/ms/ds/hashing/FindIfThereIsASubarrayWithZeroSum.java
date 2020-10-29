package org.ms.ds.hashing;

/*

If we consider all prefix sums, we can
notice that there is a subarray with 0
sum when :
1) Either a prefix sum repeats or
2) Or prefix sum becomes 0.

 */

import java.util.HashSet;
import java.util.Set;

public class FindIfThereIsASubarrayWithZeroSum {

    private static boolean subArrayExists(int[] arr) {
        Set<Integer> set=new HashSet<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum + arr[i];
            if(arr[i]==0 || sum==0 || set.contains(sum)){
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, -2, -2, 5, -4, 3};
        if (subArrayExists(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");

    }

}
