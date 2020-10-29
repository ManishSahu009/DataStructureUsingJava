package org.ms.ds.string;

public class PrintAllPermutationOfString {

    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                //swapping the value to generate new string
                str = swap(str,l,i);
                permute(str, l+1, r); // fixing one char of string
                //reverting the swapping done in first step to perform next
                str = swap(str,l,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        PrintAllPermutationOfString permutation = new PrintAllPermutationOfString();
        permutation.permute(str, 0, n-1);
    }
}
