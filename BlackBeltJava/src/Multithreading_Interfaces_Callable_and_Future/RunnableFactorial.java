
package Multithreading_Interfaces_Callable_and_Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Рассмотрим пример как мы можем найти факториал используя Runnable и ExecutorService
 * факториал  числа n это произведение всех чисел от 1 до n , тоесть факториал числа 5! = 1*2*3*4*5 = 120
 */
public class RunnableFactorial {
    static int factorialResult;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS); 
        /**
         * если мы не попросим наш поток подождать с помощью awaitTermination, тогда наш main поток сразу будет выводить factorialResult, тоесть
         * он не дождетя выполнения метода run и выведет factorialResult а его значение здесь равно 0;
         */
        System.out.println(factorialResult); // 120
        
    }
}


class Factorial implements Runnable{
    int f; 
    public Factorial(int f){
        this.f = f;
    }
    @Override
    public void run(){
        if(f <= 0 ){
            System.out.println("Вы ввели неверное число");
            return; // таким образом мы заканчиваем работутметода
        }
        int result = 1;
        for(int i = 1; i<=f; i++){
            result*=i;
        }
        RunnableFactorial.factorialResult = result;
    }
}

/**
 * Какие недостатки есть у этого способа, а именно чего нам не хватает в runnable: нам приходится использовта  переменную вне runnable(factorialResult),
 * чтобы перезать значение result, а все потому что return type runnable это void, так же мы не можем в нем вызвать exception, а очень хотелось бы 
 * например в строке 37 если кто-то введет непраивильное число, чтобы не выводить это на экран а  вбросить исключение
 * 
 * но есть интерфейс который называется Collable, который очень похож на runnable, но ко всему прочему может возвращать значение и позволяет выбрасывать исключение
 */