package org.ms.ds.hashing;


import java.util.HashMap;
import java.util.Map;

/*
https://www.techiedelight.com/find-maximum-length-sub-array-equal-number-0s-1s/

 */
class FindMaximumLengthSubArrayHavingEqualNumberOf0And1
{
    public static void maxLenSubarray(int[] A)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int ending_index = -1;
        int sum = 0;
        for (int i = 0; i < A.length; i++)
        {
            // sum of elements so far (replace 0 with -1)
            sum += (A[i] == 0) ? -1: 1;

            if (map.containsKey(sum))
            {
                if (maxLen < i - map.get(sum))
                {
                    maxLen = i - map.get(sum);
                    ending_index = i;
                }
            }
            else {
                map.put(sum, i);
            }
        }
        if (ending_index != -1) {
            System.out.println("Max length : "+maxLen);
            System.out.println("[" + (ending_index - maxLen + 1) + ", " +
                    ending_index + "]");
        }
        else {
            System.out.println("No sub-array exists");
        }
    }

    public static void main (String[] args)
    {
        int[] A = { 0, 0, 1, 0, 1, 0, 0 };

        maxLenSubarray(A);
    }
}