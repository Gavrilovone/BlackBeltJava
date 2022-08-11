
package Collection.Interface_Queue;

import java.util.PriorityQueue;

public class Priority_Queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(4);
            priorityQueue.add(1);
            priorityQueue.add(7);
            priorityQueue.add(10);
            priorityQueue.add(8);
            
            /**
             * для  PriorityQueue не обращает внимание на порядок добавления, а работает с элементами по приоритету используя натуральную последовательность
             * тоесть происходит сортировка(наивысший приоритет имеет наименьший элемент) и здесь приоритетность будет в таком виде 1 4 7 8 10
             */
              
            System.out.println( priorityQueue.peek()); // 1 -  первый элемент в очереди 
            
            /**
             * причем очень интересный момент, если просто выводить на экран, то не происходит естественная сортировка, как мы видим 10 идет раньше 8
             * но при использовании например при удалении методом remove,  8 по приоритету удалится раньше чем 10
             */
            
            System.out.println(priorityQueue); // [1, 4, 7, 10, 8]
            /**
             * метод remove возвращает удаляемый элемент
             */
            System.out.println(priorityQueue.remove()); // 1
            System.out.println(priorityQueue.remove()); // 4
            System.out.println(priorityQueue.remove()); // 7
            System.out.println(priorityQueue.remove()); // 8
            System.out.println(priorityQueue.remove()); // 10
    }
        
}
