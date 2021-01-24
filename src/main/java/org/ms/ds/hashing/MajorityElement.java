package org.ms.ds.hashing;

/*
https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] A)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // return the element if its count is more than n/2
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue() > A.length/2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityElementBoyerMoore1_2(int[] A)
    {
        // m stores majority element if present
        int element = -1;

        // initialize counter i with 0
        int count = 0;

        // do for each element A[j] of the array
        for (int j = 0; j < A.length; j++)
        {
            // if the counter i becomes 0
            if (count == 0)
            {
                // set the current candidate to A[j]
                element = A[j];

                // reset the counter to 1
                count = 1;
            }

            // else increment the counter if A[j] is current candidate
            else if (element == A[j]) {
                count++;
            }
            // else decrement the counter if A[j] is not current candidate
            else {
                count--;
            }
        }
        return element;
    }

    public static List<Integer> majorityElementBoyerMoore1_3(int[] array)
    {
        // m stores majority element if present
        int element1 = 0, element2=0, count1=0, count2=0;
        for(int a:array){
            if(a == element1){
                count1++;
            }else if(a== element2){
                count2++;
            }else if(element1==0){
                element1=a;
                count1++;
            }else if(element2==0){
                element2=a;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int a:array){
            if(a == element1){
                count1++;
            }
            if(a== element2){
                count2++;
            }
        }

        List<Integer> list=new ArrayList<>();
        if(count1 >= array.length/3){
            list.add(element1);
        }
        if(count2 >= array.length/3){
            list.add(element2);
        }

        return list;
    }


    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        int res = majorityElementBoyerMoore1_2(arr);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }

        List<Integer> list=majorityElementBoyerMoore1_3(arr);
        System.out.printf("Majority element for 1/3" );
        list.forEach(System.out::println);
    }
}

