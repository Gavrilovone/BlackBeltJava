
package Stream.Method_filter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Method_filter {
    /**
     * метод filter фильтрует данные из определенного набора
     */
    
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
        /**
         * отфильтруем студентов возраст > 22 лет  с оценкой больше 7.2
         * 
         * filter вернет стрим с теми студентами которые пройдут этот фильтр
         */
        studentsList = studentsList.stream().filter(element 
                -> element.getAge()> 22 && element.getAvgGrade() < 7.2
        ).collect(Collectors.toList());
        
        System.out.println(studentsList); // [name=Nicolay, sex=m, age=28, course=2, avgGrade=6.4, name=Petr, sex=m, age=35, course=4, avgGrade=7.0]
        
        
        /**
         * мы можем создать стрим с нуля:
         */
        Stream <Student> myStream = Stream.of(st1, st2, st3, st4, st5); // в скобках указываем что будет содержать наш стрим
        myStream.filter(element // это уже стрим и нам не нужно вызывать на нем метод стрим
                -> element.getAge()> 22 && element.getAvgGrade() < 7.2 // дальше все тоже самое
        ).collect(Collectors.toList());
        /**
         * чаще используется стрим из готовой коллекции, но такой вариант имеет место быть
         */
                
        
    }
}
