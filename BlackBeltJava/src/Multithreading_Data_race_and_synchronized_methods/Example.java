
package Multithreading_Data_race_and_synchronized_methods;

public class Example {
    static int counter = 0;
    public static synchronized void increment(){ 
        /**
         * в пописание метода записываем ключевое слово synchronized и теперь эту операцию в один и тот же момент времени может делать либо thread1, 
         * либо thread2.пока один работает, другой стоит ждет
         */
        counter++;
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread  thread1 = new Thread(new R());
        Thread  thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join(); // чтобы поток main вывел counter только после того как отработают потоки
        thread2.join();
        System.out.println(counter);
    }
}

class R implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            Example.increment();
        }
    }
}

/**
 * output: 200
 *         130
 *         112
 * несколько запусков здесь тоже происходит data race, чтобы этого избежать, мы можем поставить lock и добиться того,чтобы только один поток менял данные
 * 
 * после добавления в описание метода ключевого слова synchronized, теперь при любом запуске в output всегда будет 200, каждый из потоков будет забегатьв метод 
 * increment 100 раз
 */