package org.ms.ds.array;

import java.util.Arrays;

/*
time complexity : n
space complexity : 1
maintain non zero sequence also
 */
public class MoveZero {


    public static void movezero(int []arr){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }

    }
    public static void main(String[] args) {
        int []arr=new int[]{5,6,0,4,3,0,7,0,1,9};
        movezero(arr);
        System.out.println(Arrays.toString(arr));
    }
}
