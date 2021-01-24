package org.ms.ds.recursion;

public class UniqueCharStringConcat {

    public static int uniqueCharStringConcat(String []str,int index, String answer){
        int op1=0,op2=0;
        if(index == str.length){
            int []freq=new int[26];
            for(char ch:answer.toCharArray()){
                if(freq[ch-'a'] == 1){
                    return 0;
                }
                freq[ch-'a']++;
            }
            return answer.length();
        }
        if(answer.length()+str[index].length() <=26 ){
             op1=uniqueCharStringConcat(str,index+1,answer+str[index]);
        }
         op2=uniqueCharStringConcat(str,index+1,answer);
        return Math.max(op1,op2);
    }

    public static void main(String[] args) {
        String []str=new String[]{"abc","def","dfc","ell","xyz"};
        System.out.println("Unique char concat length "+ uniqueCharStringConcat(str,0,""));
    }
}
