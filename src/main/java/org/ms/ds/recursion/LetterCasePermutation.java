package org.ms.ds.recursion;

import java.util.Locale;

/*

https://leetcode.com/problems/letter-case-permutation/

input : a1b2c
 */
public class LetterCasePermutation {

    static void permutationWithSpace(String input, String output) {
        if("".equals(input)){
            System.out.println(output);
            return;
        }
        if( (input.charAt(0) >= 'a' && input.charAt(0) <= 'z') || (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z')) {
            String output1 = output;
            String output2 = output;
            output1 = output1 + Character.toString(input.charAt(0)).toLowerCase();
            output2 = output2 + Character.toString(input.charAt(0)).toUpperCase();
            input=input.substring(1);
            permutationWithSpace(input,output1);
            permutationWithSpace(input,output2);
        }else{
            String output1 = output;
            output1 = output1 + input.charAt(0);
            input=input.substring(1);
            permutationWithSpace(input,output1);
        }


    }

    public static void main(String[] args) {
        String input = "a1b2c";
        String output = "";
        permutationWithSpace(input, output);
    }
}
