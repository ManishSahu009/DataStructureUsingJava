package org.ms.ds.slidingwindow.fixedsize;

import java.util.LinkedList;
import java.util.List;

public class FirstNegativeInEveryKSizeWindow {

    public static void firstNegativeInEveryKSizeWindow(int []arr, int k){
        int j=0, i=0;
        List<Integer> neg =new LinkedList<>();
        List<Integer> ans =new LinkedList<>();
        while(j < arr.length){
            if(arr[j] < 0){
                neg.add(arr[j]);
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k) {
                if (neg.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(neg.get(0));
                    if (neg.get(0) == arr[i]) {
                        neg.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        ans.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int []arr={12, -1, -7, 8, -15, 30, 16, 28} ;
        int k=3;
        firstNegativeInEveryKSizeWindow(arr,k);
    }

}
