package org.ms.ds.array;

import java.util.Arrays;

/*

https://www.techiedelight.com/longest-alternating-subarray-problem/
logic is multiply should be negative if they have diff sign
 */
public class LongestAlternatingPositiveNagetive {

    public static void findLongestSubArray(int[] arr)
    {

        int maxLen = 1;
        int endIndex = 0;
        int currLen = 1;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] * arr[i - 1] < 0)
            {
                currLen++;
                if (currLen > maxLen)
                {
                    maxLen = currLen;
                    endIndex = i;
                }
            }
            else {
                currLen = 1;
            }
        }

        int[] subarray = Arrays.copyOfRange(arr, (endIndex - maxLen + 1), endIndex + 1);
        System.out.println("The longest alternating subarray is "
                + Arrays.toString(subarray));
    }

    public static void main (String[] args)
    {
        int[] arr = { 1, -2, 6, 4, -3, 2, -4, -3 };

        findLongestSubArray(arr);
    }
}
