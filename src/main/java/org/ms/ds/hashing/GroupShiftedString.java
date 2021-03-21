package org.ms.ds.hashing;
/*
Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings in a group are shifted versions of each other.
Two string S and T are called shifted if,
S.length = T.length
and
S[i] = T[i] + K for
1 <= i <= S.length  for a constant integer K
For example strings, {acd, dfg, wyz, yab, mop} are shifted versions of each other.
Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};
Output : a x
         acd dfg wyz yab mop
         bdfh moqs
All shifted strings are grouped together.

Logic :
Find ASCII value diff b/w each char of string
put that as key and add actual string in value list

 */


import java.util.*;

public class GroupShiftedString {

    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] array) {

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0 ;i < array.length ;i++) {
            String codedString = generatecode(array[i]);
            if(map.containsKey(codedString)) {
                ArrayList<String> al = map.get(codedString);
                al.add(array[i]);
                map.put(codedString, al);
            }else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(array[i]);
                map.put(codedString, al);
            }
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> al : map.values()) {
            ans.add(al);
        }
        return ans;
    }

    public static String generatecode(String str) {
        String ans = "";
        for(int i = 1; i < str.length() ; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i - 1);
            int diff = ch1 - ch2;
            if(diff < 0) {
                diff += 26;
            }
            ans += 'a' + diff;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
        for (ArrayList<String> lst : shiftedGroup) {
            Collections.sort(lst);
        }
        shiftedGroup.sort(new ListComparator());
        display(shiftedGroup);
    }

    // it is used to make the result unique
    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            String l1str = l1.get(0);
            String l2str = l2.get(0);
            return l1str.compareTo(l2str);

        }
    }

    public static void display(ArrayList<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }

}




