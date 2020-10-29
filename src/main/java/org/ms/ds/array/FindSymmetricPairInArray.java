package org.ms.ds.array;

import java.util.HashSet;
import java.util.Set;

public class FindSymmetricPairInArray {

    static class Pair
    {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void findPairs(Pair[] pairs)
    {
        Set<String> set = new HashSet<>();

        for (Pair curr_pair: pairs)
        {
            String p = "{" + curr_pair.x + ", " + curr_pair.y + "}";
            set.add(p);
            String rev_pair = "{" + curr_pair.y + ", " + curr_pair.x + "}";
            if (set.contains(rev_pair)) {
                System.out.println(p + " | " + rev_pair);
            }
        }
    }

    public static void main(String[] args)
    {
        Pair[] pairs =
                {
                        new Pair(3, 4), new Pair(1, 2), new Pair(5, 2),
                        new Pair(7, 10), new Pair(4, 3), new Pair(2, 5)
                };

        findPairs(pairs);
    }
}
