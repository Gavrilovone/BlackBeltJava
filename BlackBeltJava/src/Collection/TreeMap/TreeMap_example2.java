package Collection.TreeMap;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMap_example2 {

    public static void main(String[] args) {
        TreeMap<Student, Double> treeMap = new TreeMap<>();
        Student st1 = new Student("Иван", "Петров", 3);
        Student st2 = new Student("Николай", "Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр", "Васильев", 4);
        Student st5 = new Student("Мария", "Захарова", 3);
        Student st6 = new Student("Александр", "Калинкин", 4);
        Student st7 = new Student("Анатолий", "Антонов", 1);
        treeMap.put(st1, 5.8);
        treeMap.put(st3, 7.2);
        treeMap.put(st5, 7.9);
        treeMap.put(st2, 6.4);
        treeMap.put(st6, 8.2);
        treeMap.put(st7, 9.1);
        treeMap.put(st4, 7.5);

        System.out.println(treeMap);// {Student{name=Александр, surname=Калинкин, course=4}=8.2, Student{name=Анатолий, surname=Антонов, course=1}=9.1, Student{name=Елена, surname=Кошкина, course=1}=7.2, Student{name=Иван, surname=Петров, course=3}=5.8, Student{name=Мария, surname=Захарова, course=3}=7.9, Student{name=Николай, surname=Иванов, course=2}=6.4, Student{name=Петр, surname=Васильев, course=4}=7.5} - теперь студенты располагаются по возрастанию в алфавитном порядке(имена), так как в качестве ключа используется Student(в compareTO сравниваются String имена)

        /**
         * если наш класс не реализовывает cmparable, то есть еще вариант как можно правильно создать TreeMap, используя уже компаратор:
         
            TreeMap<Student, Double> treeMap2 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;  тут мы прописываем наши условия
                }
            });
        * 
        * 
         */
        
        
        Student st8 = new Student("Анатолий", "Антонов", 1);
        System.out.println(treeMap.containsKey(st8)); // 
        /**
         * true даже если не переопределять equals, потому что тут все поиски и добавления операции происходят при помощи compareTo метода, 
         * но это правило не относится к значениям(но хорошим тоном будет всегда их переопределять)
         */
          System.out.println(treeMap.containsValue(st8)); 
          /**
           * здесь equals используется хотя hashcode не используется вообще
           */
    }
}

    final class Student implements Comparable<Student> {

        final String name;
        final String surname;
        final int course;

        public Student(String name, String surname, int course) {
            this.name = name;
            this.surname = surname;
            this.course = course;
        }

        @Override
        public int compareTo(Student s) {
            return this.name.compareTo(s.name); // будем сравнивать имена
        }

        @Override
        public String toString() {
            return "Student{" + "name=" + name + ", surname=" + surname + ", course=" + course + '}';
        }

        @Override
        public int hashCode() {
            return name.length() * 7 + surname.length() * 23 + course * 12; // (3)
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
