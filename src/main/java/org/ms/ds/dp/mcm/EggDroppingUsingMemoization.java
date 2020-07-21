package org.ms.ds.dp.mcm;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
egg ->3
Floor -> 5
Minimize number of attempt to find threshold floor
output -> 3

 */
public class EggDroppingUsingMemoization {

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
           int temp =  Integer.max(edr(egg-1,k-1),edr(egg,floor-k)) + 1; // Taking max as here they are asking worst case
            if(temp < min){
                min=temp;
            }
        }
        return t[egg][floor]=min;
    }

    public static void main(String[] args) {
        EggDroppingUsingMemoization eggDroppingUsingRecursion=new EggDroppingUsingMemoization();
        Arrays.stream(eggDroppingUsingRecursion.t).forEach(a-> Arrays.fill(a,-1));
        int floor=5;
        int noOfEgg = 3;
        System.out.println("==>" + eggDroppingUsingRecursion.edr(noOfEgg,floor));

    }
}
