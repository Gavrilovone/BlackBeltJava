
package Multithreading__Synchronized_Collections;

import java.util.ArrayList;

/**
 * Когда нам нужна коллекция с которой будут работать больше одого потока? мы можем выбираь из двух вариантов:
 * 1.Synchronized collections  - которые получают из традиционных коллекций благодаря их обертыванию(Collections.synchronizedXYZ(Коллекция)) с помощью
 * Collections класса мы вызываем synchronized, где XYZ - это List, ArrayList, Map, Set и тд и потокобезопасность обспечивается после этого за счет того, что
 * такие обернутые коллекции используют лок всех своих методов и поэтому если один поток захочет например удалить элемент, второй добавить, то в arrayList будет
 * доступ только по одному потоку.Performance(производительность) бывает не очень хорошая потому что все время ставятся локи, это занимает время, многие потоки 
 * стоят в очереди и ждут, вообщем гораздо меньше чем у Concurrent коллекций
 * 
 * 2.Concurrent collections - изначально созданы для работы с многопоточностью
 */
public class SynchronizedCollectionsEx1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                source.add(i);
            }
            
            ArrayList<Integer> target = new ArrayList<>();
            Runnable runnable = () -> {target.addAll(source);}; // в ArrayList target будем добавлять все элементы из ArrayLista source с помощью Lambda, и чтобы это действие выполнялось двумя потоками:
            
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);
            thread1.start();
            thread2.start();
            thread1.join(); // чтобы главный поток main дождался завершения работы  потоков thread1 и thread2
            thread2.join();
            System.out.println(target);
    }
}

/**
 * output:
 * [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]
 * [0, 1, 2, 3, 4] в один из запусков так, это означает, что добавляя в target элементы , наш результат невозможно предугадать
 * синхронизируем ArrayList см SynchronizedCollectionsEx2
 */