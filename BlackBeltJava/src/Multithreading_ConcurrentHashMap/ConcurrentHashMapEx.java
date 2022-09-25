package Multithreading_ConcurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap - имплементирует интерфейс ConcurrentMap, который в свою очередь происходит от интерфейса Map, он делит множество элементов элементов которые он хранит на сигменты
 * В ConcurrentHashMap любое количество потоков может читать элементы не блокируя его
 * В ConcurrentHashMap, благодаря его сегментированию, при изменении какого-либо элмента блокируется только bucked, в котором он находится
 * В ConcurrentHashMap ни key ни value не могут быть null
 */
public class ConcurrentHashMapEx {

    public static void main(String[] args) throws InterruptedException {
        
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Алексей");
        map.put(2, "Олег");
        map.put(3, "Сергей");
        map.put(4, "Иван");
        map.put(5, "Игорь");
        System.out.println(map);
        /**
         * У Map самого нет метода Iterator поэтому чтобы работать с итератором, часто что делают: получают из Map множество его ключей с помощью 
         * метода KeySet() а у KeySeta есть итератор
         * После чего мы сначала спим 100 миллисекунд потом ключ элемента передаем в Integr i переменную(строч.36) и потом выводим на экран ключ(i)
         * и значение которое получаем с помощью этого ключа(map.get(i))
         */
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }

        };
        
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Елена");
        };
        
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
/**
 * Мы создали обычный Map, заполнили его элементами, выволим  его на экран, потом запускаем 2 потока, один поток будет итерироватся и выводить на экран все элементы нашего Map(все пары ключ значение) перед тем как вывести на экран он будет каждый раз 0.1 сек спать
 * Второй поток сначала спит 0,3 сек, потом добавляет в наш hasMap новый элемент
 */

/**
 * output:
 * {1=Алексей, 2=Олег, 3=Сергей, 4=Иван, 5=Игорь}
1 : Алексей
2 : Олег
{1=Алексей, 2=Олег, 3=Сергей, 4=Иван, 5=Игорь, 6=Елена}
Exception in thread "Thread-0" java.util.ConcurrentModificationException
	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1597)
	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1620)
	at Multithreading_ConcurrentHashMap.ConcurrentHashMapEx.lambda$main$0(ConcurrentHashMapEx.java:38)
	at java.base/java.lang.Thread.run(Thread.java:833)
        * 
        * 
        * почему: эти 2 потока работают одновременно, первый производит итерацию, выводит на экран элементы, двоих вывел, третьего нре успел вывести и второй поток поспав добавляет в наш hashMap новый элемент а итератор такие действия не прощает и выбрасывает exception, чтобы этого не происходило нужно добавить Сoncurrent в строчке 17 после чего output:
        * 
{1=Алексей, 2=Олег, 3=Сергей, 4=Иван, 5=Игорь}
1 : Алексей
2 : Олег
3 : Сергей
4 : Иван
5 : Игорь
6 : Елена
{1=Алексей, 2=Олег, 3=Сергей, 4=Иван, 5=Игорь, 6=Елена}
 */