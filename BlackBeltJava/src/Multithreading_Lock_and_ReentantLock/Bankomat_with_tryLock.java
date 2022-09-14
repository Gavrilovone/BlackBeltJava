package Multithreading_Lock_and_ReentantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * метод tryLock позволяет делать lock когда ресурс свободен или выполнять какие-то действия(в блоке else) когда ресурс занят
 */
public class Bankomat_with_tryLock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee2("Алексей", lock);
        new Employee2("Олег", lock);
        new Employee2("Елена", lock);
        Thread.sleep(5000);
        new Employee2("Виктор", lock);
        new Employee2("Марина", lock);
    }

}

class Employee2 extends Thread {

    String name;
    private Lock lock;

    public Employee2(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if (lock.tryLock()) { // если удалось залочить возвращает true иначе false
            try {
                System.out.println(name + " Пользуется банкоматом");
                Thread.sleep(2000); // каждый работник пользуется банкоматом 2 секунды
                System.out.println(name + " Работник завершил(а) работу с банкоматом");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
        else {
            System.out.println(name + " не хочет ждать в очереди");
        }
    }
}
/**
 * логика программы стала такой, если банкомат свободен , работник начинает пользоваться, если другой работник подходит и банкомат занят, тоесть ему не удается поставить замок, то выводим сообщение работник Не хочет ждать в очереди
 */


/**
 * output:
 *          Олег не хочет ждать в очереди
            Алексей Пользуется банкоматом
            Елена не хочет ждать в очереди
            Алексей Работник завершил(а) работу с банкоматом
            Виктор Пользуется банкоматом
            Марина не хочет ждать в очереди
            Виктор Работник завершил(а) работу с банкоматом
 */