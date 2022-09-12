
package Multithreading_Deadlock_LiveLock_LockStarvation;
/**
 * DeadLock описывает ситуацию когда 2 иболее потоков заблокированы на вечно ожидая другдруга и ничего не делают? это происходит когда 2 потока используют
 * синхронизацию на разных объектов и эта синхронизация происходит не в одинаковом порядке
 */
public class DeadLock {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1: Попытка захватить монитор lock1");
        synchronized (DeadLock.lock1) {
            System.out.println("Thread1: Монитор объекта lock1 захвачен");

            System.out.println("Thread1: Попытка захватить монитор lock2");

            synchronized (DeadLock.lock2) {
                System.out.println("Thread1: Монитоs объектjd lock1 и  lock2 захвачены");
            }
        }
    }
}


class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread2: Попытка захватить монитор lock2");
        synchronized (DeadLock.lock2) { // нужно изменить DeadLock.lock1
            System.out.println("Thread2: Монитор объекта lock2 захвачен");

            System.out.println("Thread2: Попытка захватить монитор lock1");

            synchronized (DeadLock.lock1) { // нужно изменить на DeadLock.lock2
                System.out.println("Thread2: Монитоs объектjd lock1 и  lock2 захвачены");
            }
        }
    }
}


/** output:
 *  Thread1: Попытка захватить монитор lock1
    Thread1: Монитор объекта lock1 захвачен
    Thread2: Попытка захватить монитор lock2
    Thread1: Попытка захватить монитор lock2
    Thread2: Монитор объекта lock2 захвачен
    Thread2: Попытка захватить монитор lock1
    * 
    * раз на раз не приходится, но в один из запусков наша программ аможет попасть в мертвый замок и никогда не закончится, почему:
    * потому что thread1 пытается захватить lock1 и успешно захватывает,  тем временем параллельнос thread1 работает thread2, он пытается в первую очередь
    * захватить монитор объекта lock2 и захватывает его(находится внутри synchronize блока) и теперь thread1 пытается захватить монитор объекта lock2, но
    * lock2 уже занят thread2, a thread2 пытается захватить монитор объекта lock1 который уже занят thread1 и получается ситуация, когда 2 потока ждут друг 
    * друга до бесконечности и не отпускают захваченные локи.Чтобы исправить ту ситуацию, нам надо изменить порядок наших локов, если первый поток лочет в таком
    * пордке  то и второ поток должен лочить в таком же порядке(стр.42, 47)
 */