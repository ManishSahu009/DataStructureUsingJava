package org.ms.ds.heap;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    private static void frequencySort(List<Integer> list, int k) {
        PriorityQueue<PairEF> queue=new PriorityQueue<>(Comparator.reverseOrder());
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
        });
        list.clear();
        queue.stream().map(e -> addElementNTimes(list,e.ele,e.freq)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static List<Integer> addElementNTimes(List<Integer> list, int ele, int noOfTimes){
        for(int i=0;i<noOfTimes;i++){
            list.add(ele);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,3,2,2,4));
        int k=2;
        frequencySort(list, k);
    }
}
