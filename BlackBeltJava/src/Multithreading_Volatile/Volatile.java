
package Multithreading_Volatile;
/**
 * Volatile переводитс как изменчивый, непостоянный и используется для пометки переменной, как хранящейся только в основной памяти "main memory"
 * 
 * для синхронизации значения переменной между потоками ключевое слово volatile используется  тогда, когда один поток может изменять значение 
 * этой переменной, а остальные потоки могут его только читать
 */
public class Volatile extends Thread {
    volatile boolean b = true;
    
    @Override
    public void run(){
        long counter = 0;
        while(b){ // пока и = true
            counter++;
        
        }
        System.out.println("Loop is finished. counter = " + counter);
    }
    
    public static void main(String[] args) throws InterruptedException {
        Volatile thread = new Volatile();
        thread.start();
        Thread.sleep(3000); // здесь вызываем sleep для потока main, чтобы поток thread поработал 3 секунды 
        System.out.println("After 3 seconds it is time to wake up");
        thread.b = false;
        thread.join();
        System.out.println("End of programm");
    }
}
/**
 * output:
 * After 3 seconds it is time to wake up
 * 
 * Почему так произошло, почему переменная b не приняла значение false и наш луп не остановился  ипрограмма не остановила свою работу: 
 * Потому что в многопоточных программах где потоки работают с переменными, каждый поток может скопировать значение переменной из общей памяти,
 * которая называется main Memory  в кеш CPU( каждый в свой кеш) это делается для ускорения работы кеш это быстрая область памяти.В данном случае 
 * значение переменной b записывается  в CPU1 который относится к потоку thread и  CPU2 который относится к потоку main и в какой то момент(через 3 секунды) 
 * в потоке main мы меняем значение имени для переменной с true на false, это значение хранится в кеше и самый главный факт заключается в том, что мы не
 * знаем когда это измененное состояние b вновь попадет в main memory(когда он там изменится с true на false) и кеш CPU1 прочитает это значение false и 
 * изменит его у себя тоже.Тоесть у нас ситуация когда во всех областях памти b true и оно меняется только в кеше CPU2 с которым работает поток main, 
 *а в кеше CPU1 находится пержнее значение true потому кеш CPU1 разговаривает с main memory, а main memory не получила от кеша CPU2 обновленное значение переменной b
 * 
 * чтобы избежать этой ситуации, мы используем ключевое слово volatile, когда наша переменная volotile, ее значение будет хранится не в кеше, 
 * а  только в main memory и тогда рассинхронизации значений этой переменной среди потоков не будет
 */

/**
 *   output после того как мы написали ключевое слово volatile
 *   After 3 seconds it is time to wake up
     Loop is finished.counter = 3162859320
     End of programm
 */