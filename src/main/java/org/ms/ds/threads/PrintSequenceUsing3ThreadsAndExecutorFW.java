package org.ms.ds.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintSequenceUsing3ThreadsAndExecutorFW {

    public static void main(String[] args) {
        NumberGenerator3 numberGenerator=new NumberGenerator3(20,3);
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.submit(new SequenceGeneratorTask3(numberGenerator, 1));
        executorService.submit(new SequenceGeneratorTask3(numberGenerator, 2));
        executorService.submit(new SequenceGeneratorTask3(numberGenerator, 0));
        executorService.shutdown();
    }

}

class SequenceGeneratorTask3 implements Runnable{

    NumberGenerator3 numberGenerator;
    Integer result;

    public SequenceGeneratorTask3(NumberGenerator3 numberGenerator, Integer result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numberGenerator.printSequence(result);
    }
}

class NumberGenerator3 {
    public Integer number=1;
    public Integer totalNumbersInSequence;
    public Integer numberOfThreads;

    public NumberGenerator3(Integer totalNumbersInSequence, Integer numberOfThreads) {
        super();
        this.totalNumbersInSequence = totalNumbersInSequence;
        this.numberOfThreads = numberOfThreads;
    }

    public void printSequence(int result)  {
        synchronized (this){
            while(number < totalNumbersInSequence-1){
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

