package Collection.TreeMap;
import java.util.Objects;
import java.util.TreeMap;
/**
 * TreeMap - переводится как дерево.Элементами TreeMap являются пары ключ/значение.В TreeMap элементы хранятся в отсортированном по возрастанию порядке
 * 
 * В основе TreeMap лежит красное дерево.Это позволяет treeMap работать быстро, но не быстрее метода HashMap
 * 
 * основная цель использования treeMap это нахождение каких-то ренджей, тоесть отрезков
 * 
 * Мы не можем использовать в качестве ключа класс, который не имплементирует интерфейс Comparable, то-есть если мы попытаемся в качестве ключа использовать
 * класс Student то вылетит исключение , так как наш класс Student не имплементирует интерфейс Comparable, ведт treeMap хранит ключи в отсортированном виде
 * и жава не сможет понять какой из студентов являетя больше или меньше.Сейчас в примере в качестве ключа используется Double, а в нем интерфейс Comparable
 * реализзован см.пример TreeMap_example2
 * 
 * TreeMap не является синхронизированной коллекцией и если имеется несколько потоков котоые работают с ней, то ее нужно синхронизировать вручную
 */
public class TreeMap_example {

    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student st1 = new Student("Иван","Петров", 3);
        Student st2 = new Student("Николай","Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр","Васильев", 4);
        Student st5 = new Student("Мария","Захарова", 3);
        Student st6 = new Student("Александр","Калинкин", 4);
        Student st7 = new Student("Анатолий","Антонов", 1);
        treeMap.put(5.8, st1);
        treeMap.put(7.2, st3);
        treeMap.put(7.9, st5);
        treeMap.put(6.4, st2);
        treeMap.put(8.2, st6);
        treeMap.put(9.1, st7);
        treeMap.put(7.5, st4);
        System.out.println(treeMap); // {5.8=Student{name=Иван, surname=Петров, course=3}, 6.4=Student{name=Николай, surname=Иванов, course=2}, 7.2=Student{name=Елена, surname=Кошкина, course=1}, 7.5=Student{name=Петр, surname=Васильев, course=4}, 7.9=Student{name=Мария, surname=Захарова, course=3}, 8.2=Student{name=Александр, surname=Калинкин, course=4}, 9.1=Student{name=Анатолий, surname=Антонов, course=1}} - вывелось в порядке возрастания по ключам
        Student st8 = new Student("Анатолий","Антонов", 1);
          treeMap.put(3.2, st8);
          System.out.println(treeMap); // {3.2=Student{name=Анатолий, surname=Антонов, course=1}, 5.8=Student{name=Иван, surname=Петров, course=3}, 6.4=Student{name=Николай, surname=Иванов, course=2}, 7.2=Student{name=Елена, surname=Кошкина, course=1}, 7.5=Student{name=Петр, surname=Васильев, course=4}, 7.9=Student{name=Мария, surname=Захарова, course=3}, 8.2=Student{name=Александр, surname=Калинкин, course=4}, 9.1=Student{name=Анатолий, surname=Антонов, course=1}} - добавился еще один студент с одинаковыми данными, тоесть значения в treeMap могут быть не уникальными(но ключи уникальны) если мы добавим еще одного студента с такми же ключем,  тоон перезапишется 
        /**
         * с помощью метода get получаем  значение по ключу:
         */
        System.out.println( treeMap.get(6.4)); // Student{name=Николай, surname=Иванов, course=2}
        
        /**
         * с помощью метода remove удалим 1 студента:
         */
        treeMap.remove(5.8);
        
        /**
         * метод desendingMap позволяет развернуть наш TreeMap в обратном направлении, чтобы элементы располагались не по возрастанию, а по убыванию(по ключам)
         */
        treeMap.descendingKeySet();
        System.out.println(treeMap);
        
        /**
         * с помощью метода tailMap(хвост) можно найти студентов, у которых балл выше определенного значения например больше 7.2:
         */
        System.out.println(treeMap.tailMap(7.2)); // вывелись студенты st3, st4, st5, st6, st7 
                
        /**
         * с помощью метода headMap(голова) можно найти студентов, у которых балл ниже определенного значения например меньше 7.2:
         */
        System.out.println(treeMap.headMap(7.2));
        
        /**
         * с помощью метода lastEntry мы можем вывести элемент который находится в самом конце нашей коллекции:
         */
        System.out.println(treeMap.lastEntry()); // 9.1=Student{name=Анатолий, surname=Антонов, course=1}
        
         /**
         * с помощью метода firstEntry мы можем вывести элемент который находится в самом начале нашей коллекции:
         */
         System.out.println(treeMap.firstEntry()); // 3.2=Student{name=Анатолий, surname=Антонов, course=1}
    }
}

final class Student {

    final String name;
    final String surname;
    final int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
     }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", course=" + course + '}';
    }

    @Override
   public int hashCode() {
     return name.length()*7 + surname.length()*23 + course*12; // (3)
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.course != other.course) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.surname, other.surname);
    }
    
    
    
    
}
