package org.ms.ds.recursion;

import java.util.ArrayList;
/*
sheet code : LB65
 */
public class PrintAllSubsequence {

        public static void main(String[] args) throws Exception {
        String str = "abc";
        printSS(str,"");
    }

    public static void printSS(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        printSS(roq, ans + ch);
        printSS(roq, ans + "");
    }
}

