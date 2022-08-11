
package Collection.Interface_Queue;

import java.util.PriorityQueue;

public class Priority_Queue_example {
    public static void main(String[] args) {
        Student st1 = new Student("Zaur", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Olya", 4);
        
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);
        
        System.out.println(priorityQueue.poll()); // Student{name=Misha, course=1}
        System.out.println(priorityQueue.poll()); // Student{name=Igor, course=2}
        System.out.println(priorityQueue.poll()); // Student{name=Marina, course=3}
        System.out.println(priorityQueue.poll()); // Student{name=Olya, course=4}
        System.out.println(priorityQueue.poll()); // Student{name=Zaur, course=5}
        
    }
}
/**
 * если бы класс Student не имплементировал бы Comparable, то выбрасился бы ClassCasEexeption
 */