
package Multithreading_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Задача: допустим очередь может содержать не более 4х элементов, у нас есть producer(производит числа) и consumer(потребитель)
 * Первый добавляет элементы в очередь каждую секунду, а второй забирает их каждые 3 сек, все это происходит  по правилу FIFO
 */
public class ArrayBlockingQueueEx2 {
    public static void main(String[] args) {
         ArrayBlockingQueue<Integer>  arrayBlockingQueue =  new  ArrayBlockingQueue<>(4);
         /**
          * Запустим 2 потока, первый добавляет, второй забирает
          */
         
        // producer
        new Thread(()-> { 
            
        int i = 0;
            while (true) {
                try {
                    arrayBlockingQueue.put(++i); // начинаем с еденицы 
                    System.out.println("Producer добавил : " + i + " " + arrayBlockingQueue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // consumer
        new Thread(() -> {

            while (true) {
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer забрал : " + j + " " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}


/**
Consumer забрал : 1 []
Producer добавил : 1 []
Producer добавил : 2 [2]
Producer добавил : 3 [2, 3]
Consumer забрал : 2 [3]
Producer добавил : 4 [3, 4]
Producer добавил : 5 [3, 4, 5]
Producer добавил : 6 [3, 4, 5, 6]
Consumer забрал : 3 [4, 5, 6]
Producer добавил : 7 [4, 5, 6, 7]
Consumer забрал : 4 [5, 6, 7]
Producer добавил : 8 [5, 6, 7, 8]
Consumer забрал : 5 [6, 7, 8]
Producer добавил : 9 [6, 7, 8, 9]
Consumer забрал : 6 [7, 8, 9, 10]
Producer добавил : 10 [7, 8, 9, 10]
Consumer забрал : 7 [8, 9, 10]
Producer добавил : 11 [8, 9, 10, 11]
* 
* и так далее
 */