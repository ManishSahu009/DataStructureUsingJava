package org.ms.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {

    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public void push(int value){
        queue1.add(value);
    }
    public int pop(){
        if(queue1.isEmpty()){
            return -1;
        }
        while (queue1.size() != 1){
            queue2.add(queue1.remove());
        }
        int result=queue1.remove();
        //swapping queue references just to copying the data again in queue1
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
        return result;
    }


}

class StackUsingTwoQueueTest{
    public static void main(String[] args) {
        StackUsingTwoQueue stackUsingTwoQueue=new StackUsingTwoQueue();
        stackUsingTwoQueue.push(12);
        stackUsingTwoQueue.push(9);
        stackUsingTwoQueue.push(20);
        System.out.println(stackUsingTwoQueue.pop());
        System.out.println(stackUsingTwoQueue.pop());
        stackUsingTwoQueue.push(111);
        System.out.println(stackUsingTwoQueue.pop());

    }
}
