package org.ms.ds.array;

/*
https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/

 */
public class WordDistance {

    public static int wordDistance(String []str, String word1, String word2){
        int w1c=-1;
        int w2c=-1;
        int min=str.length;
        for(int i=0;i< str.length;i++){
            if(word1.equalsIgnoreCase(str[i])){
               w1c=i;
            }
            if(word2.equalsIgnoreCase(str[i])){
                w2c=i;
            }
            if(w1c!=-1 && w2c!=-1){
                min=Math.min(min,Math.abs(w1c-w2c));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String []str={"blue", "red", "yellow", "green","blue","white"};
        System.out.println(wordDistance(str,"green","blue"));
    }
}
