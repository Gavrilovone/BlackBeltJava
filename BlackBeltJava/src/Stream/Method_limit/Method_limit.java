
package Stream.Method_limit;

import java.util.ArrayList;
import java.util.List;

/**
 * метод stream ограничивает количество элементов в нашем стриме, возвращает stream (i)
 */
public class Method_limit {
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
        
        studentsList.stream().filter(e->e.getAge() > 20).limit(2).forEach(System.out::println);
        /** output:
         *  name=Ivan, sex=m, age=22, course=3, avgGrade=8.3
            name=Nicolay, sex=m, age=28, course=2, avgGrade=6.4
            
            несмотря на то, что пройдя через фильтр, под условие возраст больше 20 лет подходят 4 студента, у нас выводится 2 потому что, лимит ограничивает
            стрим который на выходе до двух
         */
    }
}
