package org.ms.ds.dp.knapsack;

import java.util.Arrays;

/*
count all the subset S whose diff is equal to the given no. DIFF
suppose we are dividing  set into 2 subset called S1 and S2
sum (S1) - sum (S2) = DIFF
sum (S1) + sum (S2) = sum(S)
--------------------------------
2 sum(S1) = DIFF + sum(S)
sum(S1) = (DIFF + sum(S)) / 2 = X
now with this we have find the no. of subset with given sum


 */
public class CountNoOfSubsetWithGivenDiff {
    int cnosswgd(int number[], int diff) {

       CountOfSubsetSum countOfSubsetSum= new CountOfSubsetSum();
       int sum= (diff + Arrays.stream(number).sum())/2;
       return countOfSubsetSum.coss(number,sum);
    }

    public static void main(String[] args) {
        CountNoOfSubsetWithGivenDiff countNoOfSubsetWithGivenDiff=new CountNoOfSubsetWithGivenDiff();
        int []number= new int[]{1, 1, 2, 3};
        int diff=1;
        System.out.println("max value within capacity is "+ countNoOfSubsetWithGivenDiff.cnosswgd(number,diff));
    }

}
