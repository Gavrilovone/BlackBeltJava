
package Collection.Deque_and_ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque - double ended queue (двунаправленная очередь).В такой очереди элементы могут использоваться с обох концов.здесь работают оба правила - FIFI и LIFO
 * Interface Deque реализуется классами LinkedList и ArrayDeque
 */
public class Inteface_Deque {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3); 
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(1); // тоже самое что и addFirst только не выбрасывает исключения
        deque.offerLast(8);
        
        System.out.println(deque); // [1, 5, 3, 7, 8]
        
        System.out.println(deque.removeFirst()); // 1
        System.out.println(deque);               // [5, 3, 7, 8]
        System.out.println(deque.getFirst());   // 5 - первый элемент очереди
        System.out.println(deque.removeLast()); //  8
        System.out.println(deque);              //  [5, 3, 7]
        System.out.println(deque.getLast());   // 7 - последний элемент очереди
        System.out.println(deque.pollFirst());  //  5
        System.out.println(deque);              //  [3, 7]
        System.out.println(deque.peekFirst()); // 3 - первый элемент очереди
        System.out.println(deque.peekLast());  // 7 - последний элемент очереди
        System.out.println(deque.pollLast());  // 7
        
        /**
         * LinkedList тоже иплементирует все эти двойные методы, потому, что он имплементирует интерфейс Deque
         */
     
        
    }
}
