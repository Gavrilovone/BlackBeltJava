
package Collection.LinkedList;

import java.util.LinkedList;
/**
 * Элементы LinkedList это звенья одной цепочки, эти элементы хранят определенные данные, а так же ссылки на предыдущий и 
 * следующий элементы(тоесть в основе LinkedList лежит не массив а цепочка)
 * по другому его еще называют связанный список
 * бывает DOBVLI Linked List и SINGLI LinkedList.DOBVLI это когда элемент хранит 2 ссылки на предыдущий элемент и на следующий,
 * вообщем это стандартный линкедлист.Когда программисты делают свой линкедлист и чтобы каждый элемент например имел только
 * одну ссылку на след элемент, такой LinkedList называется SINGLI
 * 
 */
public class LinkedList_example {
    public static void main(String[] args) {
        Student st1 = new Student("Иван", 3);
        Student st2 = new Student("Николай", 2);
        Student st3 = new Student("Елена", 1);
        Student st4 = new Student("Петр", 4);
        Student st5 = new Student("Мария", 3);
        
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        
        
        studentLinkedList.add(st1);
        studentLinkedList.add(st2);
        studentLinkedList.add(st3);
        studentLinkedList.add(st4);
        studentLinkedList.add(st5);
        
        System.out.println("LinkedList = " + studentLinkedList); // LinkedList = [Student{name='Иван', course=3}, Student{name='Николай', course=2}, Student{name='Елена', course=1}, Student{name='Петр', course=4}, Student{name='Мария', course=3}]
        
        System.out.println(studentLinkedList.get(2)); // Student{name='Елена', course=1}
        
        /**
         * чтобы вывести на экран элемент под индексом 2, джава проходит по всему списку начиная спервого элемента
         */
        
        Student st6 = new Student("Алексей", 3);
        Student st7 = new Student("Сергей", 2);
        studentLinkedList.add(st6);
        
        System.out.println("LinkedList = " + studentLinkedList); // LinkedList = [Student{name='Иван', course=3}, Student{name='Николай', course=2}, Student{name='Елена', course=1}, Student{name='Петр', course=4}, Student{name='Мария', course=3}, Student{name='Алексей', course=3}]
        studentLinkedList.add(1,st7); // добавляем Сергеея на позицию под индексом 1
        System.out.println("LinkedList = " + studentLinkedList); // LinkedList = [Student{name='Иван', course=3}, Student{name='Сергей', course=2}, Student{name='Николай', course=2}, Student{name='Елена', course=1}, Student{name='Петр', course=4}, Student{name='Мария', course=3}, Student{name='Алексей', course=3}]
        
        /**
         * это добавление не затронуло другие элементы, просто изменились ссылки: Иван который находится на под индексом 0 теперь ссылается на Сергея
         * а Николай который ссылался на предыдущий элемент(котрый для него был Иван) теперь ссылается на Сергея
         */
        
        studentLinkedList.remove(3); // удалим элемент который находится на 3 индексе 
         System.out.println("LinkedList = " + studentLinkedList); // LinkedList = [Student{name='Иван', course=3}, Student{name='Сергей', course=2}, Student{name='Николай', course=2}, Student{name='Петр', course=4}, Student{name='Мария', course=3}, Student{name='Алексей', course=3}]
         
         /**
          * так же при удаленни у нас просто меняется ссылка Николая на следующий элемент, теперь он ссылается на Петра и меняется ссылка Петра на предыдущий 
          * элемент, теперь Петр ссылается на Николая вместо Елены
          * 
          * Но на самом деле объект Елена никуда не денется из памяти, он просто перестает бытьсоставной частью нашего LinkedLista и это происходит очень быстро,
          * просто меняются ссылки а на другие элементы это никак не влияет.в ArrayListe например при удалении этого элемента все оставшиеся элементы пришлось
          * бы смещать влево, чтобы заполнить пустое место, но если этих элементов тысячи это занимает определенное время
          * 
          * таким образом как правило:
          * - Если мы работаем с коллекцией в которой мы  постоянно будем  вызывать какой-то элемент,производить поиск какого-то элемента,
          * если мы будем работать с методом get например, то более рационально использовать ArrayList потому что поисх элементов в ArrayList моментален
          * потому что он в своей основе использует массив,  a get в LinkedList работает далеко не моментально, пока он дойдет до элемента, он пройдет все
          * элементы которые находятся до него
          * - Если при рааботе с коллекцией операции с поиском элементов не часты, а часты операции добавления, удаления элементов(особенно если речь идет
          * о элементах вначале коллекции), то лучше использовать LinkedList(если добавлять или удалять нужно в начале списка)
          * 
          * Но на самом деле лучше работать с ArrayList потому что он работает быстрее и подходит пратически под все задачи лучше чем LinkedList
          */
        
    }
}

class Student{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }
    
    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course + 
                '}';
    }
}
