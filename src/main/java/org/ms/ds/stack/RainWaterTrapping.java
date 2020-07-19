package org.ms.ds.stack;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/trapping-rain-water/
Input: arr[]   = {3, 0, 2, 0, 4}
Output: 7
Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
for each element
1. find max in left subarray and right subarray
2. then apply this formula
   water[i] = min(MaxL,MaxR) - array[i]
3. sum water[i]
 */
public class RainWaterTrapping {

    Integer getRWT(Integer[] a) {
        Integer []maxL=new Integer[a.length];
        Integer []maxR=new Integer[a.length];
        Integer []water=new Integer[a.length];
        Arrays.fill(maxL,0);
        Arrays.fill(maxR,0);
        maxL[0]=a[0];
        for(Integer i=1;i<a.length;i++){
           maxL[i]=Integer.max(maxL[i-1],a[i]);
        }
        maxR[a.length-1]=a[a.length-1];
        for(Integer i=a.length-2;i>=0;i--){
            maxR[i]=Integer.max(maxR[i+1],a[i]);
        }
        for(Integer i=0;i<a.length;i++){
            water[i]=Integer.min(maxL[i],maxR[i])-a[i];
        }
        return Arrays.stream(water).mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        RainWaterTrapping rainWaterTrapping = new RainWaterTrapping();
        Integer[] test = new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("RainWaterTrapping => " +rainWaterTrapping.getRWT(test));
    }

}
