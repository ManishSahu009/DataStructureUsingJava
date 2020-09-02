package org.ms.ds.heap;

import java.util.*;

public class TopKFrequentNumber {

    private static void topKFrequentNumber(List<Integer> list, int k) {
        PriorityQueue<PairEF> queue=new PriorityQueue<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer i:list){
            if(map.containsKey(i)){
               map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        map.forEach((key,value) ->{
            queue.add(new PairEF(key,value));
            if(queue.size() > k){
                queue.poll();
            }
        });

        queue.forEach(e -> System.out.println(e.ele +" - "+e.freq));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,3,2,2,4);
        int k=2;
        topKFrequentNumber(list, k);
    }

}

class PairEF implements  Comparable<PairEF>{

    Integer ele;
    Integer freq;

    public PairEF(Integer ele, Integer freq) {
        this.ele = ele;
        this.freq = freq;
    }

    @Override
    public int compareTo(PairEF o) {
        return this.freq.compareTo(o.freq);
    }
}

