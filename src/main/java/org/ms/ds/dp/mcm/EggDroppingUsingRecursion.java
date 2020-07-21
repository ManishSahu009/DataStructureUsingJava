package org.ms.ds.dp.mcm;
/*
https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
egg ->3
Floor -> 5
Minimize number of attempt to find threshold floor
output -> 3

 */
public class EggDroppingUsingRecursion {

    int edr(int egg,int floor){
        int min = Integer.MAX_VALUE;
        if(floor == 0 || floor ==1){
            return floor;
        }
        if(egg == 1){
            return floor;
        }
        for(int k=1 ; k<=floor ; k++){
           int temp =  Integer.max(edr(egg-1,k-1),edr(egg,floor-k)) + 1; // Taking max as here they are asking worst case
            if(temp < min){
                min=temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        EggDroppingUsingRecursion eggDroppingUsingRecursion=new EggDroppingUsingRecursion();
        int floor=5;
        int noOfEgg = 3;
        System.out.println("==>" + eggDroppingUsingRecursion.edr(noOfEgg,floor));

    }
}
