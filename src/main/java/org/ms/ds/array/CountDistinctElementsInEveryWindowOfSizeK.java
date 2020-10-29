package org.ms.ds.array;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 */
public class CountDistinctElementsInEveryWindowOfSizeK {

    public static void findDistinctCount(int[] arr, int k) {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        //first window
        for (int i = 0; i < k; i++) {
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
        }
        // Print count of first window
        System.out.println(hM.size());
        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++) {
            if (hM.get(arr[i - k]) == 1) {
                hM.remove(arr[i - k]);
            }else {
                hM.put(arr[i - k], hM.get(arr[i - k]) - 1);
            }
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
            System.out.println(hM.size());
        }
    }

    public static void main(String[] args)
    {
        int[] input = { 1, 1, 2, 1, 3 };
        int k = 3;
        findDistinctCount(input, k);
    }
}
