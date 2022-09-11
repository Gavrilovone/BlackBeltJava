
package Multithreading_Monitor_and_synchronized_blocks;

public class Example {
    /**
     * задачка: нам могут звонить на мобильный телефон по скайпу, по мобильной етиу или по вотцапу, договоримся, что унас будут 3 разных потока, ответственные 
     * за звонки с разных каналов и что если мы уже говорим по одному каналу и нам идет звонок с другого канала, то этот звонок будет ждать пока не закончитс текущий
     */
    
    static final Car car = new Car();
    static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println(this); // выводим на экран this для каждого метода
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println(this);
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsAppCall() {
        synchronized (lock) {
            System.out.println(this);
            System.out.println("whatsAppCall call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("whatsAppCall call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsApp());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable {

    @Override
    public void run() {
        new Example().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {

    @Override
    public void run() {
        new Example().skypeCall();
    }
}

class RunnableImplWhatsApp implements Runnable {

    @Override
    public void run() {
        new Example().whatsAppCall();
    }
}

/**
 * output:  никакой синхронизации нет, одновременно начались звонки по вем каналам и так же закончились
 *  Skype call starts
    Mobile call starts
    whatsAppCall call starts
    Mobile call ends
    Skype call ends
    whatsAppCall call ends
    * 
    * но даже после того как мы укажем  в сигнатуре метода  synchronized, ничего неизменится, почему:
    * потому что когда мы используем в сигнатуре метода synchronized, то по умолчанию используется синхронизация на объекте this(если метод не статичный)
    * если мы выведем this для каждого метода, то увидим, что синхронизация происходит для разных объектов
    * 
    Multithreading_Monitor_and_synchronized_blocks.Example@511e2e22
    Multithreading_Monitor_and_synchronized_blocks.Example@3f2c6b2b
    whatsAppCall call starts
    Multithreading_Monitor_and_synchronized_blocks.Example@5e508a26
    Skype call starts
    Mobile call starts
    Mobile call ends
    Skype call ends
    whatsAppCall call ends
    * 
    * для синхронизации можно использовать абсолютно любой объект, мы можем создать класс Car и использовать для синхронизации его объект(стр.10)
 */

class Car{} // но на самом деле так лучше делать не стоит, для этого пишут (стр.11)

/**
 * после синхронизации на объекте Car:
 * 
 *  Multithreading_Monitor_and_synchronized_blocks.Example@4adf4aed
    Mobile call starts
    Mobile call ends
    Multithreading_Monitor_and_synchronized_blocks.Example@451b4ce4
    whatsAppCall call starts
    whatsAppCall call ends
    Multithreading_Monitor_and_synchronized_blocks.Example@1cafc10b
    Skype call starts
    Skype call ends
    * 
    * очередность может меняться, но теперь все идет последовательно, пока не отработает один метод, другой не начнет свою работу, потому что 
    * монитор объекта может занимать только один поток
    * 
    * не возможно синхронизировать конструктор, JVM  гарантирует что контруктр может обрабатываться лишь одним потоком
 */