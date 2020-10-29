package org.ms.ds.hashing;
/*
https://afteracademy.com/blog/longest-consecutive-sequence
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private static Integer findLongestConseqSubseq(int[] arr, int n) {

        Set<Integer> set=new HashSet<>();
        Integer longestLength=Integer.MIN_VALUE;
        for(int i=0 ; i < n; i++){
            set.add(arr[i]);
        }
        for(int i=0 ; i < n; i++){
            if(!set.contains(arr[i]-1)){
                Integer currentLength=1;
                Integer currentNumber=arr[i]+1;
                while(set.contains(currentNumber)){
                    currentLength=currentLength+1;
                    currentNumber=currentNumber+1;
                }
                longestLength=Math.max(longestLength,currentLength);
            }
        }
        return longestLength;
    }

    public static void main(String args[])
    {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + findLongestConseqSubseq(arr, n));
    }


}
