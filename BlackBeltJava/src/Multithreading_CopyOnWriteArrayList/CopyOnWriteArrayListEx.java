
package Multithreading_CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList - имплементирует интерфейс List, его нужно использовать тогда, когда нам нужно добиться поткобезопасности, у вас небольшое 
 * количество операций по изменению элементов и большое количество по их чтению
 * CopyOnWriteArrayList - это коллекция типа ArrayList но с алгоритмом CopyOnWrite,  при каждом изменении элементов этой коллекции создается клон копия листа
 * нового вида
 * есть еще CopyOnWriteArraySet - который работает по схожему сценарию
 */
public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Алексей");
        list.add("Олег");
        list.add("Иван");
        list.add("Петр");
        list.add("Игорь");
        System.out.println(list);
            
        Runnable runnable1 = () ->{
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };
        
         Runnable runnable2 = () ->{
             try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             list.remove(4);
             list.add("Елена");
         };
         
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}

/**
 * в output будет выбрасываться  exception если мы будем использовать просто ФккфнДшые, потому что с ArrayList нельзя делать такие вещи, нужно использовать CopyOnWriteArrayList
 * 
 * 
[Алексей, Олег, Иван, Петр, Игорь]
Алексей
Олег
Иван
Петр
Игорь
[Алексей, Олег, Иван, Петр, Елена]
* 
* Здесть пред тем как мы начали итерироваться итератором по все коллекции, итератору пердалось состояние этой коллекции на момент создания итератора и он 
* выводит только эти элементы во втором потоке(строчка 42) создалась копия данной коллекции, потом добавили элемент (строчка 43) создалась еще одна копия данной
* коллекции и только после того как итератор закончил работу, старая копия уже никому не нужна и на строчке 45 идет уже работа с самой новой копией, разумеется 
* это очень затратно, по-этому если много операций по изменению коллеции, то CopyOnWriteArrayList лучше не использовать
 */