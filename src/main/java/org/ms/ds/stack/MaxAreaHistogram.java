package org.ms.ds.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
{6, 2, 5, 4, 5, 1, 6} => 12 max area rectangle
A building can be expanded in other building only when other building height >= current building height
here we will apply NSL and NSR
1. find NSR - NSL -1 = M , keep it in temp array
2. array[i] = array[i]*M
3. return max(array[])
note : for edge elements we will keep next/prev index(right) as height as in our case for last element 6 we will keep 7 and for  first element 6(left) we will keep -1
*/

public class MaxAreaHistogram {

    Integer getMAH(List<Integer> eles){
        List<Integer> temp=new ArrayList<>();
        List<Integer> nsl=getNSL(eles);
        nsl.forEach(item-> System.out.print(item +" "));
        System.out.println();
        List<Integer> nsr=getNSR(eles);
        nsr.forEach(item-> System.out.print(item +" "));
        System.out.println();
        for(int i=0;i<eles.size();i++){
            temp.add(i,(eles.get(i))*(nsr.get(i)-nsl.get(i)-1));
        }

        return Collections.max(temp);

    }

    List<Integer> getNSL(List<Integer> eles){
        List<Integer> temp=new ArrayList<>();
        Stack<MAHPair> stack=new Stack<>();
        for(int item=0;item< eles.size();item++){
            if(stack.empty()){
                temp.add(-1);
            }else if(stack.size() > 0 && stack.peek().getNumber() < eles.get(item)){
                temp.add(stack.peek().getIndex());
            }else if(stack.size() > 0 && stack.peek().getNumber() >= eles.get(item)){
                while(stack.size() > 0 && stack.peek().getNumber() >= eles.get(item)){
                    stack.pop();
                }
                if(stack.size() ==0){
                    temp.add(-1);
                }else{
                    temp.add(stack.peek().getIndex());
                }
            }
            stack.push(new MAHPair(eles.get(item),item));
        }
        return temp;

    }

    List<Integer> getNSR(List<Integer> eles){
        List<Integer> temp=new ArrayList<>();
        Stack<MAHPair> stack=new Stack<>();
        for(int item=eles.size()-1;item>=0;item--){
            if(stack.empty()){
                temp.add(eles.size());
            }else if(stack.size() > 0 && stack.peek().getNumber() < eles.get(item)){
                temp.add(stack.peek().getIndex());
            }else if(stack.size() > 0 && stack.peek().getNumber() >= eles.get(item)){
                while(stack.size() > 0 && stack.peek().getNumber() >= eles.get(item)){
                    stack.pop();
                }
                if(stack.size() ==0){
                    temp.add(eles.size());
                }else{
                    temp.add(stack.peek().getIndex());
                }
            }
            stack.push(new MAHPair(eles.get(item),item));
        }
        Collections.reverse(temp);
        return temp;

    }

    public static void main(String[] args) {
        MaxAreaHistogram maxAreaHistogram=new MaxAreaHistogram();
        List<Integer> sl=new ArrayList<>();
        sl.add(6);
        sl.add(2);
        sl.add(5);
        sl.add(4);
        sl.add(5);
        sl.add(1);
        sl.add(6);
        System.out.println("MAH : "+maxAreaHistogram.getMAH(sl));
    }
}

class MAHPair{
    Integer number;
    Integer index;

    public MAHPair(Integer number, Integer index) {
        this.number = number;
        this.index = index;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
