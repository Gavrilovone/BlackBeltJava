package Multithreading_Data_race_and_synchronized_methods;

public class Example_data_race {
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
    public void increment(){
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    
    @Override
    public void run(){
        for(int i= 0; i<3; i++){
            increment();
        }
    }
}
/**
 * output:  1 4 5 2 6 7 3 8 9
 *          2 3 2 6 7 5 8 4 9
 *          2 2 5 3 6 4 8 7 9 
 * несколько запусков
 */

/**
 * Запускаются потоки, в каждом потоке срабатывает метод increment 3 раза и выводит значение переменной count.Здесь нет никакой синхронизации между потоками, они одновременно делают какие-то действия.ситуация когда несколько потоков меняют данные например какой-то переменной и пытаются быстрее закончить свои операции
 * называется data race(гонка данных)
 */