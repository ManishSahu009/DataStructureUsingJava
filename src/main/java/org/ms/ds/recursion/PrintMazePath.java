package org.ms.ds.recursion;

import java.util.ArrayList;

public class PrintMazePath {

    public static ArrayList<String> getMazePaths(int sourceRow,int sourceCol, int destinationRow, int destinationCol){

        if(sourceCol == destinationCol && sourceRow==destinationRow){
            ArrayList<String> temp=new ArrayList<>();
            temp.add("");
            return temp;

        }

        ArrayList<String> vlist=new ArrayList<>();
        ArrayList<String> hlist=new ArrayList<>();

        if(sourceRow < destinationRow) {
            vlist = getMazePaths(sourceRow + 1, sourceCol, destinationRow, destinationCol);
        }
        if(sourceCol < destinationCol) {
            hlist = getMazePaths(sourceRow, sourceCol + 1, destinationRow, destinationCol);
        }
        ArrayList<String> ans=new ArrayList<>();
        for(String str : vlist){
            ans.add("v"+str);
        }
        for(String str : hlist){
            ans.add("h"+str);
        }
        return ans;

    }

    public static void main(String[] args) {
        getMazePaths(1,1,3,3).forEach(System.out::println);
    }
}
