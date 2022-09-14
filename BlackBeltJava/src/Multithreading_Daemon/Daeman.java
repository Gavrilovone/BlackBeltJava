
package Multithreading_Daemon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Daeman потоки  - переводится на русский как потоки демоны
 * До этого потоки которые мы создавали назывались user threads, был поток main и все остальные потоки отпачковывались от него и даже если поток main
 * завершал свою работу, программа продалжала работу, пока все остальные потоки не завершат свою работу тоже, но если при этом еще есть и потоки демоны, то
 * программа закончит свою работу если main потоки и  все потоки  закончили работу, даже если поток деман еще работает
 * 
 * Потому что deamon потоки предназначены для выполнения фоновых задач и оказания различных сервисов user потокам, тоесть срабатывает простая логика, если
 * user потоков нет, то им оказывать никакие сервисы не нужно и поэтому можно не дожидаться окончания работы deamon потоков и завершать работу программы
 * 
 * Обычно deamon потоки полезны для поддержания каких-то background заданий например большинство потоков JVM deamon потоки(они занимаются сборкой мусора 
 * garbage collector, они освобождают память и тд и тп.)
 * 
 * поток легко сделать демоном, для этого нужно после создания потока, но обязательно перед его запуском! вызвать setDaemon() и передать значение true, 
 * проверить является ли поток демоном можно, вызвав его метод isDaemon() если вызвать его до, то вылетит IllegalThreadStateException
 */
public class Daeman {
    public static void main(String[] args) {
        System.out.println("Main Thread starts");
        UserThread  userThread = new UserThread();
        userThread.setName("user_thread"); // назначми ему имя
        DaemanThread daemanThread = new DaemanThread();
        daemanThread.setName("daemon_thread");
        daemanThread.setDaemon(true);
        userThread.start();
        daemanThread.start();
        
        
        
        System.out.println("Main Thread ends");
    }
}

class UserThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is Daemon: " + isDaemon()); // и проверяем является ли поток демоном
        for (char i = 'A'; i <= 'J'; i++){ try {
            //увеличиваем букву, тоесть если к A прибавить 1 то получится B
            sleep(300);
            System.out.println(i);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
        }
    }
}

class DaemanThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is Daemon: " + isDaemon()); // и проверяем является ли поток демоном
        for (int i = 1; i <= 1000; i++){ try {
            //увеличиваем букву, тоесть если к A прибавить 1 то получится B
            sleep(100);
            System.out.println(i);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
        }
    }
}

/** output:
 *          Main Thread starts
            Main Thread ends
            daemon_thread is Daemon: true
            user_thread is Daemon: false
            1
            2
            3
            A
            4
            5
            B
            6
            7
            8
            C
            9
            10
            11
            D
            12
            13
            14
            E
            15
            16
            17
            F
            18
            19
            20
            G
            21
            22
            23
            H
            24
            25
            26
            I
            27
            28
            J
 */