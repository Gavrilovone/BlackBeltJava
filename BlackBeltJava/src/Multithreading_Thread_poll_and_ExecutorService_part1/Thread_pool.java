
package Multithreading_Thread_poll_and_ExecutorService_part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static void main(String[] args) throws InterruptedException {
      //  ExecutorService executorService = new ThreadPoolExecutor(); - есть вариант создания тред пула напрямую, но так обычно не пишут
      ExecutorService executorService =  Executors.newFixedThreadPool(5); // вызов factory метода, создание тред пула с 5 потоками
      ExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor(); // есть еще такой способ создания тред пула состоящего из 1 потока
     
      /**
       * Этот метод создаст Thread pool который будет создавать в себе кешированные потоки по мере надобности, тоесть когда threads свободны они могут 
       * преиспользоваться, если все заняты создается новый, если thread в течение 60 секунд не получает задание, он удаляется : 
       */
      ExecutorService executorService3 = Executors.newCachedThreadPool();// еще один способ создания тред пула
      
      
      /**
       * метод  newFixedThreadPool возвращает нам ThreadPoolExecutor
       */
      for(int i =0; i < 10; i++){
          executorService.execute(new RunnableImp100());
      }
        executorService.shutdown(); // если мы не намерены давать новые таски, то обязательно надо заканчивать работу executorService добавив метод shutdown()
        executorService.awaitTermination(5, TimeUnit.SECONDS); // всегда вызывается после метода shutdown(); выбрасывает InterruptedException
        System.out.println("Main ends");
    }
}

class RunnableImp100 implements Runnable {

    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/**
 * Внутри потока Main был создан Thread pool из 5 потоков, потом с помощью метода execute мы передали какое-то задание, а именно RunnableImp100() (стр.27)
 * 
 * меод execute() передает наше задание(task) в thread pool, где оно выполняется одним из потоков
 * 
 * метод shutdown(); говорит о том, что заданий больше не будет и пргграмма завершится, только после того, как все таски выполнятся
 * 
 * метод awaitTermination - работает практически как метод join, он заставляет ожидать поток в котором он вызывается, в данном случае мы вызываем внутри потока
 * main, значит поток main будет ждать до тех пор пока executorService не закончит всю свою работу либо не пройдет указанное время(после его вызова main ends 
 * будет в конце) но если мы изменим например время работы наших потоков по 4 секунды(стр.43), то время работы executorService будет 8 секунд и main не 
 * будет уже дожидаться окончания работы executorService и выйдет из ожидания через 5 секунд
 * 
 * 
 */


/**     output:
 *      pool-1-thread-1
        pool-1-thread-5
        pool-1-thread-4
        pool-1-thread-3
        pool-1-thread-2
        Main ends
        pool-1-thread-5
        pool-1-thread-4
        pool-1-thread-3
        pool-1-thread-2
        pool-1-thread-1
 */