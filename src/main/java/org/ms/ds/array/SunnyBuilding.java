package org.ms.ds.array;
//https://www.geeksforgeeks.org/number-buildings-facing-sun/

public class SunnyBuilding {

    static int countBuildings(int arr[], int n)
    {
        int count = 1;
        int curr_max = arr[0];
        for (int i=1; i<n; i++)
        {
            if (arr[i] > curr_max)
            {
                count++;
                curr_max=arr[i];
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int arr[] = {7, 4, 8, 2, 9};

        System.out.println(countBuildings(arr, arr.length));

    }
}
