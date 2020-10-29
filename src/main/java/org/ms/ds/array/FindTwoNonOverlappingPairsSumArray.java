package org.ms.ds.array;

/*
https://www.techiedelight.com/find-two-non-overlapping-pairs-sum-array/

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTwoNonOverlappingPairsSumArray {

    static class Pair
    {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void findPairs(int[] A)
    {
        // create an empty map
        // key -> sum of a pair of elements in the array
        // value -> list storing index of every pair having that sum
        Map<Integer, List<Pair>> map = new HashMap<>();

        // consider every pair (A[i], A[j]) where (j > i)
        for (int i = 0; i < A.length - 1; i++)
        {
            for (int j = i + 1; j < A.length; j++)
            {
                int sum = A[i] + A[j];
                if (map.containsKey(sum))
                {
                    // check every pair having desired sum
                    for (Pair pair : map.get(sum))
                    {
                        int m = pair.x;
                        int n = pair.y;

                        // if pairs don't overlap, print them and return
                        if ((m != i && m != j) && (n != i && n != j))
                        {
                            System.out.println("First Pair  (" + A[i] + ", "
                                    + A[j] + ")");

                            System.out.println("Second Pair (" + A[m] + ", "
                                    + A[n] + ")");

                            return;
                        }
                    }
                }

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new Pair(i, j));
            }
        }
        System.out.print("No non-overlapping pairs present");
    }

    public static void main(String[] args)
    {
        int[] A = { 3, 4, 7, 3, 4 };

        findPairs(A);
    }
}
