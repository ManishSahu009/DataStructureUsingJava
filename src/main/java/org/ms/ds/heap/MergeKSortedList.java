package org.ms.ds.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
https://www.techiedelight.com/merge-m-sorted-lists-variable-length/
 */

public class MergeKSortedList {

    public static void printSorted(List<List<Integer>> list)
    {
        PriorityQueue<PairKLM> queue = new PriorityQueue();

        for(int i=0;i < list.size();i++){
            if(list.get(i).size() >= 1){
                queue.add(new PairKLM(list.get(i).get(0),i,0));
            }
        }
        while(!queue.isEmpty()){
            PairKLM min=queue.poll();
            System.out.println(min.value);

            //check if element present
            if(min.index + 1 < list.get(min.listNum).size()){
                 min.index=min.index+1;
                 min.value=list.get(min.listNum).get(min.index);
                 queue.add(min);
            }

        }


    }

    public static void main(String[] args)
    {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(10, 20, 30, 40),
                Arrays.asList(15, 25, 35),
                Arrays.asList(27, 29, 37, 48, 93),
                Arrays.asList(32, 33)
        );

        printSorted(list);
    }

}

class PairKLM implements Comparable<PairKLM>
{
    public Integer value;
    public Integer listNum;
    public Integer index;

    // Constructor
    public PairKLM(Integer value, Integer listNum, Integer index) {
        this.value = value;
        this.listNum = listNum;
        this.index = index;
    }


    @Override
    public int compareTo(PairKLM o) {
        return this.value.compareTo(o.value);
    }
}
