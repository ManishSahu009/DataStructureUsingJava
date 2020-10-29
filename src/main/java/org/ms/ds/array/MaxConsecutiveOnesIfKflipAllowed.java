package org.ms.ds.array;

public class MaxConsecutiveOnesIfKflipAllowed {
    public static int countConsecutiveOnes(int[] arr, int k) {

        int maxConsecutiveOne = 0;
        int start = 0;
        int zeroCount = 0;

        for(int end = 0; end < arr.length; end++) {

            if(arr[end] == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {

                if(arr[start] == 0) {
                    zeroCount--;
                }

                start++;
            }

            maxConsecutiveOne = Math.max(maxConsecutiveOne, end-start+1);
        }

        return maxConsecutiveOne;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println(countConsecutiveOnes(arr, k));
    }
}
