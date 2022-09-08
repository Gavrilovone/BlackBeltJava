
package Multithreading_Concurrency_parallelism_synchronous_and_asynchronous;

public class Example extends Thread {
     @Override
    public void run(){ 
        for(int i = 1; i <= 10; i++){
            try{
            Thread.sleep(100); 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException { 
        Thread thread1 = new Thread(new MyRunnable());
        Example thread2 = new Example();
        thread1.start();
        thread2.start();
       
        
        thread1.join();
        thread2.join();
      
        System.out.println("Конец");
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run(){ 
        for(int i = 1; i <= 10; i++){
            try{
            Thread.sleep(100); 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
/**
 * Thread-1 1
Thread-0 1          Thread-1 1
Thread-0 2          Thread-0 1
Thread-1 2          Thread-1 2
Thread-0 3          Thread-0 2
Thread-1 3          Thread-1 3
Thread-0 4          
Thread-1 4
Thread-0 5
Thread-1 5             -/-
Thread-1 6
Thread-0 6
Thread-1 7
Thread-0 7
Thread-1 8
Thread-0 8
Thread-0 9
Thread-1 9
Thread-0 10         Thread-1 10
Thread-1 10         Thread-0 10
Конец               Конец
 */


/**
 * output при каждом запуске будет отличаться, потоки будут каждый раз по разному срабатывать, потому что у них нет никакого порядка, они работают асинхронно
 * их поведение непредсказуемо(такое состояние называетс недетерминирование).Да абсолютно предсказуемо, что выведутся сначала две еденицы потом двойки, но то 
 * в какой последовательности Thread-0 или Thread-1 знать мы не можем это непредсказуемо
 * 
 * иными словами в программах, в которых используется асинхронное программирование мы не можем определить порядок выполнения потоков!
 */