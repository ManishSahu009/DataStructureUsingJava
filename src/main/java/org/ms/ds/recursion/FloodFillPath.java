package org.ms.ds.recursion;
/*
https://www.youtube.com/watch?v=R1URUB6_y2k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=47

 */
public class FloodFillPath {

    public static void floodFill(int [][]arr, int row, int col, String ans, boolean[][]visited){

        if(row<0 || col<0 || row==arr.length || col==arr[0].length || arr[row][col]==1 || visited[row][col]==true){
            return;
        }
        if(row == arr.length-1 && col==arr[0].length-1){
            System.out.println(ans);
            return;
        }

        visited[row][col]=true;
        floodFill(arr, row-1, col, ans+"T",visited);
        floodFill(arr, row, col-1, ans+"L",visited);
        floodFill(arr, row+1, col, ans+"D",visited);
        floodFill(arr, row, col+1, ans+"R",visited);

    }

    public static void main(String[] args) {
        int [][]arr=new int[][]{
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,1,1},
                {1,0,0,0,0,0,0}
        };
        boolean [][]visited=new boolean[6][7];
        floodFill(arr,0,0,"",visited);


    }
}
