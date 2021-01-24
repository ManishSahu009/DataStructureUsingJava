package org.ms.ds.backtracking;

public class SudokuSolver {
    public static void display(int board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }

    public static void sudokuSolver(int board[][], int i, int j){
        if(i==board.length){
            display(board);
            return;
        }
        int ni=0;
        int nj=0;
        if(j == board[0].length-1){
           ni=i+1;
           nj=0;
        }else{
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!=0){
            sudokuSolver(board,ni,nj);
        }else{
            for(int po=1;po<=9;po++){
                if(isValid(board,i,j,po)){
                    board[i][j]=po;
                    sudokuSolver(board,ni,nj);
                    board[i][j]=0;
                }
            }
        }

    }

    public static boolean isValid(int board[][], int x, int y, int value){
        for(int j=0; j<board[0].length; j++){
            if(board[x][j]==value){
                return false;
            }
        }
        for(int i=0; i<board.length; i++){
            if(board[i][y]==value){
                return false;
            }
        }
        int smi=x/3*3;
        int smj=y/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j]==value){
                   return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int board[][] = {
                       { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                       { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                       { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                       { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                       { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                       { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                       { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                       { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                       { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
                       };
        display(board);
        System.out.println("================================");
        sudokuSolver(board,0,0);

    }
}
