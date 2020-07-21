package org.ms.ds.dp.longestcommonsubsequence;

/*
https://www.geeksforgeeks.org/longest-common-substring-dp-29/
Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.
Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
The longest common substring is “abcd” and is of length 4.


 */

public class LongestCommonSubString {


    int lcss(String s1, String s2, int ls1, int ls2) {

        int t[][]=new int[ls1+1][ls2+1];
        int result=Integer.MIN_VALUE;

        for(int i=0 ; i < ls1+1 ; i++) {
            for (int j = 0; j < ls2+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j]= 0;
                }
            }
        }
        for(int i=1 ; i < ls1+1 ; i++) {
            for (int j = 1; j < ls2+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j]= 1 + t[i - 1][j - 1];
                    result = Integer.max(result,t[i][j]);
                }
                else{
                    t[i][j]= 0;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println("==>" + longestCommonSubString.lcss(s1, s2, s1.length(),s2.length()));

    }

}
