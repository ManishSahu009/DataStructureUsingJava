package org.ms.ds.recursion;
/*
0 -> 0 1
1 -> 1 0
given input n(represent number of iteration) and K ( represent column number)
n=1 -> 0
n=2 -> 0 1 (replace zero with above grammar rule)
n=3 -> 0 1 1 0
n=4 -> 0 1 1 0 1 0 0 1
if given input (n, k ) -> (4, 5)
output -> 1 (5 column value in 4)

Observation :
n=3 -> 0 1 1 0
n=4 -> 0 1 1 0 | 1 0 0 1
for n=4, first half is same as n=3 and second half is just opposite
so value of n will reduce by 1 but value of k will have 2 cases
if k is less than half length of n then no chnage in k
if k is greater than half length of n then k-mid with opposite value

 */
public class KthGrammarRule {

    public static void main(String[] args) {
        int n=4,k=6;
        System.out.println(solve(n,k));
    }

    private static int solve(int n, int k) {
        if(n==1 && k==1){
           return 0;
        }
        int mid=(int) Math.pow(2,n-1)/2;
        if(k <= mid){
            return solve(n-1,k);
        }else{
            return solve(n-1,k-mid)==0?1:0;
        }
    }
}
