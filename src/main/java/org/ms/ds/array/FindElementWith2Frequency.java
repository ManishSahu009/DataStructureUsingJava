package org.ms.ds.array;

public class FindElementWith2Frequency {

    private static void findele(int[] arr) {
        for(int i=0;i< arr.length;i++){
            int temp=Math.abs(arr[i]);
            if(arr[temp] >=0){
                arr[temp]=-arr[temp];
            }else {
                System.out.println(temp+" ");
            }

        }
    }

    public static void main(String[] args) {
        int []arr=new int[]{2,5,7,9,3,4,6,2,1,6};
        findele(arr);
    }
}
