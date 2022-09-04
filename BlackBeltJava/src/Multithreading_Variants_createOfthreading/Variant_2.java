
package Multithreading_Variants_createOfthreading;
/**
 * Если например наш класс уже наследуется от какого-то класса, и мы не можем еще раз делать extends Thread(так как в java не поддерживается двойное наследования)
 * то для создания потока, используется интерфейс Runnable() разумеется этот вариант используется чаще
 * класс Tread имплементирует интерфейс Runnable поэтому у него тоже есть метод run() который мы переопределяли, см Variant_1
 */
public class Variant_2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread1());
        Thread thread2 = new Thread(new MyThread2());
        thread1.start();
        thread2.start();
    }
}


class MyThread1 implements Runnable {
    @Override
    public void run(){
        for(int i = 1; i <=1000; i++){
            System.out.println(i);
        }
    }
} 

class MyThread2 implements Runnable {
    @Override
    public void run(){
        for(int i = 1000; i >0; i--){ 
            System.out.println(i);
        }
    }
} 

/**
 * таким образом второй способ создания потока:
 * class MyRunnablempl implements Runnable{ public void run(){ код}}
 * запуск
 * new Thread( new MyRunnablelmpl() ).start();
 */