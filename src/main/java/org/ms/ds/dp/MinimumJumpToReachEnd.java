package org.ms.ds.dp;
/*
dynamic programming : n^2
https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

https://www.youtube.com/watch?v=Zobz9BXpwYE
 */
public class MinimumJumpToReachEnd {

    public static void solveNoJumpDP(Integer []arr, int length){
        Integer []dp=new Integer[length];
        // Minimum number of jumps
        // needed to reach last
        // element from last elements
        // itself is always 0
        dp[length-1]=0;
        // Start from the second
        // element, move from right
        // to left and construct the
        // jumps[] array where jumps[i]
        // represents minimum number of
        // jumps needed to reach arr[m-1]
        // from arr[i]
        for(int i=length-2 ; i >=0 ;i--){
            int step=arr[i];
            int min=Integer.MAX_VALUE;
            for(int j=1 ; j<=step && (i+j)<arr.length;j++){
                if(dp[i+j]!=null && dp[i+j] < min){
                    min=dp[i+j];
                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i]=min+1;
            }
        }
        System.out.println(dp[0]);
    }

    public static void main(String[] args) {
        Integer []arr=new Integer[]{3,3,0,2,1,2,4,2,0,0};
        solveNoJumpDP(arr,arr.length);
    }
}
