
package Multithreading_Methods_sleap_and_join;

public class Example_join {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.join();
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable{
    @Override
    public void run(){
        System.out.println("Work begins");
        try{
            Thread.sleep(2500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}
/**  output:
 *  Method main begins
    Work begins
    Work ends
    Method main ends
 */

/**
 * Метод main начинает работу, види м на экране Method main begins, потом запускается наш поток и поток main будет ждать окончания нашего потока,
 * внутри нашего потока выводится информация, Work begins, спим 2,5 секунды и потом выводится Work ends и только после этого мы увидим информацию 
 * о том, что метод main завершился
 * 
 * в параметре join можно указать время join(1500) к примеру, в этом случае поток main будет ждать либо окончание работы потока или уазанное 
 * в параметре времени, что из этого закончится первым то и подстегнет поток main продолжить свою работу, в данном случае поток thread не успеет выполнить
 * за 1,5 секунды выполнить свою работу, потому что он спит 2,5 секунды и через 1,5 секунды поток main продолжит свою работу и выведет на  Method main ends
 * и output будет такой
 * 
 * /**  output:
 *  Method main begins
    Work begins
    Method main ends
    Work ends
 */

/**
 * в кратце о состояниях потока:
 * 1 состояние это когда он new(после создания до вызова метода start)
 * когда вызывается start, это состояние называется runnsble(состояние выполнения) и он делится на состояние rady(готовность) и runny(когда поток на самом деле выполняется)
 * 3 состояние terminated(когда работа потока завершена)
 */