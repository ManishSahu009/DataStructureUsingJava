package org.ms.ds.dp.unboundedknapsack;

/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
For example, if length of the rod is 8 and the values of different pieces are given as following,
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20


 */


public class RodCutting {

    int rc(int price[], int lengths[], int N, int indexOfElement) {
        int t[][]=new int[indexOfElement+1][N+1];

        if(indexOfElement==0 || N==0){
            return 0;
        }
        for(int i=0;i<indexOfElement+1;i++){
            for(int j=0;j<N+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1;i<indexOfElement+1;i++){
            for(int j=1;j<N+1;j++){
                //if item weight is lower than capacity
                if(lengths[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] = Integer.max(price[i-1]  +  t[i][j-lengths[i-1]],
                            t[i-1][j]);
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[indexOfElement][N];

    }

    public static void main(String[] args) {
        RodCutting rodCutting=new RodCutting();
        int []lengths =new int[]{1  , 2 ,  3  , 4 ,  5  , 6  , 7  , 8 }; //weight
        int []price  = new int[]{ 1 ,  5  , 8  , 9 ,  10  , 17  , 17  , 20 }; //price
        int N=8;
        System.out.println("max value within capacity is "+ rodCutting.rc(price,lengths,N,lengths.length));
    }

}
