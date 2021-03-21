package org.ms.ds.array;

import java.util.Arrays;

/*

https://www.techiedelight.com/positive-and-negative-integers-segregate/
 */

public class SegregatePositiveNegative {

    public static void partition(int[] a, int start, int end)
    {
        int pIndex = start;
        //pindex and i will go togather till positive once -ve comes pindex will not move untill swap
        for (int i = start; i <= end; i++)
        {
            if (a[i] < 0)   // pivot is 0
            {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] a = { 9, -3, 5, -2, -8, -6, 1, 3 };

        partition(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
