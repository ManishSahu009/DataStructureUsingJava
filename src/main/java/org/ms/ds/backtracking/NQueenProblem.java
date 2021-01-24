package org.ms.ds.backtracking;

import java.util.Scanner;

/*
logic :
number of diagonal 2*n-1
normal diagonal (/) : row+column
reverse diagonal (\) : row - column + (array.length -1)
 */

public class NQueenProblem {

    private static void placeQueen(boolean[][] board, int row,
                                   boolean[] columns, boolean[] ndiag, boolean[] rdiag, String ans) {
        if(row == board.length){
            System.out.println(ans+".");
            return;
        }
        for(int col=0; col<board[0].length;col++){
            if(columns[col] == false &&
               ndiag[row+col] == false &&
               rdiag[row-col+board.length-1] == false){
                board[row][col]=true;
                columns[col] = true;
                ndiag[row+col] = true ;
                rdiag[row-col+board.length-1] = true;
                placeQueen(board,row+1,columns,ndiag,rdiag,ans+row+"-"+col+",");
                board[row][col] = false;
                columns[col] = false;
                ndiag[row+col] = false ;
                rdiag[row-col+board.length-1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter board size: ");
        int n=sc.nextInt();
        boolean[][] board=new boolean[n][n];
        boolean []columns=new boolean[n];
        boolean [] ndiag=new boolean[2*n-1];
        boolean [] rdiag=new boolean[2*n-1];
        placeQueen(board, 0, columns,ndiag,rdiag, "");
    }


}
