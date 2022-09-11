
package Multithreading_Monitor_and_synchronized_blocks;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImpl runnable =  new MyRunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
  

class Counter {

    static int count = 0;
}

class MyRunnableImpl implements Runnable{
    private void doWork2(){
        System.out.println("Ura!!!");
    }
    
    public void doWork1(){
        doWork2(); // часть кода не синхронизированная
        synchronized(this){ // пишем объект на котором будем синхронизироваться(т.е объект чей монитор для синхронизации будем использовать)
            Counter.count++;
            System.out.println(Counter.count);
        }
    
    }
    
    @Override
    public void run(){
        for(int i= 0; i<3; i++){
            doWork1();
        }
    }
}

/**
 * получается тоже самое, как и в случае с sinchronised методами, только там мы явно не указываем объект(this в данном случае).самое главное отличие от
 * сигхронизированного метода в том, что в блоке можно синхронизировать не весь метод, а его чать
 * 
 * Сразу несколько потоков могут войти в метод doWork1 и работать с несинхронизированной чатью кода (строчка 28)  но когда дело дойдет до синхронизированного
 * блока(стр.29-32), это сможет делать только один поток, который первый зайдет
 */