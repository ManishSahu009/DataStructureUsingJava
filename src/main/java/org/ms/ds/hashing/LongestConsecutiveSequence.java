package org.ms.ds.hashing;
/*
https://afteracademy.com/blog/longest-consecutive-sequence


 */

import java.util.Arrays;
import java.util.HashMap;
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

    //pepcoding logic
    private static void findLongestConseqSubseq3(int[] arr) {
        //Here boolean is indicating that ele is starting point of LCSS
        HashMap<Integer, Boolean> map=new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int startingPoint=0;
        for(Integer ele:arr){
            //put default true for all element considering they are the starting point for LCSS
            map.put(ele,true);
        }
        for(Integer ele:arr){
            if(map.containsKey(ele-1)){
                map.put(ele,false);
            }
        }
        for(Integer ele : arr){
            if(map.get(ele) == true ){
                int count = 1;
                while(map.containsKey(ele+count)){
                    count++;
                }
                if(count > maxLen){
                    maxLen=count;
                    startingPoint=ele;
                }
            }
        }
        for(int i=0 ; i<maxLen ; i++){
            System.out.println(startingPoint+i + " ");
        }
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

        findLongestConseqSubseq3(arr);
    }


}
