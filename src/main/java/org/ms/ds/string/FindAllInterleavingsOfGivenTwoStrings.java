package org.ms.ds.string;

import java.util.HashSet;
import java.util.Set;

/*

https://www.techiedelight.com/find-interleavings-of-given-strings/
 */
public class FindAllInterleavingsOfGivenTwoStrings {

    public static void interleavings(String curr, String X, String Y, Set<String> result)
    {

        if (X.length() == 0 && Y.length() == 0)
        {
            result.add(curr);
            return;
        }

        // if String X is not empty, append its first character in the
        // result and recur for remaining substring
        if (X.length() > 0) {
            interleavings(curr + X.charAt(0), X.substring(1), Y, result);
        }

        // if String Y is not empty, append its first character in the
        // result and recur for remaining substring
        if (Y.length() > 0) {
            interleavings(curr + Y.charAt(0), X, Y.substring(1), result);
        }
    }

    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACB";
        Set<String> result = new HashSet<>();
        interleavings("", X, Y, result);

        result.stream().forEach(System.out::println);
    }
}
