package org.ms.ds.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
for any day previous element is  consecutive/smaller or equal
{100,80,60,70,60,75,85} => {1, 1, 1, 2, 1, 4, 6}
here again we have to apply same logic as NGL
store element and its index value in stack
store diff b/w element index and stack element (which is gretaer )
 */

public class StockSPanProblem {

    List<Integer> getSSp(List<Integer> eles){
        List<Integer> temp=new ArrayList<>();
        Stack<SSPPair> stack=new Stack<>();
        for(int i=0;i<eles.size();i++){
            if(stack.empty()){
                temp.add(1);
            }else if(!stack.empty() && eles.get(i) < stack.peek().getNumber()){
                temp.add(i-stack.peek().getIndex());
            }else if(!stack.empty() && eles.get(i) >= stack.peek().getNumber()){
                while(eles.get(i) > stack.peek().getNumber()){
                    stack.pop();
                }
                if(stack.empty()){
                    temp.add(1);
                }else{
                    temp.add(i-stack.peek().getIndex());
                }
            }
            stack.push(new SSPPair(eles.get(i),i));
        }
        return temp;

    }

    public static void main(String[] args) {
        StockSPanProblem stockSPanProblem=new StockSPanProblem();
        List<Integer> sl=new ArrayList<>();
        sl.add(100);
        sl.add(80);
        sl.add(60);
        sl.add(70);
        sl.add(60);
        sl.add(75);
        sl.add(85);
        System.out.println(stockSPanProblem.getSSp(sl));
    }
}

class SSPPair{
    Integer number;
    Integer index;

    public SSPPair(Integer number, Integer index) {
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
