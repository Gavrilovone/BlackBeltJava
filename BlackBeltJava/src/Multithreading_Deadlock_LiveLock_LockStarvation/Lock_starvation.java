
package Multithreading_Deadlock_LiveLock_LockStarvation;

/**
 * Lock Starvation - ситуация, когда менее приоритетные потоки ждут долгое время или все время для того, чтобы могли запустится.например у нас мноество потоков делают какую-то работу, но метод синхронизирован и работает лишь 1 поток, первый, второй, третий имеют высокий приоритет и они создают новые потоки с высоким 
 * приоритетом и дело до следующих потоков либо вочень долго будет идти либо вообще не дойдети получается эти потоки "голодают"
 */
public class Lock_starvation {
    
}
