
package Multithreading_class_AtomicInteger;

/**
 *
 */
public class Example {
    static int counter = 0;
    
    public synchronized static void increment(){
       
        counter++;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl());
        Thread thread2 = new Thread(new MyRunnableImpl());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class MyRunnableImpl implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            Example.increment();  // будем 100 раз в цикле вызывать метод increment
        
        }
    }
}

/**
 * output: 200 
 */

 /**
  * если не синхронизировать метод increment, то  у на не всегда будет 200 в output, но на самом деле synchronized достаточно тяжелая штука, постоянно 
  * происходит блокировка монитора, потом его разблокировка и тд.а приходилось так делать, потому что эта операция прибавление на 1 это не атомарная операция(
  * не не делимая) сначала читается информация, затем увеличивается, затем записывается в память.Java предлагает для таких случаев пользоваться классом 
  * AtomicInteger, в нем все поперации которые нам нужны происходят атомарно см Example_with_AtomicInteger
  */