
package Collection.Interface_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue(jxthtlm) = это базовый интерфейс, который хранит последовательность элементов для какой-нибудь обработки используется для того, чтобы 
 * проводить опереции с самым первым стоящим в очереди элементом? тоесть простая очередь где соблюдается правило FIFO first in first out
 * 
 * LinkedList имплементирует не тольно интерфейс List, но и интерфейст Deque
 */
public class Queue_and_LinkedList {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        /**
         * метод add добавляет элемент в конец очереди
         */
        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Marya");
        queue.add("Aleksandr");
        System.out.println(queue); // [Zaur, Oleg, Ivan, Marya, Aleksandr]
          /**
           * так как очередь не ограничена то все работает нормально, но если бы она была ограничена например 3мя элементами, то при добавлении 4го
           * выбрасывался бы exeption, поэтому добавлять элементы в ограниченную очередь можно с помощью метода offer, да, 4й элемент так же не добавится,
           * но исключение выбрасываться не будет
           */
          
          /**
           * метод remove() возвращает удаленный элемент, естественно работа идет с элементов который первым стоит в очереди
           */
          System.out.println(queue.remove()); // Zaur
          
          /**
           * если применить remove() количество раз, больше чем элементов есть в данном случае 6, то выбросится NoSuсhElementExeption,  но если удалять
           * методом poll() то exeption выбрасываться не будет, он вернет null 
           */
          
          /**
           * метод element() показывает первый элемент в очереди
           */
          System.out.println(queue.element()); // Oleg  после удаления Заура первый элемент в очереди теперь Олег
          /**
           * если применить element() при пустой очереди, то выбросится NoSuсhElementExeption,  но если воспользоваться методом
           * методом peek() то exeption выбрасываться не будет, он вернет null 
           */
          
          /**
           * на самом деле есть возможность например удалить элемент из середины, а не тот который первый в очереди
           */
          
          queue.remove("Ivan");
          System.out.println(queue); //[Oleg, Marya, Aleksandr]
          /**
           * но если часто так делать, то смысл очереди теряется и лучше использовать другую коллекцию
           */
          
          
          
    }
}
