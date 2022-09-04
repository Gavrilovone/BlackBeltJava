
package Multithreading_Variants_createOfthreading; // варианты создания нового потока

public class Variant_1 {
    /**
     * у нас есть класс Thread (поток) , чтобы создать поток, мы можем екстендить этот класс
     * и в метод run() мы закладываем всю логику, которую должен выпонять наш новый поток
     */
    
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start(); // запускаем поток с помощью этого метода
        myThread2.start(); // после того как мы вызвали метод start() JVM автоматически вызывается метод run(), не надо самостоятельно вызывать его см. Multithreading_Thread_name_and_Thread_priority Example2
    }
    /**
     * между этими двумя потоками нет никакой синхронизации и какой поток будет выволняться первым, какой закончит первый, мы знать не можем!
     * если мы запустим эту программу несколько раз, то output будет разным
     * 
     * на самом деле здесь работает 3 потока, поток main создается автоматически
     */
}

class MyThread1 extends Thread{
    @Override
    public void run(){
        for(int i = 1; i <=1000; i++){
            System.out.println(i);
        }
    }
} 

class MyThread2 extends Thread{
    @Override
    public void run(){
        for(int i = 1000; i >0; i--){ // будет выводить числа в перевернутом порядке
            System.out.println(i);
        }
    }
} 
/**
 * таким образом 1 вариант создания потока:
 * class MyThread extends Thread { public void run(){ код } }
 * запуск
 * new MyThread().start();
 * 
 */