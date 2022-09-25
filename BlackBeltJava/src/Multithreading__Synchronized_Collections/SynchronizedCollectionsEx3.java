
package Multithreading__Synchronized_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionsEx3 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> sychList = Collections.synchronizedList(arrayList);
        /**
         * с помощью итератора будем выводить все элеенты данного ArrayList на экран
         */
        Runnable rannable1 = () -> {
            synchronized (sychList) {
                Iterator<Integer> iterator = sychList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        
        Runnable rannable2 = () -> sychList.remove(10); // удаляется один элемент

        Thread thread1 = new Thread(rannable1);
        Thread thread2 = new Thread(rannable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sychList);
    }
    
}
/**
 * через раз может выбрасываться Exception 
 * 
 * Exception in thread "Thread-0" java.util.ConcurrentModificationException
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, ..998, 999]
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
	at Multithreading__Synchronized_Collections.SynchronizedCollectionsEx3.lambda$main$0(Synchroniz        edCollectionsEx3.java:27)
	at java.base/java.lang.Thread.run(Thread.java:833)
 */


/**
 * Для перебора элементов в коллекции мы можем использовать Iterator, однако итераторы подвержены сбоям при работе с многопоточностью, так например
 * если один поток изменяет содержимое коллекции, а второй поток обрабатывает его итератором то при вызове методов итератором hasNext или next будет 
 * выброшено исключение ConcurrentModificationException,  чтобы обезопасить приложение от вызова исключения, необходимо целиком блокировать лист на время
 * перебора.Да, когда вызывается метод remove, никакой другой поток не сможет ни добавить элемент в коллецию, ни как-то его изменить, но во время итерации
 * никакого лока не происходит? мы должны этот лок прописать  вручную, чтобы все нормально работало(строч.25) и теперь во время перебора метод remove не будет 
 * вызван
 */