package org.ms.ds.recursion;

public class KnightTour {

    public static void solveKT(int [][]arr, int row,int col, int moveNumber){

        if(row <0 || col <0 || row>=arr.length || col >= arr.length || arr[row][col]>0){
           return;
        }else if (moveNumber == arr.length*arr.length){
            arr[row][col]=moveNumber;
            displayBoard(arr);
            System.out.println("============================");
            arr[row][col]=0;
            return;
        }
        arr[row][col]=moveNumber;
        solveKT(arr, row-2, col+1,moveNumber+1);
        solveKT(arr, row-1, col+2,moveNumber+1);
        solveKT(arr, row+1, col+2,moveNumber+1);
        solveKT(arr, row+2, col+1,moveNumber+1);
        solveKT(arr, row+2, col-1,moveNumber+1);
        solveKT(arr, row+1, col-2,moveNumber+1);
        solveKT(arr, row-1, col-2,moveNumber+1);
        solveKT(arr, row-2, col-1,moveNumber+1);
        arr[row][col]=0;
    }

    public static void displayBoard(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print( arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][]arr=new int[8][8];
        int row=0;
        int col=4;
        solveKT(arr, row,col,1);
    }
}
