package org.ms.ds.dp.knapsack;

/*
Input:
Let value elements = {60, 100, 120}
Let weight values = {10, 20, 30}
Capacity=50

we will be creating a matrix of index(row) and weight(column)


 */
public class Knapsack0_1UsingTopdown {

    int knapsack(int weight[], int value[], int capacity, int indexOfElement) {
        int t[][]=new int[indexOfElement+1][capacity+1];
        if(indexOfElement==0 || capacity==0){
            return 0;
        }
        for(int i=0;i<indexOfElement+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1;i<indexOfElement+1;i++){
            for(int j=1;j<capacity+1;j++){
                //if item weight is lower than capacity
                if(weight[i-1] <= j){
                    //first section shows item selected and second shows not selected
                    t[i][j] = Integer.max(value[i-1]  +  t[i-1][j-weight[i-1]],
                                                            t[i-1][j]);
                }else{
                    //if item weight is greater than capacity
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[indexOfElement][capacity];

    }

    public static void main(String[] args) {
        Knapsack0_1UsingTopdown knapsack0_1UsingTopdown=new Knapsack0_1UsingTopdown();
        int []value=new int[]{60, 100, 120};
        int []weight= new int[]{10,20,30};
        int capacity=50;
        System.out.println("max value within capacity is "+ knapsack0_1UsingTopdown.knapsack(weight,value,capacity,value.length));
    }

}
