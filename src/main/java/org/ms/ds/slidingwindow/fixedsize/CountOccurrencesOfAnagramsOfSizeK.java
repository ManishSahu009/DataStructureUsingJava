package org.ms.ds.slidingwindow.fixedsize;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagramsOfSizeK {

    public static void countOccurrencesOfAnagramsOfSizeK(String s, String a){
        int j=0, i=0 , count, answer=0 , k=a.length();
        Map<Character, Integer> countMap=new HashMap<>();
        for(Character ch:a.toCharArray()){
            if(countMap.containsKey(ch)){
                countMap.put(ch,countMap.get(ch)+1);
            }else{
                countMap.put(ch,1);
            }
        }
        count=countMap.size();

        while(j < s.length()){
            Character c=s.charAt(j);
            if(countMap.containsKey(c)){
                countMap.put(c,countMap.get(c)-1);
                if(countMap.get(c) == 0){
                    count--;
                }
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
               if(count==0){
                   answer++;
                   System.out.println(" String "+ s.substring(i,j+1));
               }
               if(countMap.containsKey(s.charAt(i))){
                       countMap.put(s.charAt(i),countMap.get(s.charAt(i))+1);
                       if(countMap.get(s.charAt(i)) == 1){
                           count++;
                       }
               }
                i++;
                j++;
            }
        }
        System.out.println("count: " + answer);
    }

    public static void main(String[] args) {
        String s="forxxorfxdofr";
        String a="for";
        countOccurrencesOfAnagramsOfSizeK(s,a);
    }

}
