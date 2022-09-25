
package Multithreading__Synchronized_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionsEx2 {
     public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                source.add(i);
            }
            
            List<Integer> synchList = Collections.synchronizedList(new ArrayList<>()); // в параметр можно поместить и уже существующую коллекцию 
            Runnable runnable = () -> {synchList.addAll(source);}; 
            /**
             * synchList - это синхронизированная оббертка для новосозданного ArrayList или по другому говорят synchronized view(синхронизированнй вид
             * для новосозданного ArrayList)
             */
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);
            thread1.start();
            thread2.start();
            thread1.join(); 
            thread2.join();
            System.out.println(synchList);
    }
}

/**
 * output:
 * [0, 1, 2, 3, 4, 0, 1, 2, 3, 4] - сколько бы запусков небыло, результат один
 * 
 * один из потоков, мы не занем какой начинает добавлять в synchList элементы и в этот момент, доступ для всех остальных потоков закрыт и лишь 
 * по окончании его работы, к работе приступает второй поток. Здесь у листа synchList в каждом методе, в тм числе методе addAll() стоит лок,
 * Даже если 2 потока должны выполнить разную работу используя разные методы все равно будет работать только один поток, от этого призводительность страдает
 * рассмотрим SynchronizedCollectionsEx3
 */