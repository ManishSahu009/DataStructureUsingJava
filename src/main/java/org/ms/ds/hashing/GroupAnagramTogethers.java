package org.ms.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramTogethers {


    public static void gatg(String []str){
        HashMap<HashMap<Character, Integer>, List<String>> bmap=new HashMap<>();
        for(String s: str){
            HashMap<Character,Integer> fmap=new HashMap<>();;
            for(Character ch: s.toCharArray()){
                fmap.put(ch, fmap.getOrDefault(ch,0)+1);
            }
            if(bmap.containsKey(fmap)){
                bmap.get(fmap).add(s);
            }else{
                List<String> sl=new ArrayList<>();
                sl.add(s);
                bmap.put(fmap,sl);
            }

        }
        for(Map.Entry<HashMap<Character, Integer>, List<String>> entry: bmap.entrySet()){
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String []str= new String[]{"abc","cbd","ejk", "cba","jek", "bca"};
        gatg(str);
    }
}
