
package Multithreading_Interfaces_Callable_and_Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 */
public class CallableFactorial {
    static int factorialResult;
    public static void main(String[] args) {
     
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Factorial2 factorial2 = new Factorial2(5);
            /**
             * мы не можем здесь использовтаь метод execute, потому что он принимает только Runnable, для этого еть метод submit, этот метод так же как и execute
             * добавляет наш task в thread poll но помимо этого он еще и возвращает результат нашего таска, арезультат нашего таска Callable будет Integer, этот
             * результат хранится в объекте типа Future
             */
            Future<Integer> future = executorService.submit(factorial2);
               try {
                   System.out.println(future.isDone()); // с помощью isDone узнаем закончился ли наш таск
                   System.out.println("Хотим получить результат");
            factorialResult = future.get();// чтобы получить результат таска используется метод get, так же выбрасывает exception
                   System.out.println("Получили результат");
                   System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());// с помощью метода getCause можем выяснить причину по которой exception был выброшен а причина будет Вы ввели не правильное число
        }
        finally{ // executorService всегда очень хорошо закрывать в finally блоках
            executorService.shutdown();
        }
               System.out.println(factorialResult); // 120
    }
}

class Factorial2 implements Callable<Integer>{
    int f;

    public Factorial2(int f) {
        this.f = f;
    }
    
    @Override
    public Integer call() throws Exception{
        if(f <= 0 ){
            throw new Exception("Вы ввели не правильное число");
        }
         int result = 1;
        for(int i = 1; i<=f; i++){
            result*=i;
            Thread.sleep(1000);
        }
        return result;
    }
}

/**
 * когда мы делаем submit и он нам возвращает Future результат работы нашего таска во Future пока что нет, он будет в будущем, когда таск полностью 
 * выполнится поэтому он так и называется, и когда мы пытаемся вытащить из Futurу результат нашего таска используя метод get,  а этот таск еще не 
 * закончил свою работу, наш thread который вызвал get (в данном случае это main) будет заблокирован до тех пор, пока таск не завершится тоесть
 * пока факториал не будет найден и Future не вернет нам результат
 */

/**
 *  output: 
 *  false (еще не закончился)
 *  Хотим получить результат (ждем пока таск работает)
 *  Получили результат
 *  true (таск закончил работу)
  * 120
 */

/**
 * метод submit мы можем использовать с Runnable тоже, только там мы не можем использовать дженерик и метод get который будет вызван на Future всегда
 * будет возвращать null ведь Runnable ничего не возвращает, но для чего его тогда использовать с Runnable? с его помощью можно например узнавать закончился
 * ли таск(метод isDone)
 * 
 * Runnable мы можем использовать как с ExecutorServices так и при создании отдельного Thead, Callable мы можем использовать только с ExecutorServices
 * вообщем если нам не нужно чтобы такс возвращал результат используем Runnable если нужно Callable
 */