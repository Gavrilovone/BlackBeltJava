
package Stream.Method_sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Method_sorted {
    public static void main(String[] args) {
        int[] array = {3,8,1,5,9,12,4,21,81,7,18};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array)); // [1, 3, 4, 5, 7, 8, 9, 12, 18, 21, 81]
        
        
        
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
        
        studentsList =  studentsList.stream().sorted((x,y) ->
                x.getName().compareTo(y.getName())
        ).collect(Collectors.toList());
        System.out.println(studentsList); // [name=Elena, sex=f, age=19, course=1, avgGrade=8.9, name=Ivan, sex=m, age=22, course=3, avgGrade=8.3, name=Mariya, sex=f, age=23, course=3, avgGrade=9.1, name=Nicolay, sex=m, age=28, course=2, avgGrade=6.4, name=Petr, sex=m, age=35, course=4, avgGrade=7.0]
        /**
         * поместили в парметры метода sorted лямбда выражение с компаратором иначе будет exeption, так java не знает по какому кртерию сравнивать
         */
    }
    
}
