package org.ms.ds.dp.mcm;
/*
https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
input : ababbbabbababa
find minimum no. of partition we have to do to convert this in palindrome
result -> a | babbbab | b  | ababa
output : 3
 */
public class PalindromePartitionRecursion {

    int ppr(String s , int i, int j){
        int min = Integer.MAX_VALUE;
        if(i > j){
            return 0; //size 1 is also invalid
        }
        if(isPalindrom(s,i,j)){
            return 0;
        }
        for(int k=i ; k<j ; k++){
           int temp =  ppr(s,i,k) + ppr(s,k+1,j) + 1;
            if(temp < min){
                min=temp;
            }
        }

        return min;
    }

    boolean isPalindrom(String str, int i, int j){
        if(i == j){
            return true;
        }
        for(int i1=i, j1=j ; i1 < j1 ; i1++, j1-- ){
           if(str.charAt(i1) != str.charAt(j1)){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitionRecursion matrixChainMultiplicationWithRecursion=new PalindromePartitionRecursion();
        String s="ababbbabbababa";

        System.out.println("==>" + matrixChainMultiplicationWithRecursion.ppr(s,0,s.length()-1));

    }
}
