package org.ms.ds.array;

import java.util.Arrays;

/*
https://www.youtube.com/watch?v=h6_lIwZYHQw
 */
public class CandyDistribution {

    public static int candyDistribution(int []arr){
        int []candy=new int[arr.length];
        candy[0]=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
               candy[i]=candy[i-1]+1;
            }else{
                candy[i]=1;
            }
        }
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                if(candy[i]<=candy[i+1]){
                    candy[i]=candy[i]+1;
                }
            }
        }
        return Arrays.stream(candy).sum();
    }
    public static void main(String[] args) {
        int []arr=new int[]{12,4,3,11,34,34,1,67};
        System.out.println(candyDistribution(arr));
    }
}
