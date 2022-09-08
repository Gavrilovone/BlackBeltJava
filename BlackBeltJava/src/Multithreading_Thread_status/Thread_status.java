
package Multithreading_Thread_status;
/**
 * в кратце о состояниях потока(Thread status):
 * 1 состояние это когда он new(после создания до вызова метода start)
 * когда вызывается start, это состояние называется runnsble(состояние выполнения) и он делится на состояние rady(готовность, ждет опреационную систему которая
 * должна запустить его, потому что потоков может быть много и он может стоять в какой-то очереди) и runny(когда поток на самом деле выполняется)
 * 3 состояние terminated(когда работа потока завершена)
 */
public class Thread_status {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState()); // смотрим состояние потока
        thread.start();
        System.out.println(thread.getState()); 
        thread.join();
        System.out.println(thread.getState());  // 100% поток закончится после метода join
        System.out.println("Method main ends");
    }
}
/**
 *  output:
 *  Method main begins
    NEW
    RUNNABLE
    Work begins
    Work ends
    TERMINATED
    Method main ends
 */

class Worker implements Runnable{
    @Override
    public void run(){
        System.out.println("Work begins");
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}