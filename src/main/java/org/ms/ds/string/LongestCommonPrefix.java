package org.ms.ds.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String []str={"abcde","abcoo","abplp"};
        System.out.println(lcp(str));
    }

    private static String lcp(String[] array) {
        String ans=array[0];
        for(int i=1;i<array.length;i++){
            String temp="";
            for(int j=0;j<Math.min(ans.length(),array[i].length());j++){
                if(ans.charAt(j)==array[i].charAt(j)){
                    temp=temp+ans.charAt(j);
                }else {
                    break;
                }
            }
            ans=temp;
        }
        return ans;
    }
}
