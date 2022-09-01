
package Stream.Method_skip;

import java.util.ArrayList;
import java.util.List;

/**
 * метод skip так же как limit ограничивает количество элементов нашего стрима, но в отличие от метода limit(который оставлял первые n-элементов нашего стрима),
 * метод skip будет пропускать первые n-элементов нашего стрима, я вляется(i)
 */
public class Method_skip {
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
        
        studentsList.stream().filter(e-> e.getAge() > 20).skip(2).forEach(System.out::println);
        /**
         *  output: 
         *  name=Petr, sex=m, age=35, course=4, avgGrade=7.0
            name=Mariya, sex=f, age=23, course=3, avgGrade=9.1
            * 
            * skip пропустил первых двух студентов Ivan, Nikolay несмторя на то что они проходят через фильтр
         */
        
    }
}
