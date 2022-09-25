package Multithreading_class_AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger - это клас, который предоставляет возможность работать с целочисленным значением int используя атомарные операции
 */
public class Example_with_AtomicInteger {

    static AtomicInteger counter = new AtomicInteger(0); // по умолчанию тоже 0

    public static void increment() {

        counter.incrementAndGet(); // сначала прибавляет а потом получаем значение
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImp2());
        Thread thread2 = new Thread(new MyRunnableImp2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class MyRunnableImp2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Example_with_AtomicInteger.increment();

        }
    }
}

/**
 * Есть у AtomicInteger так же методы:
 * 
 * getAndIncrement - сначала полчаем старое значение, а потом прибавляет
 * 
 * addAndGet - позволяет увеличивать не на 1 а на 5,  тоесть число указанное в параметре
 * getAndAdd - возвращает сначала старое значение, потом прибаляет
 * 
 * decrimentAndGet - уменьшает на 1 и возвращает
 * getAndDecrement - возвращает старое значение , потом меньшает на 1
 * 
 * по аналогии есть AtomicLong, AtomocBoolean и тд
 */


/**
 * output: 200  - всегда
 */