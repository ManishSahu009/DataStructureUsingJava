package org.ms.ds.hashing;

/*
https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] A)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // return the element if its count is more than n/2
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue() > A.length/2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityElementBoyerMoore(int[] A)
    {
        // m stores majority element if present
        int m = -1;

        // initialize counter i with 0
        int i = 0;

        // do for each element A[j] of the array
        for (int j = 0; j < A.length; j++)
        {
            // if the counter i becomes 0
            if (i == 0)
            {
                // set the current candidate to A[j]
                m = A[j];

                // reset the counter to 1
                i = 1;
            }

            // else increment the counter if A[j] is current candidate
            else if (m == A[j]) {
                i++;
            }
            // else decrement the counter if A[j] is not current candidate
            else {
                i--;
            }
        }
        return m;
    }

    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        int res = majorityElementBoyerMoore(arr);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }
    }


}

