package org.ms.ds.array;

/*

https://www.youtube.com/watch?v=FYCWlQ2SaTY&list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx&index=6
using swap sort
logic is to move each element at its position (ith element at ith-1 position) if its not there
time/space complexity - O(n)
 */

public class FindAllDuplicateAndMissingFrom1ToN {

    private static void findMissingDuplicate(int[] arr) {
        // int[] arr = { 4,3,6,5,2,4 };
        int i=0;
        while(i < arr.length){
            if(arr[i] != arr[arr[i]-1]){
                //swap
                int temp=arr[i];
                arr[i]=arr[temp-1];
                arr[temp-1]=temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j] != j+1){
                System.out.println("missing "+(j+1));
                System.out.println("duplicate "+arr[j]);
            }
        }

    }
    public static void main (String[] args)
    {
        int[] arr = { 4,3,6,5,2,4,3 };
        findMissingDuplicate(arr);
    }

}
