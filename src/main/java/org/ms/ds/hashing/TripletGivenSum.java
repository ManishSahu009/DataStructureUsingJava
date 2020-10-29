package org.ms.ds.hashing;

/*
https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TripletGivenSum {

    private static void find3NumbersHashing(int[] arr, int sum) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0 ; i< arr.length-2 ;i++){
            Set<Integer> set=new HashSet<>();
            int currentSum=sum-arr[i];
            for(int j=i+1 ; j<arr.length ;j++){
                if(set.contains(currentSum - arr[j])){
                    System.out.println("Triplet : (" + arr[i] +", "+arr[j]+", "+(currentSum-arr[j])+")");
                }
                set.add(arr[j]);
            }

        }
    }

    public static void main(String[] args)
    {
        int arr[] = { 2,7,4,0,9,5,1,3,};
        int sum = 6;

        find3NumbersHashing(arr, sum);

    }


}
