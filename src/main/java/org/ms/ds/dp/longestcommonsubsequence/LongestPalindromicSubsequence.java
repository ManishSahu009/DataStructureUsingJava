package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
Input : agbcba
Output : 5

trick:
find LCS of given string S1 and reverse(S1)

 */

public class LongestPalindromicSubsequence {


    int lpss(String s1, String s2, int ls1, int ls2) {
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
        return t[ls1][ls2];

    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("==>" + longestPalindromicSubsequence.lpss(s1, s2, s1.length(),s2.length()));

    }

}
