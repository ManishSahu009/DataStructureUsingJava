package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

 
 */

import java.util.Arrays;

public class LongestCommonSubsequenceUsingRecursionWithMemoization {
    int [][]t=new int[1001][1001];

    int lcssutda(String s1, String s2, int ls1, int ls2) {

        if(ls1 ==0 || ls2==0 ){
            return t[ls1][ls2]=0;
        }
        if(s1.charAt(ls1-1) == s2.charAt(ls2-1)) {
            return 1 + lcssutda(s1, s2, ls1 - 1, ls2 - 1);
        }
        else{
            return Integer.max(lcssutda(s1, s2, ls1 - 1, ls2), lcssutda(s1, s2, ls1, ls2 - 1));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequenceUsingRecursionWithMemoization longestCommonSubsequenceUsingRecursion = new LongestCommonSubsequenceUsingRecursionWithMemoization();
        Arrays.stream(longestCommonSubsequenceUsingRecursion.t).forEach(a-> Arrays.fill(a,-1));
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println("==>" + longestCommonSubsequenceUsingRecursion.lcssutda(s1, s2, s1.length(),s2.length()));

    }

}
