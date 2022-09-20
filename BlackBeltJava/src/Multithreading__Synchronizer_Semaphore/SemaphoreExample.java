
package Multithreading__Synchronizer_Semaphore;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Semaphore - это синхронизатор, позволяющий ограничить доступ к какому-то ресурсу.В конструктор Semaphore нужно передавать количетво потоков,
 * которым Semaphore будет разрешать одновременно использовать этот ресурс 
 */
public class SemaphoreExample {
    /**
     * У нас 2 телефонные будки и 5 желающих позвонить, создадим семафор ограничением 2, тоесть 2 человека одновременно могут звонить
     */
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        new Person("Алексей", callBox );
        new Person("Иван", callBox );
        new Person("Ольга", callBox );
        new Person("Мария", callBox );
        new Person("Петр", callBox );
    }
}

class Person extends Thread {

    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start(); // при создании объекта Person этот поток сразу запускается
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ждет..");
            /**
             * Метод  acquire предназначен для попытки получить разрешение от Семафора, он заблокирует этот поток, пока ресурс не будет доступен для нас, 
             * после доступности мы получаем разрешение для использования ресурса и counter семафора уменьшается на 1
             */
            callBox.acquire();
            System.out.println(name + " Пользуется телефоном");//  после того как мы получили разрешение, можем вывести сообщение
            sleep(2000);
            System.out.println(name + " Завершил(а) звонок");
           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            /**
             * обязательно в finally блоке вызываем метод release(), который говорит о том, что мы освобождаем оазрешение семафора тем самым 
             * увеличивается каунтер у семафора на 1.Этот release() всегда нужно использовать в блоке finally, ведь если выбросится exception и 
             * работа потока прервется, нам необходимо освободить доступ к ресурсу
             */
            callBox.release(); 
        }
    }

}



/**
output:
Алексей ждет..
Алексей Пользуется телефоном
Ольга ждет..
Ольга Пользуется телефоном
Мария ждет..
Петр ждет..
Иван ждет..
Ольга Завершил(а) звонок
Алексей Завершил(а) звонок
Мария Пользуется телефоном
Петр Пользуется телефоном
Мария Завершил(а) звонок
Иван Пользуется телефоном
Петр Завершил(а) звонок
Иван Завершил(а) звонок
 * 
 */