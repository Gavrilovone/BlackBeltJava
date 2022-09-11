
package Multithreading_Monitor_and_synchronized_blocks;


public class SynchronizedBlock2 {
      static int counter = 0;
    public static void increment(){ 
       /**
        * так как метод статичный, использовать в качестве монитора this нельзя, в этом случае используется монитор всего класс
        */
       synchronized(SynchronizedBlock2.class){ // такое описние будет освещаться в темах про reflection
       counter++;
       }
       
       /**
        * да, в этом случае конечно лучше использовать synchronised в сигнатуре метода, но если например инкремент будет велик и мы хотим часть хода
        * синхронизировать, а чать нет, то мы используем синхронизированные блоки
        * 
        * нужно запомнить раз и навсегда, что синхронизация идет по монитору, а монитор это неотъемлемая часть каждого объекта каждого класса
        */
       
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread  thread1 = new Thread(new R2());
        Thread  thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();
        thread1.join(); 
        thread2.join();
        System.out.println(counter);
    }
}

class R2 implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            SynchronizedBlock2.increment();
        }
    }
}
