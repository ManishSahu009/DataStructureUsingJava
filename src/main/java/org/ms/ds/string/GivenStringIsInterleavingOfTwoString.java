package org.ms.ds.string;

import java.util.HashSet;
import java.util.Set;

public class GivenStringIsInterleavingOfTwoString {

    public static boolean interleavings(String curr, String X, String Y) {
        int ic=0,ix=0,iy=0;

        while (ic < curr.length()){
            if (curr.charAt(ic) == X.charAt(ix)) {
              ix++;
            }else if(curr.charAt(ic) == Y.charAt(iy)){
                iy++;
            }else {
                return false;
            }
            ic++;
       }
        if(ix<X.length() || iy<Y.length()){

        }
        return true;
    }

    public static boolean interleavedRecursion(String X, String Y, String S)
    {
        // return true if we have reached end of all Strings
        if (X.length() == 0 && Y.length() == 0 && S.length() == 0) {
            return true;
        }

        // return false if we have reached the end of String S
        // but String X or Y are not empty

        if (S.length() == 0) {
            return false;
        }

        // if String X is not empty and its first character matches with
        // first character of S, recur for remaining substring

        if (X.length() != 0 && S.charAt(0) == X.charAt(0)) {
            return interleavedRecursion(X.substring(1), Y, S.substring(1));
        }

        // if String Y is not empty and its first character matches with
        // first character of S, recur for remaining substring

        if (Y.length() != 0 && S.charAt(0) == Y.charAt(0)) {
            return interleavedRecursion(X, Y.substring(1), S.substring(1));
        }

        return false;
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "DEF";
        String S = "ADEBFC";

        if (interleavedRecursion(X, Y, S)) {
            System.out.print("Given String is interleaving of X and Y");
        } else {
            System.out.print("Given String is not interleaving of X and Y");
        }
    }
}
