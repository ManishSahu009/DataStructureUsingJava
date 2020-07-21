package org.ms.ds.dp.mcm;
/*
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency.
For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
(AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
result : 27000
if we have array with size n then no. of matrix will be n-1
here will have 4 matrix [ Ai -> dim[i-1]Xdim[i] ]

 */
public class MatrixChainMultiplicationWithRecursion {

    int mcm(int []dim , int i, int j){
        int min = Integer.MAX_VALUE;
        if(i == j){
            return 0; //size 1 is also invalid
        }
        for(int k=i ; k<j ; k++){
           int temp =  mcm(dim,i,k) + mcm(dim,k+1,j) + (dim[i-1]*dim[k]*dim[j]);
            if(temp < min){
                min=temp;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MatrixChainMultiplicationWithRecursion matrixChainMultiplicationWithRecursion=new MatrixChainMultiplicationWithRecursion();
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
