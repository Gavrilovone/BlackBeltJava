
package Multithreading_Thread_poll_and_ExecutorService_part2;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

            /**
             * Метод scheduleAtFixedRate планирует задачу(new RunnableImp200()) для периодического выполнения, впервые она сработает через 3 секунды
             * после запуска scheduleAtFixedRate и потом будет выполняться с периодичностью в 1 секунду(это период между началом обработки 1 задания 
             * и началом обработки 2го задания) тоесть если таск длится например 2 секунды, то scheduledExecutorService не будет ждать 1 секунду,
             * так как она уже истекла, а сразу начнет после окончания этого таска следующий
             */
public class Method_scheduleAtFixedRate {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

      

        scheduledExecutorService.scheduleAtFixedRate(new RunnableImp300(), 3, 1, TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
       
    }
}

class RunnableImp300 implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " begins work");

        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}

/**     output:
 *      pool-1-thread-1 begins work  (через 3секнды начал работу)
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work (чрез 1 секунду)
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work (чрез 1 секунду)
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work (чрез 1 секунду)
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work
        pool-1-thread-1 begins work
        pool-1-thread-1 ends work  (чрез 20 секунд)
 */