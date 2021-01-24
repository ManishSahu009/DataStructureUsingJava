package org.ms.ds.recursion;
/*
Print N-bit binary numbers having more or equal 1’s than 0’s for any prefix
 */
public class PrintNBitBinaryNumbers {

    static void permutationWithSpace(Integer n, Integer oneCount, Integer zeroCount, String output) {
        if(n==0){
            System.out.println(output);
            return;
        }
        permutationWithSpace(n-1,oneCount+1,zeroCount,output+"1");
        if(oneCount>zeroCount){
            permutationWithSpace(n-1,oneCount,zeroCount+1,output+"0");
        }

    }

    public static void main(String[] args) {
        Integer n = 4;
        permutationWithSpace(n,0,0, "");
    }
}
