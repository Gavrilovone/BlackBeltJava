
package Stream.Method_mapToInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * возвращает после себя не просто stream, а int sytream, является(i) и у него так же есть ряд методов( sum, min, max, average)
 */
public class Methods_mapToInt {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nicolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(st1);
        studentsList.add(st2);
        studentsList.add(st3);
        studentsList.add(st4);
        studentsList.add(st5);
        
        List<Integer> courses = studentsList.stream() // Stream<Student>
                .mapToInt(el -> el.getCourse()) // IntStream
                .boxed() // Stream<Integer>
                .collect(Collectors.toList());
        System.out.println(courses); // [3, 2, 1, 4, 3]
        /**
         * мы не можем сохранять ном пера курсов в отдельный лист List<Integer> courses, не смотря на то, что на выходе у нас стрим int, чтобы 
         * это сделать необходимо с помощью метода boxed() преобразовать int в integer
          */
        
        /**
         * тоже самое только для AvgGrade, так как он double, то mapToInt уже не подходит, но есть похожий метод mapToDouble
         */
         List<Double> avGrade = studentsList.stream() // Stream<Student>
                .mapToDouble(el -> el.getAvgGrade()) // DoubleStream
                .boxed() // Stream<Double>
                .collect(Collectors.toList());
        System.out.println(avGrade); // [8.3, 6.4, 8.9, 7.0, 9.1]
        
        /**
         * можно просуммировать курсы студентов
         */
        int sum = studentsList.stream().mapToInt(e -> e.getCourse()).sum();
        System.out.println(sum); // 13
        
         /**
         * можно найти среднее арифметическое курсов студентов
         */
         double average = studentsList.stream().mapToInt(el -> el.getCourse()).average().getAsDouble();
         System.out.println(average); // 2.6
         /**
          * average возвращает optionalDouble поэтому если не получить это значение через getAsDouble(), то мы не сможем
          * присвоить перменной double average это выражение
          */
         
          /**
         * можно найти минимальный курс студентов
         */
         int minCourse = studentsList.stream().mapToInt(e -> e.getCourse()).min().getAsInt();
         System.out.println(minCourse); // 1
         /**
          * min так же возвращает optionalInt
          */
         
          int maxCourse = studentsList.stream().mapToInt(e -> e.getCourse()).max().getAsInt();
         System.out.println(maxCourse); // 4
    }
}
