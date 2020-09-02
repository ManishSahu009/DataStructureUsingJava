package org.ms.ds.heap;

/*
https://www.techiedelight.com/find-kth-smallest-element-array/

 */

import java.util.*;

public class FindKthSmallest {

    private static Integer findKthSmallestUsingMaxHeap(List<Integer> list, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<list.size();i++){
         queue.add(list.get(i));
          if(queue.size() > k){
              queue.poll();
          }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;

        System.out.println("K'th smallest element in the array is " +
                findKthSmallestUsingMaxHeap(A, k));
    }


}
