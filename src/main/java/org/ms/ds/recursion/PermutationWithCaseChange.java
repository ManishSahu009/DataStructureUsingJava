package org.ms.ds.recursion;

public class PermutationWithCaseChange {

    static void permutationWithSpace(String input, String output) {
        if("".equals(input)){
            System.out.println(output);
            return;
        }
        String output1=output;
        String output2=output;
        output1=output1+Character.toString(input.charAt(0)).toUpperCase();
        output2=output2+input.charAt(0);
        input=input.substring(1);
        permutationWithSpace(input,output1);
        permutationWithSpace(input,output2);

    }

    public static void main(String[] args) {
        String input = "manish";
        String output = "";
        permutationWithSpace(input, output);
    }
}
