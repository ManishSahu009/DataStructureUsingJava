package org.ms.ds.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://www.techiedelight.com/first-k-non-repeating-characters-string/
 */
public class FirstKNonRepeating {


    public static void firstKNonRepeating(String str, int k)
    {

        Map<Character, PairFKNR> map = new HashMap<>();
        for (int i = 0 ; i < str.length(); i++)
        {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), new PairFKNR(1, i));
            }
            else {
                PairFKNR pair = map.get(str.charAt(i));
                pair.setCount(pair.getCount() + 1);
                pair.setIndex(i);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (PairFKNR value: map.values())
        {
            int count = value.getCount();
            int index = value.getIndex();

            if (count == 1)
            {
                if (--k >= 0) {
                    pq.add(index);
                }
                else if (index < pq.peek()) {
                    pq.poll();
                    pq.add(index);
                }
            }
        }

        while (!pq.isEmpty())
        {
            System.out.print(str.charAt(pq.poll()) + " ");
        }
    }


    public static void main (String[] args)
    {
        String str = "ABCDBAGHCHFAC";
        int k = 3;

        firstKNonRepeating(str, k);
    }
}


class PairFKNR
{
    private int count;
    private int index;

    PairFKNR(int count, int index) {
        this.count = count;
        this.index = index;
    }
    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
