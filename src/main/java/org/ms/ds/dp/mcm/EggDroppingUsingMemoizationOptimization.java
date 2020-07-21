package org.ms.ds.dp.mcm;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
egg ->3
Floor -> 5
Minimize number of attempt to find threshold floor
output -> 3

 */
public class EggDroppingUsingMemoizationOptimization {

    int [][]t=new int[1001][1001];
    int edr(int egg,int floor){
        int min = Integer.MAX_VALUE;
        if(floor == 0 || floor ==1){
            return floor;
        }
        if(egg == 1){
            return floor;
        }
        if(t[egg][floor] != -1){
            return t[egg][floor];
        }
        for(int k=1 ; k<=floor ; k++){
           int low;
           int high;
           if(t[egg-1][k-1] !=-1){
               low=t[egg-1][k-1];
           }else{
               low=edr(egg-1,k-1);
           }

            if(t[egg][floor-k] !=-1){
                high=t[egg][floor-k];
            }else{
                high=edr(egg,floor-k);
            }

           int temp =  Integer.max(low,high) + 1; // Taking max as here they are asking worst case
            if(temp < min){
                min=temp;
            }
        }
        return t[egg][floor]=min;
    }

    public static void main(String[] args) {
        EggDroppingUsingMemoizationOptimization eggDroppingUsingRecursion=new EggDroppingUsingMemoizationOptimization();
        Arrays.stream(eggDroppingUsingRecursion.t).forEach(a-> Arrays.fill(a,-1));
        int floor=5;
        int noOfEgg = 3;
        System.out.println("==>" + eggDroppingUsingRecursion.edr(noOfEgg,floor));

    }
}
