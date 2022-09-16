
package Multithreading_Thread_poll_and_ExecutorService_part2;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * метод scheduleWithFixedDelay - выполнит таск впервые через 3 секунды и потом период 1 секунда означает время между окончанием первого таска и началов второго
 */
public class Method_scheduleWithFixedDelay {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImp400(), 3, 1, TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
        

    }
}

class RunnableImp400 implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " begins work");

        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
