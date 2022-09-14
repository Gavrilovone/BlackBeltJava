
package Multithreading_Lock_and_ReentantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Рассмотрим пример: представьте, что у нас есть банкомат, этим банкоматом может пользоватья только один человек в одно и тоже врем
 */

public class Bankomat{
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Алексей", lock);
        new Employee("Олег", lock);
        new Employee("Елена", lock);
        new Employee("Виктор", lock);
        new Employee("Марина", lock); // теперь когда поток Employee так как он экстендит Thread мы создаем, он сразу запускается, так как есть в конструктоке start()
    }

}

class Employee extends Thread{
    String name;
    private Lock lock;
    
    public Employee(String name, Lock lock){
        this.name = name;
        this.lock = lock;
        this.start(); // прописали в конструкторе, чтобы не прописывать отдельной операцией создание потока, при вызове конструктора поток запускается
      
    }
    
    @Override
    public void run(){
        try{
        System.out.println(name + " Ждет");
        lock.lock();
        System.out.println(name + " Пользуется банкоматом"); 
            Thread.sleep(2000); // каждый работник пользуется банкоматом 2 секунды
            System.out.println(name + " Работник завершил(а) работу с банкоматом");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }
}

/** output:
 *      Олег Ждет
        Олег Пользуется банкоматом
        Алексей Ждет
        Елена Ждет
        Виктор Ждет
        Марина Ждет
        Олег Работник завершил(а) работу с банкоматом
        Алексей Пользуется банкоматом
        Алексей Работник завершил(а) работу с банкоматом
        Елена Пользуется банкоматом
        Елена Работник завершил(а) работу с банкоматом
        Виктор Пользуется банкоматом
        Виктор Работник завершил(а) работу с банкоматом
        Марина Пользуется банкоматом
        Марина Работник завершил(а) работу с банкоматом
 */