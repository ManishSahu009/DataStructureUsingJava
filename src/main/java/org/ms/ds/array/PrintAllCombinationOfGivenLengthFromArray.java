package org.ms.ds.array;

/*
https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class PrintAllCombinationOfGivenLengthFromArray {

    /*
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    i ---> current index in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed
    */
    static void combinationUtil(int arr[], int size, int r, int indexOfDataArray,
                                int data[], int indexOfSourceArray)
    {

        if(indexOfDataArray == r){
            for (int j=0; j < r; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("");
            return;
        }
        if(indexOfSourceArray >= size){
           return;
        }
        data[indexOfDataArray] =arr[indexOfSourceArray];
        combinationUtil(arr,size,r,indexOfDataArray+1,data,indexOfSourceArray+1);
        combinationUtil(arr, size,r,indexOfDataArray,data,indexOfSourceArray+1);
    }

    static void printCombination(int arr[], int n, int r)
    {
        int data[]=new int[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}
