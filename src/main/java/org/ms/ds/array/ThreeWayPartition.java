package org.ms.ds.array;
/*
sheet code : LB37
https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
Given an array of size N and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
logic :
take 2 pointer (low and high) and iterate with i
if i is greater than range swap i value with high value and decrement high
if i if lesser than range then swap i value with low value and increment both (i is moving
to find next small element and small element which is pointing to mid value is waiting to
swap with next small value )
else increment only i
 */
public class ThreeWayPartition {

    public static void threeWayPartition(int[] arr, int lowVal, int highVal)
    {

        int  n = arr.length;

        // Initialize ext available positions for
        // smaller (than range) and greater lements
        int start = 0, end = n-1;

        // Traverse elements from left
        for(int i = 0; i <= end;)
        {

            // If current element is smaller than
            // range, put it on next available smaller
            // position.

            if(arr[i] < lowVal)
            {

                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;

            }

            // If current element is greater than
            // range, put it on next available greater
            // position.
            else if(arr[i] > highVal)
            {

                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;

            }

            else
                i++;
        }

    }

    public static void main (String[] args)
    {


        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

        threeWayPartition(arr, 10, 20);

        System.out.println("Modified array ");
        for (int i=0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");

        }
    }

}
