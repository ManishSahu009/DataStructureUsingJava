
package org.ms.ds.threads;

public class PrintEvenOdd {

    public static void main(String[] args) {
        NumberGenerator2 numberGenerator=new NumberGenerator2(20,2);
        Thread thread1= new Thread(new SequenceGeneratorTask2(numberGenerator, 1),"thread-1");
        Thread thread2= new Thread(new SequenceGeneratorTask2(numberGenerator, 0),"thread-2");

        thread1.start();
        thread2.start();

    }

}

class SequenceGeneratorTask2 implements Runnable{

    NumberGenerator2 numberGenerator;
    Integer result;

    public SequenceGeneratorTask2(NumberGenerator2 numberGenerator, Integer result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numberGenerator.printSequence(result);
    }
}

class NumberGenerator2 {
    public Integer number=1;
    public Integer totalNumbersInSequence;
    public Integer numberOfThreads;

    public NumberGenerator2(Integer totalNumbersInSequence, Integer numberOfThreads) {
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

