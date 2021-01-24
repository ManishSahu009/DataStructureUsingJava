package org.ms.ds.recursion;

/*
here main logic is I/O tree can or can not have 2 branches
if number of opening bracket is greater than closing bracket then only 2 option else only one option
 */
public class GenerateAllBalancedParentheses {

    static void permutationWithSpace(Integer openBrckt, Integer closeBrckt, String output) {
        if(openBrckt==0 && closeBrckt==0){
            System.out.println(output);
            return;
        }
        if (openBrckt!=0){
            permutationWithSpace(openBrckt-1,closeBrckt,output+"(");
        }
        if(openBrckt<closeBrckt){
            permutationWithSpace(openBrckt,closeBrckt-1,output+")");
        }

    }

    public static void main(String[] args) {
        Integer n = 4;
        permutationWithSpace(n,n, "");
    }
}
