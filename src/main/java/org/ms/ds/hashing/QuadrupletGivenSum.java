package org.ms.ds.hashing;



import java.util.*;

public class QuadrupletGivenSum {

    private static void find4NumbersHashing(int[] arr, int sum) {
        int n=arr.length;
        Map<Integer, List<SumPair>> map=new HashMap<>();
        for(int i=0 ; i < n-1 ; i++ ){
            for(int j=i+1 ; j < n;j++){
                int val=sum-(arr[i] + arr[j]);
                if(map.containsKey(val)){
                    for(SumPair pair:map.get(val)){
                        int x=pair.p1;
                        int y=pair.p2;
                        if ((x != i && x != j) && (y != i && y != j))
                        {
                            System.out.println("Quadruplet Found ("
                                    + arr[i] + ", " + arr[j] + ", "
                                    + arr[x] + ", " + arr[y] + ")");
                        }
                    }
                }
                map.putIfAbsent(arr[i] + arr[j], new ArrayList<>());
                map.get(arr[i] + arr[j]).add(new SumPair(i, j));
            }
        }

    }

    public static void main(String[] args)
    {
        int arr[] = { 2,7,4,0,9,5,1,3,};
        int sum = 20;

        find4NumbersHashing(arr, sum);

    }


}
class SumPair{
    Integer p1;
    Integer p2;

    public SumPair(Integer p1, Integer p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
