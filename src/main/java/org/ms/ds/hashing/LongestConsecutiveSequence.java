package org.ms.ds.hashing;
/*
https://afteracademy.com/blog/longest-consecutive-sequence
 */

import java.util.Arrays;
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

    private static Integer findLongestConseqSubseq2(int[] arr) {
        Set<Integer> copyArr=new HashSet<>();
        Set<Integer> done=new HashSet<>();
        int maxLen=Integer.MIN_VALUE;
        Arrays.stream(arr).forEach(ele -> copyArr.add(ele));
        for(Integer i : copyArr){
            if(done.contains(i)){
                continue;
            }
            int j=i;
            int count=0;
            while (copyArr.contains(j)){
                count++;
                done.add(j++);
            }
            j=i-1;
            while (copyArr.contains(j)){
                count++;
                done.add(j--);
            }
            if(maxLen < count){
                maxLen=count;
            }
        }
        return maxLen;
    }

    public static void main(String args[])
    {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                        + findLongestConseqSubseq(arr, n));

        System.out.println(
                "Length of the Longest consecutive subsequence 2 is "
                        + findLongestConseqSubseq2(arr));
    }


}
