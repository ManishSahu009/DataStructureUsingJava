package org.ms.ds.dp.longestcommonsubsequence;
/*
https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
Input : aebcbda
Output : 2
Add characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string

trick:
find LCS of given string S1 and reverse(S1)
return s1-lcs

Same as no. of deletion
 */

public class MinimumNoOfInsertionToConvertInPalindrom {


    int mnoitcip(String s1, String s2, int ls1, int ls2) {
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
        return ls1-t[ls1][ls2];

    }

    public static void main(String[] args) {
        MinimumNoOfInsertionToConvertInPalindrom minimumNoOfInsertionToConvertInPalindrom = new MinimumNoOfInsertionToConvertInPalindrom();
        String s1 = "acbcbda";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("==>" + minimumNoOfInsertionToConvertInPalindrom.mnoitcip(s1, s2, s1.length(),s2.length()));

    }

}
