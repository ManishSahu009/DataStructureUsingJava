package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/shortest-common-supersequence/
Input:   str1 = "geek",  str2 = "eke"
Output: "geeke"

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  "AGXGTXAYB"

1. here first find the LCS of both string
2.  LCS + (S1-LCS) + (S2-LCS) = s1 + s2 - LCS will be SCSS

 */

public class PrintShortestCommonSuperSequence {


    String pscss(String s1, String s2, int ls1, int ls2) {
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
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                a=s1.charAt(i-1) + a;
                i--;
                j--;
            }else{
                if(t[i][j-1] > t[i-1][j]){
                    a=s2.charAt(i-1) + a;
                    j--;
                }else{
                    a=s1.charAt(i-1) + a;
                    i--;
                }
            }
        }
        while(i>0){
            a=s1.charAt(i-1) + a;
            i--;
        }
        while(j>0){
            a=s2.charAt(j-1) + a;
            j--;
        }
        return a;
    }

    public static void main(String[] args) {
        PrintShortestCommonSuperSequence printShortestCommonSuperSequence = new PrintShortestCommonSuperSequence();
        String s1 = "GEEK";
        String s2 = "EKE";
        System.out.println("==>" + printShortestCommonSuperSequence.pscss(s1, s2, s1.length(),s2.length()));

    }

}
