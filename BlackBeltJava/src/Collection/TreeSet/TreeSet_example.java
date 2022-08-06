package Collection.TreeSet;

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
}
