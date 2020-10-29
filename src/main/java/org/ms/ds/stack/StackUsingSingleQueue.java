package org.ms.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

    Queue<Integer> queue=new LinkedList<>();

    public void push(int value){
        int size=queue.size();
        queue.add(value);
        for(int i=0;i<size;i++){
            queue.add(queue.poll());
        }
    }
    public int pop(){
        if(queue.isEmpty()){
            return -1;
        }else {
            return queue.poll();
        }
    }


}

class StackUsingSingleQueueTest{
    public static void main(String[] args) {
        StackUsingSingleQueue stackUsingSingleQueue=new StackUsingSingleQueue();
        stackUsingSingleQueue.push(12);
        stackUsingSingleQueue.push(9);
        stackUsingSingleQueue.push(20);
        System.out.println(stackUsingSingleQueue.pop());
        System.out.println(stackUsingSingleQueue.pop());
        stackUsingSingleQueue.push(111);
        System.out.println(stackUsingSingleQueue.pop());

    }
}
