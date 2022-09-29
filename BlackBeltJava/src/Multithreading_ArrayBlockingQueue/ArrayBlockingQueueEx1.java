
package Multithreading_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue - это потокобезопасная очередь с ограниченным размером помимо своих методов, имеет все методы интерфейса  Queue
 * Обычно один или несколько потоков добавляют  элементы в конец очереди, а другие потоки забирают элементы из начала очереди (см.ArrayBlockingQueueEx2)
 */
public class ArrayBlockingQueueEx1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4); // наша очередь может содержать тльок 4 элемента
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        queue.add(5); при попытке добавить пятый элемент выбросится исключение IllegalStateException: Queue full(очередь полная)
        queue.offer(5); // при добавлении элемента методом offer исключение не выбросится, но элемент не добавится
        System.out.println(queue); // [1, 2, 3, 4]
        
    }
}
