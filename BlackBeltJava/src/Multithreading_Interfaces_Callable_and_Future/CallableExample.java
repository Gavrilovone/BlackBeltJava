
package Multithreading_Interfaces_Callable_and_Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Будем искать сумму чисел от одного 1 млрд не используя формулы, обычным сложением десятью потоками 1й от 1-100 000 000, 2й от 100 000 001 до 200 000 и тд
 */
public class CallableExample {
    private static long value = 1_000_000_000L;
    private static long sum = 0;
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService =  Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();// для удобства отображения результатов создали лист
        /**
         * для того , чтобы в for разбросать числа от 1 до млрд на 10 тасков , нам понадобится дополнительная переменная
         */
        long valueDividedBy10 = value/10;
        for(int i = 0; i < 10; i++){
            long from = valueDividedBy10*i+1; 
            long to = valueDividedBy10*(i+1); 
            
            /**
             * первая итерация(i = 0) 100 000 000*0+0 = 0 то есть from мы начинаем считать с нуля до скольки считаем 100 000 000*(0 + 1) = 100 000 000
             * вторая итерация(i = 1) 100 000 000*1+1 =100 000 001 то есть from мы начинаем считать с нуля до скольки считаем 100 000 000*(1 + 1) = 200 000 000
             */
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum =  executorService.submit(task);
            futureResults.add(futurePartSum);
            
        }
        for (Future<Long> result: futureResults){
            sum+=result.get();
        }
        executorService.shutdown();
        System.out.println("Total sum = " + sum);
    }
}

class PartialSum implements Callable<Long>{// PartialSum(частичная сумма)
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
        
    }
    @Override
    public Long call(){
        for(long i = from; i <= to; i++){
            localSum+=1;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
} 
/** output:
 *  Sum from 400000001 to 500000000 = 100000000
    Sum from 1 to 100000000 = 100000000
    Sum from 300000001 to 400000000 = 100000000
    Sum from 200000001 to 300000000 = 100000000
    Sum from 100000001 to 200000000 = 100000000
    Sum from 500000001 to 600000000 = 100000000
    Sum from 600000001 to 700000000 = 100000000
    Sum from 700000001 to 800000000 = 100000000
    Sum from 800000001 to 900000000 = 100000000
    Sum from 900000001 to 1000000000 = 100000000
    Total sum = 1000000000
 */