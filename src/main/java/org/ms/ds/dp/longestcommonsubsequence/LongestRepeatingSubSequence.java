package org.ms.ds.dp.longestcommonsubsequence;

/*
Sheet code : LB64
https://www.geeksforgeeks.org/longest-repeated-subsequence/
Input: str = "AABEBCDD"
result: "ABD"
Length : 3

 */
public class LongestRepeatingSubSequence {


    int lcssur(String s1, String s2, int ls1, int ls2) {
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
                if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j) {
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
        LongestRepeatingSubSequence longestRepeatingSubSequence = new LongestRepeatingSubSequence();
        String s1 = "AABEBCDD";
        String s2 = s1;
        System.out.println("==>" + longestRepeatingSubSequence.lcssur(s1, s2, s1.length(),s2.length()));

    }

}
