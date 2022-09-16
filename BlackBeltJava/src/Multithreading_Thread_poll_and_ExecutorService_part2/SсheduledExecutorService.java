
package Multithreading_Thread_poll_and_ExecutorService_part2;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * SсheduledExecutorService мы используем тогда, когда хотим установить расписание на запуск потоков из пула.Данный pool создается используя factory
 * метод класса Executors: Executors.newScheduledThreadPool(int count) устанавливая количество потоков в этом thread poole
 */
public class SсheduledExecutorService {
        public static void main(String[] args) {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            
            scheduledExecutorService.schedule(new RunnableImp200(), 3, TimeUnit.SECONDS);
            /**
             * Эта запись говорит нам, выполни эти таски new RunnableImp200() через 3 секунды
             */
            scheduledExecutorService.shutdown();
            
            /**
             * Метод scheduleAtFixedRate планирует задачу(new RunnableImp200()) для периодического выполнения, впервые она сработает через 3 секунды
             * после запуска scheduleAtFixedRate и потом будет выполняться с периодичностью в 1 секунду
             */
            scheduledExecutorService.scheduleAtFixedRate(new RunnableImp200(), 3, 1, TimeUnit.SECONDS);
    }
}

class RunnableImp200 implements Runnable {

    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}

/**     output: 
 *      pool-1-thread-1 begins work (через 3 сеунды начало выполняться задание)
        pool-1-thread-1 ends work
 */