package org.ms.ds.hashing;

/*
https://www.techiedelight.com/construct-longest-palindrome-string/
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructLongestPalindrome {
    public static String longestPalindrome(String str)
    {

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch: str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Character midChar = null;
        StringBuilder left = new StringBuilder();

        for (var entry: freq.entrySet())
        {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (count % 2 == 1) {
                midChar = ch;
            }
            left.append(String.valueOf(ch).repeat(count / 2));
        }
        StringBuilder right = new StringBuilder(left).reverse();
        return ("" + left + midChar + right);
    }

    public static void main(String[] args)
    {
        String str = "ABBDAB";
        System.out.print("The Longest Palindrome is " + longestPalindrome(str));
    }


}
