package org.ms.ds.dp.longestcommonsubsequence;

/*
String s1 = "heap";
String s2 = "pea";
2 deletion
1 insertion required to chnage string s1 to s2

deletion = s1 - lcs
insertion = s2 - lcs
 */
class MinimumEditDistanceOnlyWithInsertDelete {


    String medwid(String s1, String s2, int ls1, int ls2) {

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
        return "Deletion : "+(ls1-t[ls1][ls2]) +", Insertion : "+ (ls2-t[ls1][ls2]); // 1st part is no. of deletion and 2nd part is no. of insertion

    }

    public static void main(String[] args) {
        MinimumEditDistanceOnlyWithInsertDelete minimumEditDistanceWithInsertDelete = new MinimumEditDistanceOnlyWithInsertDelete();
        String s1 = "heap";
        String s2 = "pea";
        System.out.println("==>" + minimumEditDistanceWithInsertDelete.medwid(s1, s2, s1.length(),s2.length()));

    }

}
