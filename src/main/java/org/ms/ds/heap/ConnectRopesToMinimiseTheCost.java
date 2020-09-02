package org.ms.ds.heap;

/*
https://medium.com/@vivek_ranjan/connect-n-ropes-with-minimum-cost-a865bcf12bdc
logic :
Always choose 2 minimum elements out of current rope we have after adding last one

 */

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectRopesToMinimiseTheCost {

    private static Integer connectRopesToMinimiseTheCost(List<Integer> a) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(a);
        int minCost=0;
        while (queue.size() > 1){
         int item1=queue.poll();
         int item2=queue.poll();

         minCost=minCost+item1+item2;
         queue.add(item1+item2);
        }
        return minCost;

    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 3, 2, 6, 5, 7, 12);

        System.out.println("ConnectRopesToMinimiseTheCost " +
                connectRopesToMinimiseTheCost(A));
    }



}
