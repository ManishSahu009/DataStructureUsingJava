package org.ms.ds.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintSequenceUsing2ThreadsAndExecutorFW {

    public static void main(String[] args) {
        NumberGenerator4 numberGenerator=new NumberGenerator4(20,2);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(new SequenceGeneratorTask4(numberGenerator, 1));
        executorService.submit(new SequenceGeneratorTask4(numberGenerator, 0));
        executorService.shutdown();
    }

}

class SequenceGeneratorTask4 implements Runnable{

    NumberGenerator4 numberGenerator;
    Integer result;

    public SequenceGeneratorTask4(NumberGenerator4 numberGenerator, Integer result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numberGenerator.printSequence(result);
    }
}

class NumberGenerator4 {
    public Integer number=1;
    public Integer totalNumbersInSequence;
    public Integer numberOfThreads;

    public NumberGenerator4(Integer totalNumbersInSequence, Integer numberOfThreads) {
        super();
        this.totalNumbersInSequence = totalNumbersInSequence;
        this.numberOfThreads = numberOfThreads;
    }

    public void printSequence(int result)  {
        synchronized (this){
            while(number <= totalNumbersInSequence-1){
                while(number%numberOfThreads != result) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() +" - "+number++);
                notifyAll();
            }
        }
    }
}


