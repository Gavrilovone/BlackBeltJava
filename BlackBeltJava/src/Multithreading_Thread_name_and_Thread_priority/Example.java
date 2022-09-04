
package Multithreading_Thread_name_and_Thread_priority;
/**
 * У каждого потока есть имя и приоритет
 */
public class Example {
    public static void main(String[] args) {
        MyThread mythread1 = new MyThread();
        System.out.println("Name of MyThread = " + mythread1.getName() + ", Priority of MyThread = " + mythread1.getPriority()); 
        /** output:
         * Name of MyThread = Thread-0, Priority of MyThread = 5 (Thread-0 - это дефолтное имя если мы сами никак не назвали поток)
         * приоритет 5 это тоже дефолтное значение, приоритетная шкала от 1 до 10 где 10 это наивысший приоритет, приоритет мы также можем изменить
         * но никакой гарантии нет, что приоритет с высшим приоритетом запустится рантше потока с низшим приоритетом
         */
        MyThread mythread2 = new MyThread();
        System.out.println("Name of MyThread = " + mythread2.getName() + ", Priority of MyThread = " + mythread2.getPriority());
        /** output:
         * Name of MyThread = Thread-1, Priority of MyThread = 5
         */
        mythread1.setName("moy potok");
        mythread1.setPriority(9);
        /**
         * можем написать готовые:
         * mythread1.setPriority(Thread.MIN_PRIORITY); приоритет = 1
         * mythread1.setPriority(Thread.NORM_PRIORITY);приоритет = 5
         * mythread1.setPriority(Thread.MAX_PRIORITY);приоритет = 10
         * 
         */
        System.out.println("Name of MyThread = " + mythread1.getName() + ", Priority of MyThread = " + mythread1.getPriority()); 
        /** output:
         * Name of MyThread = moy potok, Priority of MyThread = 9
         */
        
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Privet");
    }
    
}