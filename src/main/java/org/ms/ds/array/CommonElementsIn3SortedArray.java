package org.ms.ds.array;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsIn3SortedArray {


    public static List<Integer> findCommon(int []arr1,int []arr2, int []arr3){
        List<Integer> list=new ArrayList<>();
        int i=0 , j=0, k=0;
        while(i < arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i] == arr2[j] && arr2[j]== arr3[k]){
                list.add(arr1[i]);
                i++;
                j++;
                k++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr3[k]){
                j++;
            }else if(arr3[k] < arr1[i]){
                k++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int []arr1=new int[]{2,4,8};
        int []arr2=new int[]{2,3,4,8,10,16};
        int []arr3=new int[]{2,8,14,40};
        List<Integer> ans=findCommon(arr1, arr2, arr3);
        ans.forEach(System.out::println);

    }
}
