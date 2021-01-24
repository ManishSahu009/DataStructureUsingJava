package org.ms.ds.recursion;

import java.util.ArrayList;

/*
https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class StairPath {

    public static ArrayList<String> getStairPath(int noOfStair){
        //positive base case
        if(noOfStair==0){
            ArrayList<String> pbc=new ArrayList<>();
            pbc.add("");
            return pbc;
        }
        //negative base case
        if(noOfStair<0){
            ArrayList<String> nbc=new ArrayList<>();
            return nbc;
        }
        ArrayList<String> path1= getStairPath(noOfStair-1);
        ArrayList<String> path2= getStairPath(noOfStair-2);
        ArrayList<String> path3= getStairPath(noOfStair-3);
        ArrayList<String> consolidatedPath=new ArrayList<>();
        for(String str : path1){
            consolidatedPath.add("1"+str);
        }
        for(String str : path2){
            consolidatedPath.add("2"+str);
        }
        for(String str : path3){
            consolidatedPath.add("3"+str);
        }
        return consolidatedPath;
    }

    public static void main(String[] args) {
        getStairPath(4).forEach(System.out::println);
    }
}
