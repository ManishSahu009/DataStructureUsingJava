package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/shortest-common-supersequence/
Input:   str1 = "geek",  str2 = "eke"
Output: "geeke"

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  "AGXGTXAYB"

1. here first find the LCS of both string
2. then return LCS + (S1-LCS) + (S2-LCS) = s1 + s2 - LCS

 */

public class ShortestCommonSuperSequence {


    int scss(String s1, String s2, int ls1, int ls2) {
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
        return ls1 + ls2 - t[ls1][ls2];

    }

    public static void main(String[] args) {
        ShortestCommonSuperSequence shortestCommonSuperSequence = new ShortestCommonSuperSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("==>" + shortestCommonSuperSequence.scss(s1, s2, s1.length(),s2.length()));

    }

}
