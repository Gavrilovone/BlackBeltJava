package Collection.TreeSet;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSet_example {

    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>(); 
/**
 * ли не имплементировать или при создании не использовать в параметре Comparator то вылетит СlassCastExeption
 */
        Student st1 = new Student("Zaur", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 2);
        Student st5 = new Student("Olya", 4);
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(treeSet); // [Student{name=Misha, course=1}, Student{name=Igor, course=2}, Student{name=Olya, course=4}, Student{name=Zaur, course=5}]
        System.out.println(treeSet.first()); // Student{name=Misha, course=1} 
        System.out.println(treeSet.last()); // Student{name=Zaur, course=5}
        
        Student st6 = new Student("Oleg", 3);
        /**
         * будем выводить всех студентов, которые учатся на крсе ниже чем олег
         */
        System.out.println(treeSet.headSet(st6)); // [Student{name=Misha, course=1}, Student{name=Igor, course=2}]
        /**
         * будемвыводить студентов которые учатся на курсе таком же , что и олег либо выше
         */
        System.out.println(treeSet.tailSet(st6)); // [Student{name=Olya, course=4}, Student{name=Zaur, course=5}] 
        
        /**
         *  метод subSet позволяет получить множество, котрое находится между двумя какими-то показателями
         */
        System.out.println(treeSet.subSet(st2, st4)); // [Student{name=Misha, course=1}]
        
        /**
         * желательно придерживаться правила, что если a.equals(b) -> true  
         *                                        то и a.compareTo(b) -> 0 
         * по-этому переопределим методы equals и hashcode убрав из них сравнение по имени, оставив только поле курс
         */
        
        System.out.println(st3.equals(st4)); // true  так как одинаковые курсы
        System.out.println(st3.hashCode()); // 93
        System.out.println(st4.hashCode()); // 93  
        System.out.println(st3.hashCode() == st4.hashCode()); // true
        
    }
}

class Student implements Comparable<Student> { 

    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student other) {

        return this.course-other.course;

    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", course=" + course + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.course;
        return hash;
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
        Student student = (Student) obj;
        return course == student.course;
    }
    
    
}
