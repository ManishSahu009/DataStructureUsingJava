package org.ms.ds.hashing;

import java.util.HashMap;

public class FindPairABequalCD {
    
    static class Pair{
        int first,second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean findPairs(int arr[])
    {

        HashMap<Integer,Pair> map = new HashMap<Integer,Pair>();
        int n=arr.length;

        for (int i=0; i<n; ++i)
        {
            for (int j=i+1; j<n; ++j)
            {
                int sum = arr[i]+arr[j];
                if (!map.containsKey(sum))
                    map.put(sum,new Pair(i,j));

                else
                {

                    Pair p = map.get(sum);
                    System.out.println("("+arr[p.first]+", "+arr[p.second]+
                            ") and ("+arr[i]+", "+arr[j]+")");
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String args[])
    {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        findPairs(arr);
    }

    
}
