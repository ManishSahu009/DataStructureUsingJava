package org.ms.ds.string;
/*
https://www.techiedelight.com/find-minimum-operations-required-transform-string-into-another/
 */

import java.util.Arrays;

public class FindMinimumOperationsRequiredTransformStringIntoAnother {
    public static int getMinimumOperations(String first, String second)
    {
        // to keep track of minimum number of operations required
        int count = 0;

        // i and j keep track of index of current characters in the
        // first and second String respectively

        // start from the end of first and second String
        for (int i = first.length() - 1, j = i; i >= 0; i--, j--)
        {
            // if current character of both Strings doesn't match,
            // search for second[j] in the sub-String first[0,i-1] and
            // increment the count for every move
            while (i >= 0 && first.charAt(i) != second.charAt(j))
            {
                i--;
                count++;
            }
        }

        // return the minimum operations required
        return count;
    }

    // Function to determine if the first String can be transformed into
    // the second String
    public static boolean isTransformable(char[] first, char[] second)
    {
        // if length of both Strings differ
        if (first.length != second.length) {
            return false;
        }

        Arrays.sort(first);
        Arrays.sort(second);

        // return true if both Strings have same set of characters
        return (Arrays.toString(first).equals(Arrays.toString(second)));
    }

    public static void main(String[] args)
    {
        String first = "ADCB";
        String second = "ABCD";

        if (isTransformable(first.toCharArray(), second.toCharArray()))
        {
            System.out.println("Minimum operations required to convert the String "
                    + first + " to String " + second + " are "
                    + getMinimumOperations(first, second));
        }
        else {
            System.out.println("The String cannot be transformed");
        }
    }
}
