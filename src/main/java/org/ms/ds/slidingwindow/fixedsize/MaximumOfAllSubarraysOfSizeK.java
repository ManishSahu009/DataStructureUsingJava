package org.ms.ds.slidingwindow.fixedsize;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MaximumOfAllSubarraysOfSizeK {

    public static void maximumOfAllSubarraysOfSizeK(int []arr, int k){
        int j=0, i=0;
        List<Integer> ans =new LinkedList<>();
        TreeSet<Integer> set =new TreeSet<>();
        while(j < arr.length){
            set.add(arr[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k) {
                ans.add(set.last());
                if(set.last() == arr[i]){
                    set.pollLast();
                }else {
                    set.pollFirst();
                }
                i++;
                j++;
            }
        }
        ans.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int []arr={8, 5, 10, 7, 9, 4, 15, 12, 90, 13} ;
        int k=4;
        maximumOfAllSubarraysOfSizeK(arr,k);
    }

}
