
package Multithreading_Thread_poll_and_ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Создание потоков это достаточно затратное действие,это происходит не так быстро, и в JVM за кулисами происходит множество процессов 
 * и управлять отдельно созданными потоками не удобно, на помощь приходит механизм Thread pool
 * Thread pool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи(помимо того, что он удобен, он еще и более эффективен с точки зрения тех процессов которые происходят за кулисами) 
 * 
 * в Java работа с Thread poolaми происходит посредсвом объектов Esecutor(это интерфейс) а исенно посредством ExecutorService
 * 
 * Thread pool удобнее всего создавать не используя конструктор, а  используя factory методы класса Esecutors
 */
public class Thread_pool {
    public static void main(String[] args) {
      //  ExecutorService executorService = new ThreadPoolExecutor(); - есть вариант создания тред пула напрямую, но так обычно не пишут
      ExecutorService executorService =  Executors.newFixedThreadPool(5); // вызов factory метода, создание тред пула с 5 потоками
      /**
       * метод  newFixedThreadPool возвращает нам ThreadPoolExecutor
       */
    }
}
