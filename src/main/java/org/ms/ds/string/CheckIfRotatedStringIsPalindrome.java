package org.ms.ds.string;

public class CheckIfRotatedStringIsPalindrome {

    private static boolean expand(String str, int low, int high, int k)
    {
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high)))
        {
            if (high - low + 1 == k) {
                return true;
            }
            low--;
            high++;
        }
        return false;
    }

    private static boolean LongestPalindromicSubString(String str, int k)
    {
        for (int i = 0; i < str.length() - 1; i++) {
            if (expand(str, i, i, k) || expand(str, i, i + 1, k)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRotatedPalindrome(String str)
    {
        int m = str.length();
        return LongestPalindromicSubString(str + str, m);
    }

    public static void main(String[] args) {
        String str = "ABCDCBA";
        str = str.substring(2) + str.substring(0, 2);

        if (isRotatedPalindrome(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
