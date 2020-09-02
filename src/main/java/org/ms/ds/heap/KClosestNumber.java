package org.ms.ds.heap;

/*
https://www.geeksforgeeks.org/find-k-closest-elements-given-value/

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumber {

    private static void findKthClosest(List<Integer> list, int k,int x) {
        PriorityQueue<Pair> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<list.size();i++){
            queue.add(new Pair(Math.abs(list.get(i) - x),i));
            if(queue.size() > k){
                queue.poll();
            }
        }

        queue.forEach(e -> System.out.println(list.get(e.index)));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 6, 7, 8, 9);
        int k = 3;
        int x=7;
        findKthClosest(list, k,x);
    }

}

class Pair implements  Comparable<Pair>{

    Integer diff;
    Integer index;

    public Pair(Integer diff, Integer index) {
        this.diff = diff;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return this.diff.compareTo(o.diff);
    }
}
