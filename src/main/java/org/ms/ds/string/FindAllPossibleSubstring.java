package org.ms.ds.string;

/*
https://www.techiedelight.com/find-possible-palindromic-substrings-string/
 */

import java.util.HashSet;
import java.util.Set;

public class FindAllPossibleSubstring {

    public static void expand(String str, int low, int high, Set<String> set)
    {
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high))
        {
            set.add(str.substring(low, high + 1));
            low--;
            high++;
        }
    }


    public static void allPalindromicSubStrings(String str)
    {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
        {
            expand(str, i, i, set);
            expand(str, i, i + 1, set);
        }
        System.out.print(set);
    }

    public static void main(String[] args)
    {
        String str = "google";
        allPalindromicSubStrings(str);
    }

}
