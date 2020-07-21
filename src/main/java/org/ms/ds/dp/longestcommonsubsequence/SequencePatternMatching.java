package org.ms.ds.dp.longestcommonsubsequence;
/*
Order preserve and can be discontinues
String s1 = "AXY";
String s2 = "ADXCPY";
output : true
trick :
here s1 will be equal to LCS if not means return false
comparing only length will work also

 */

public class SequencePatternMatching {

    boolean spm(String s1, String s2, int ls1, int ls2) {
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
        return t[ls1][ls2]==s1.length();

    }

    public static void main(String[] args) {
        SequencePatternMatching sequencePatternMatching = new SequencePatternMatching();
        String s1 = "AXY";
        String s2 = "ADXCPY";
        System.out.println("==>" + sequencePatternMatching.spm(s1, s2, s1.length(),s2.length()));

    }

}
