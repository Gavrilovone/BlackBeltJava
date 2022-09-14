
package Multithreading_Lock_and_ReentantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Реентабельность - повторно входимый, компьютерная программа или ее отдельная процедура которая разработана таким образом, что одна и та же копия 
 * инструкции программы  в памяти может быть совместно использована несколькими пользователями или процессами.При этом второй пользователь может вызвать 
 * рентабельный код до того как с ним завершит работу первый пользователь
 * 
 * Lock - это интерфейс, который имплементируется классом ReentrantLock, также как ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками.У него есть методы lock() и unlock(), тоесть в этом примере вместо него можно было бы написать synchronize блок и было бы тоже самое
 * Но у synchronize конструкции по отношению к локу есть плюс, в нем в отдичие от lock не надо заботится о том, чтобы закрыть lock.И если например не открыть его
 * потом методом unlock(),  то ни один другой поток не сможет обработать свой код, потому то будет висеть замок
 * Но и у Lock тоже есть плюс относительно synchronize конструкции см.Bankomat_with_tryLock
 */
public class Interface_Lock {
    public static void main(String[] args) {
       Call call = new Call();
       Thread thread1 = new Thread(new Runnable(){ // анонимный класс
           @Override
           public void run(){
               call.mobileCall();
           }
       });
       
       Thread thread2 = new Thread(new Runnable(){ 
           @Override
           public void run(){
               call.SkypeCall();
           }
       });
       
       Thread thread3 = new Thread(new Runnable(){ 
           @Override
           public void run(){
               call.whatsAppCall();
           }
       });
       
       thread1.start();
       thread2.start();
       thread3.start();
    }
}

class Call{
    private Lock lock = new ReentrantLock();
    
    void mobileCall(){
        lock.lock();
        try {
            System.out.println("Mobile Call starts");
            Thread.sleep(3000);
            System.out.println("Mobile Call ends");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally{ // unlock() всегда нужно писать в блоке finally, чтобы замок открывался в любом случае
        lock.unlock();
        }
    }
    
     void SkypeCall(){
        lock.lock(); // если какой-то поток вызовет этот метод, то замок откроется и откроется лишь в конце метода
        try {
            System.out.println("Skype Call starts");
            Thread.sleep(5000);
            System.out.println("Skype Call ends");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally{ 
        lock.unlock();
        }
    }
     
      void whatsAppCall(){
        lock.lock();
        try {
            System.out.println("WhatsAppCall Call starts");
            Thread.sleep(7000);
            System.out.println("WhatsAppCall Call ends");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally{ 
        lock.unlock();
        }
    }
}

/** output:
 *      Mobile Call starts
        Mobile Call ends
        Skype Call starts
        Skype Call ends
        WhatsAppCall Call starts
        WhatsAppCall Call ends
 */