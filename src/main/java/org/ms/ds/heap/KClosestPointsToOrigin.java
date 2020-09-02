package org.ms.ds.heap;

import java.util.*;

/*
distance b/w 2 point (x1,y1) and (x2,y2)
formula  √(x1−x2)^2+(y1−y2)^2
and from origin (0,0) to point (x1,y1)
formula  √ x1^2 + y1^2

 */

public class KClosestPointsToOrigin {

    private static void kClosestPointsToOrigin(int[][] list, int k) {
        PriorityQueue<PairOD> queue=new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<list.length;i++){
                queue.add(new PairOD(Math.sqrt(Math.pow(list[i][0],2) + Math.pow(list[i][1],2) ),new Integer[]{list[i][0],list[i][1]}));
                if(queue.size() > k){
                    System.out.println("polling out ("+queue.peek().index[0]+","+ queue.peek().index[1]+") is "+ queue.peek().distance);
                    queue.poll();
                }
        }
        queue.forEach(e -> System.out.println("Distance from origin for point ("+e.index[0]+","+ e.index[1]+") is "+ e.distance));
    }

    public static void main(String[] args) {
        int[][] list = new int[][]{{1,3},{-2,2},{5,8},{0,1}};
        int k=2;
        kClosestPointsToOrigin(list, k);
    }

}

class PairOD implements  Comparable<PairOD>{

    Double distance;
    Integer []index;

    public PairOD(Double diff, Integer[] index) {
        this.distance = diff;
        this.index = index;
    }

    @Override
    public int compareTo(PairOD o) {
        return this.distance.compareTo(o.distance);
    }
}
