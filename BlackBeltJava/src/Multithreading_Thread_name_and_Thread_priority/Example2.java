
package Multithreading_Thread_name_and_Thread_priority;
/**
 * что будет если запустить самостоятельно метод run() а не предоставить это JVM
 */
public class Example2 implements Runnable {
    @Override
    public void run(){
        System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
        /**
         * currentThread() - это статический метод, который как мы видим вызывается с помощью класса, который показывает текущий поток
         */
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(new Example2());
        thread.start();
         System.out.println("Method main. Thread name = " + Thread.currentThread().getName()); // вывод тойже инфонмации только в потоке main
         
         /**
          * output:
          * Method main. Thread name = main
            Method run. Thread name = Thread-0
          * 
          * 
          * если мы попытаемся вызвать самостоятельно метод run() то output будет:
          * Method main. Thread name = main
            Method run. Thread name = main
          * потому, что когда мы самостоятельно вызываем метод run(), мы не можем запустить поток, метод run выполняется просто как часть потока main
          * потому, что мы вызвалти его в потоке main
          * 
          */
        
         
    }
}
