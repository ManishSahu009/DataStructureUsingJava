package org.ms.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllSubarraysWithZeroSum {
    public static void main(String[] args) {
        PrintAllSubarraysWithZeroSum print = new PrintAllSubarraysWithZeroSum();
        Integer[] elements = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        // prefix sum {3, 7, 0, 3, 4, 7, 8, 4, 2, 0}
        print.printZeroSumSubarray(elements);
    }

    void printZeroSumSubarray(Integer[] elements) {
        // here in 2 condition subarray will be zero
        //1. if sum is zero
        //2. if any key(sum) repeates (x(1st occurance), ....,x(2nd occurance)) => index of x+1 to x subarray will have sum as zero
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        insert(map,0,-1); // insert (0, -1) pair into the map to handle the case when
                                   // sub-array with 0 sum starts from index 0
         for (int i = 0; i < elements.length;i++) {
            sum=sum+elements[i];
            if(map.containsKey(sum)){
                List<Integer> list=map.get(sum);
                for(Integer value:list){
                    System.out.println("key(" +sum+") index : "+ (value+1) +" to "+ i);
                }
            }
            insert(map,sum,i);
        }
    }

    void insert(Map<Integer, List<Integer>> map, Integer sum, Integer ele) {
        if (!map.containsKey(sum)) {
            map.put(sum, new ArrayList<Integer>());
        }
        map.get(sum).add(ele);
    }

}
