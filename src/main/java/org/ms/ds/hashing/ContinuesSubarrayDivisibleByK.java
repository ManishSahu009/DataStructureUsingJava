package org.ms.ds.hashing;

import java.util.HashMap;

/*
https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
logic :
prefix sum + map (prefix sum % k , index)
 */
public class ContinuesSubarrayDivisibleByK {

    public static void findsubarray(int []arr, int k){
        int sum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<arr.length ; i++){
            sum=sum+arr[i];
            if(map.containsKey(sum%k)) {
                System.out.println(map.get(sum%k) +" to "+ i);
            }else{
                map.put(sum % k, i);
            }
        }

    }

    public static void main(String[] args) {
        int []arr=new int[]{23,2,4,6,7}; // prefix sum (23,25,29,35,42)
        findsubarray(arr,10);

    }
}
