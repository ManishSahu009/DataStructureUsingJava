package org.ms.ds.dp;

public class EditDistanceRecursive {


    //recursion
    public static int editDistDP(String s, String t){
        if(s.length() == 0)
            return t.length();

        if(t.length() == 0)
            return s.length();

        //if char are same
        if(s.charAt(0)  == t.charAt(0))
            return editDistDP(s.substring(1), t.substring(1));
        else{
            int op1 =  editDistDP(s.substring(1), t.substring(1));
            int op2 =  editDistDP(s, t.substring(1));
            int op3 =  editDistDP(s.substring(1), t);

            return 1 + Math.min(op1, Math.min(op2, op3));
        }

    }

    // Driver Code
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistDP(str1, str2));
    }
}
