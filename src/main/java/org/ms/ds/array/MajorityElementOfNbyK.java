package org.ms.ds.array;

/*
https://www.youtube.com/watch?v=cIgDFIoA_s0
https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/

logic :
create array of size k-1
keep increasing count if same element comes
decrease all element counts if not present in array
 */

import java.util.Arrays;

public class MajorityElementOfNbyK {

    static class ElementCount{
        Integer ele;
        Integer count;

        @Override
        public String toString() {
            return "ElementCount{" +
                    "ele=" + ele +
                    ", count=" + count +
                    '}';
        }
    }

    public static void findMajorityOfNbyK(int []arr, int k){
        ElementCount []karray=new ElementCount[k-1];
        for(int i=0 ; i<k-1 ; i++){
            karray[i]=new ElementCount();
            karray[i].count=0;
        }
        for(Integer i : arr){
            boolean ifMatch=false;
            for(ElementCount e : karray){
                if(e.ele == null){
                    e.ele=i;
                    e.count=e.count+1;
                    ifMatch=true;
                    break;
                }else if(e.ele == i){
                    e.count= e.count+1;
                    ifMatch=true;
                    break;
                }
            }
            if(!ifMatch) {
                for (ElementCount e : karray) {
                    if(e.count>0){
                        e.count= e.count-1;
                        if(e.count == 0){
                            e.ele=null;
                        }
                    }
                }
            }
        }
        Arrays.stream(karray).filter(e -> e.count >=k).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int []arr=new int[] {1,1,2,3,4,2,1,1,1,2,2,2};
        int k=3;
        findMajorityOfNbyK(arr , k);

    }
}
