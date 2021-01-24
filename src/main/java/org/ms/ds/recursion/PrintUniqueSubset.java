package org.ms.ds.recursion;

import java.util.HashSet;
import java.util.Set;

/*
AKA : print power set/print subsequence
substring : continues part of string
subsequence : order maintain but can be non continues
subset : no order and non continues

All substring are subsequence but not vise versa
All subsequence are subset but not vise versa
 */
public class PrintUniqueSubset {

    static void printAllSubset(String input, String output , Set<String> set) {
      if("".equals(input)){
          System.out.println(output);
          return;
      }
      String output1=output;
      String output2=output;
      output2=output2+input.charAt(0);
      input=input.substring(1);
      printAllSubset(input,output1,set);
      printAllSubset(input,output2,set);

    }

    public static void main(String[] args) {
        String input = "manish";
        String output = "";
        Set<String> set=new HashSet<>();
        printAllSubset(input, output,set);
    }
}
