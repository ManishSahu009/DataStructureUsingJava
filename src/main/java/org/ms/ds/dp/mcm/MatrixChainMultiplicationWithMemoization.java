package org.ms.ds.dp.mcm;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

 */
public class MatrixChainMultiplicationWithMemoization {

    int [][]t=new int[1001][1001];

    int mcm(int []dim , int i, int j){
        int min = Integer.MAX_VALUE;
        if(i == j){
            return 0; //size 1 is also invalid
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        for(int k=i ; k<j ; k++){
            int temp =  mcm(dim,i,k) + mcm(dim,k+1,j) + (dim[i-1]*dim[k]*dim[j]);
            if(temp < min){
                min=temp;
            }
        }

        return t[i][j]=min;
    }

    public static void main(String[] args) {
        MatrixChainMultiplicationWithMemoization matrixChainMultiplicationWithRecursion=new MatrixChainMultiplicationWithMemoization();
        Arrays.stream(matrixChainMultiplicationWithRecursion.t).forEach(a-> Arrays.fill(a,-1));
        int []array={10,30,5,60}; // here will have 4 matrix [ Ai -> dim[i-1]Xdim[i] ]
        /*
        int []array={40,20,30,10,30};
        M1 -> 40X20
        M2 -> 20X30
        M3 -> 30X10
        M4 -> 10X30
         */
        System.out.println("==>" + matrixChainMultiplicationWithRecursion.mcm(array,1,array.length-1));

    }
}
