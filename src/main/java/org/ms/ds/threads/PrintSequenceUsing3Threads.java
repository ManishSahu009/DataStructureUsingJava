package org.ms.ds.threads;

public class PrintSequenceUsing3Threads {

    public static void main(String[] args) {
        NumberGenerator1 numberGenerator=new NumberGenerator1(20,3);
        Thread thread1= new Thread(new SequenceGeneratorTask1(numberGenerator, 1),"thread-1");
        Thread thread2= new Thread(new SequenceGeneratorTask1(numberGenerator, 2),"thread-2");
        Thread thread3= new Thread(new SequenceGeneratorTask1(numberGenerator, 0),"thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class SequenceGeneratorTask1 implements Runnable{

    NumberGenerator1 numberGenerator;
    Integer result;

    public SequenceGeneratorTask1(NumberGenerator1 numberGenerator, Integer result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numberGenerator.printSequence(result);
    }
}

class NumberGenerator1 {
    public Integer number=1;
    public Integer totalNumbersInSequence;
    public Integer numberOfThreads;

    public NumberGenerator1(Integer totalNumbersInSequence, Integer numberOfThreads) {
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
