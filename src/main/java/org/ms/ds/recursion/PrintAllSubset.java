package org.ms.ds.recursion;

public class PrintAllSubset {

    static void printAllSubset(String input, String output) {
      if("".equals(input)){
          System.out.println(output);
          return;
      }
      String output1=output;
      String output2=output;
      output2=output2+input.charAt(0);
      input=input.substring(1);
      printAllSubset(input,output1);
      printAllSubset(input,output2);

    }

    public static void main(String[] args) {
        String input = "manish";
        String output = "";
        printAllSubset(input, output);
    }
}
