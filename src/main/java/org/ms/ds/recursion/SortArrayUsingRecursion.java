package org.ms.ds.recursion;


import java.util.ArrayList;
import java.util.List;

public class SortArrayUsingRecursion {

    public static void sort(List<Integer> temp ){
        if(temp.size() == 1)
            return;
        int tempVar=temp.remove(temp.size()-1);
        sort(temp);
        insert(temp,tempVar);
    }

    static void insert(List<Integer> temp,Integer tempvar){
        if(temp.size() == 0 || temp.get(temp.size()-1) <= tempvar){
            temp.add(tempvar);
            return;
        }
        int tempVar1= temp.remove(temp.size()-1);
        insert(temp,tempvar);
        temp.add(tempVar1);
    }

    public static void main(String[] args) {
       List<Integer> eles=new ArrayList<>();
        eles.add(33);
        eles.add(3);
        eles.add(10);
        eles.add(30);
        eles.add(15);
        eles.add(9);
        eles.add(34);
        eles.add(42);
        sort(eles);
        eles.forEach(e-> System.out.println(e+" "));
    }


}
