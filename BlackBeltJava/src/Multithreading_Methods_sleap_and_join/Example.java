
package Multithreading_Methods_sleap_and_join;

public class Example extends Thread {
    @Override
    public void run(){ 
        for(int i = 1; i <= 10; i++){
            try{
            Thread.sleep(1000); 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException { // join так же может выбрасывать InterruptedException
        Thread thread1 = new Thread(new MyRunnable1());
        Example thread2 = new Example();
        thread1.start();
        thread2.start();
        
        /**
         * если мы хотим, чтобы слово конец высветился после того, как оба потока отработают, тесть нам нужно как-то объяснить потоку main, что он
         * должен дождаться пока другие потоки отработают, в этом нам поможет метод join
         */
        
        thread1.join();
        thread2.join();
        /**
         * поток main будет ожидать окончания работы этих потоков  ипосле продолжит свою работу, а продолжением его работы будет вывод на экран слова "конец" 
         */
        
        System.out.println("Конец");
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run(){ 
        for(int i = 1; i <= 10; i++){
            try{
            Thread.sleep(1000); 
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
            /**
             * output:
             *          Конец
                        Thread-1 1
                        Thread-0 1
                        Thread-0 2
                        Thread-1 2
                        Thread-0 3
                        Thread-1 3  
                        Thread-0 4
                        Thread-1 4
                        Thread-1 5
                        Thread-0 5
                        Thread-1 6
                        Thread-0 6
                        Thread-0 7
                        Thread-1 7
                        Thread-0 8
                        Thread-1 8
                        Thread-1 9
                        Thread-0 9
                        Thread-0 10
                        Thread-1 10
             */

            /**
             *  мы не можем в сигнатуре метода run написать , что он выбрасывает exceptionInterruptedException, потому что мы переопределяем метод run, а
             * у Runnable в метод run не выбрасывает никакой exception,  поэтому нам надо обработать этот exception в блоке try-catch
             * 
             * как работает эта программа: мы запускаем 2 потока в методе main, работа обоих потоков в принципе одинакова они выводят числа от одного до 10
             * и перед этим выводят названия потокоа в котором происходит это действие и в потоке main выводим слово конец на экран.С интервалом в 1 секунду
             * выводятся числа от 1 до 10 каждым из 2х потоков, первый и второй поток выводят 1 спят 1 секунду, выводят 2 спят одну секунду и так далее до 10
             * почему конец вывелся первый, потому что поток main запустил оба потока,эти потоки отпочковались от него, но сам main продолжает свою работу
             * независимо от них, он же отдельный поток, потк main не спит и выводит на экран "конец"несмотря на то, что поток main завершил свою работу после
             * этого, остались другие потоки и программа не заканчивает свою работу, пока не закончать работу все потоки
             * 
             * InterruptedException (Interrupt) переводится как останавливать, если одни поток попытается остановить поток который находится в спячке, то
             * вылетит этот exception? который означает, пока вы спали, другой поток попросил вас остановится
             * 
             */