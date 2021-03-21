package org.ms.ds.array;

import java.util.Arrays;
/*

 */
public class MergeTwoSortedArrayWithoutExtraSpace {

    public static void mergeArray(int []arr1, int []arr2){
        for(int i=0, j=0;i<arr1.length;){
            if(arr1[i] > arr2[j]){
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
            }else{
                i++;
            }
            int k=j;
            while(k+1 < arr2.length && arr2[k] > arr2[k+1]){
                int temp=arr2[k];
                arr2[k]=arr2[k+1];
                arr2[k+1]=temp;
                k++;
            }
        }
        Arrays.stream(arr1).forEach(System.out::println);
        Arrays.stream(arr2).forEach(System.out::println);
    }

    public static void main(String[] args) {
    int []arr1={2,6,9,16,19,33};
    int []arr2={3, 7, 11, 13};
    mergeArray(arr1,arr2);
    }
}
