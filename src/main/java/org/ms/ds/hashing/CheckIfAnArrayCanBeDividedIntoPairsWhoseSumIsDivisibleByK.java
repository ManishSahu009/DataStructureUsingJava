package org.ms.ds.hashing;
import java.util.*;

/*
Logic is based on reminder
if we divide the number and reminder is x then there sud be one more number with
k-x reminder
here we can have 3 condition
count of reminder x == count of reminder k-x
count of zero reminder sud be even
count of k/2 sud be even

 */

public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr,k);
    }

    public static void solution(int[] arr, int k){
        // frequency map of remainders
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int rem = val % k;
            if (map.containsKey(rem)) {
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }

//		System.out.println(map);

        for (int val : arr) {
            int rem = val % k;
            if (2 * rem == k) {
                if (map.get(rem) % 2 != 0) {
                    System.out.println("false");
                    return;
                }
            } else if (rem == 0) {
                if (map.get(rem) % 2 != 0) {
                    System.out.println("false");
                    return;
                }
            } else {
                if (map.get(rem) != map.get(k - rem)) {
                    System.out.println("false");
                    return;
                }
            }
        }

        System.out.println("true");
    }
}




