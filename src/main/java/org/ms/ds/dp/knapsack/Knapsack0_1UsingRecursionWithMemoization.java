package org.ms.ds.dp.knapsack;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
Input:
Let value elements = {60, 100, 120}
Let weight values = {10, 20, 30}
Capacity=50
Output :
220
 */
public class Knapsack0_1UsingRecursionWithMemoization {
    int t[][]=new int[102][1002];

    int knapsack(int weight[], int value[], int capacity, int indexOfElement) {



        if(indexOfElement==0 || capacity==0){
            return 0;
        }

        if(t[indexOfElement][capacity]!=-1){
          return t[indexOfElement][capacity];
        }

        //if item weight is lower than capacity
        if(weight[indexOfElement-1] <= capacity){
            //first section shows item selected and second shows not selected
            return t[indexOfElement][capacity]=Integer.max(value[indexOfElement-1]  +  knapsack(weight,value,capacity-weight[indexOfElement-1],indexOfElement-1),
                                  knapsack(weight,value,capacity,indexOfElement-1));
        }else{
            //if item weight is greater than capacity
            return t[indexOfElement][capacity]=knapsack(weight,value,capacity,indexOfElement-1);
        }
    }

    public static void main(String[] args) {
        Knapsack0_1UsingRecursionWithMemoization knapsack0_1UsingRecursion=new Knapsack0_1UsingRecursionWithMemoization();
        Arrays.stream(knapsack0_1UsingRecursion.t).forEach(a -> Arrays.fill(a,-1));
       int []value=new int[]{60, 100, 120};
       int []weight= new int[]{10,20,30};
       int capacity=50;
        System.out.println("max value within capacity is "+ knapsack0_1UsingRecursion.knapsack(weight,value,capacity,value.length));
    }

}
