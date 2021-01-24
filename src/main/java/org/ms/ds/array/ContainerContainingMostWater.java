package org.ms.ds.array;

public class ContainerContainingMostWater {

    public static int containerContainingMostWater(int []arr){
        int ans=0;
        int l=0,r=arr.length-1;
        while(l<r){
            ans=Math.max(ans,Math.min(arr[l],arr[r])*(r-l));
            if(arr[l] < arr[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr=new int[]{1,8,4,6,2,5,9,3};
        System.out.println(containerContainingMostWater(arr));
    }
}
