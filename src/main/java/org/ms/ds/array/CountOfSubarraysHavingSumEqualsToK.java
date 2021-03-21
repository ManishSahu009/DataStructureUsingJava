package org.ms.ds.array;

import java.util.*;
/*
prefix sum:
if x is prefix sum at any position thn
going forward if we get x+k as prefix sum than
sum from x position to x+k position will be K

 */
public class CountOfSubarraysHavingSumEqualsToK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
    }

    public static int solution(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int psum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0 ; i < arr.length; i++){
            psum += arr[i];
            if(map.containsKey(psum - target)){
                ans += map.get(psum - target);
            }
            map.put(psum,map.getOrDefault(psum,0) + 1);
        }
        return ans;
    }

}




