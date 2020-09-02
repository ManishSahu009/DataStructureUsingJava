package org.ms.ds.heap;

/*
https://www.techiedelight.com/sort-k-sorted-array/
mean each element can be at k distance from its position to left or right


 */

import java.util.*;

public class SortKSortedArray {

    private static void sortKSortedArray(List<Integer> list, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<list.size();i++){
            queue.add(list.get(i));
            if(queue.size() > k){
                list.set(i-k,queue.poll());
            }
        }
        while(!queue.isEmpty()){
            list.set(list.size() - queue.size(),queue.poll());
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9));
        int k = 2;

        sortKSortedArray(list, k);
        System.out.println(list);
    }

}
