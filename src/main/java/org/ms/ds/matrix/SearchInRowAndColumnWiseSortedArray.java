package org.ms.ds.matrix;

public class SearchInRowAndColumnWiseSortedArray {

    private static void searchInRowAndColumnWiseSortedArray(int[][] arr, int key) {
        //arr.length -> row && arr[0].length -> column
        int row=0;
        int column=arr[0].length-1; //end column
        while(row>=0 && row<arr.length && column>=0 && column<arr[0].length){
            if(arr[row][column] == key){
                System.out.println(row +" "+ column);
                break;
            }else if(arr[row][column] > key){
                column--;
            }else if(arr[row][column] < key){
                row++;
            }
        }

    }

    public static void main(String[] args) {
        int [][]arr={{10 , 20 , 30 , 40},
                     {15 , 25 , 35 , 45},
                     {27 , 29 , 37 , 48},
                     {32 , 33 , 39 , 50}};
        int key=29;
        searchInRowAndColumnWiseSortedArray(arr,key);
    }


}
