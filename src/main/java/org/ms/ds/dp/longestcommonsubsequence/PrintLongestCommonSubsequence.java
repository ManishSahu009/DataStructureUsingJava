package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.


 */

public class PrintLongestCommonSubsequence {


    String lcssur(String s1, String s2, int ls1, int ls2) {
        int t[][]=new int[ls1+1][ls2+1];
        for(int i=0 ; i < ls1+1 ; i++) {
            for (int j = 0; j < ls2+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j]= 0;
                }
            }
        }
        for(int i=1 ; i < ls1+1 ; i++) {
            for (int j = 1; j < ls2 + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j]= 1 + t[i - 1][j - 1];
                }
                else{
                    t[i][j]= Integer.max(t[i-1][j] ,t[i][j - 1]);
                }
            }
        }
        return buildString(t,s1,s2);

    }

    String buildString(int [][]t,String s1, String s2){
        String a="";
        int i=s1.length();
        int j=s2.length();
        while(i>0 || j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                 a=s1.charAt(i-1) + a;
                 i--;
                 j--;
            }else{
                if(t[i][j-1] > t[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        PrintLongestCommonSubsequence longestCommonSubsequenceUsingRecursion = new PrintLongestCommonSubsequence();
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println("==>" + longestCommonSubsequenceUsingRecursion.lcssur(s1, s2, s1.length(),s2.length()));

    }

}
