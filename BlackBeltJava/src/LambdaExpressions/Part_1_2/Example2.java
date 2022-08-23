package LambdaExpressions.Part_1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Example2 {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nicolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(st1);
        studentsList.add(st2);
        studentsList.add(st3);
        studentsList.add(st4);
        studentsList.add(st5);

        Collections.sort(studentsList, new Comparator<Student>() { // используем анонимный класс 
            @Override
            public int compare(Student s1, Student s2) {
                return s1.course-s2.course;
            }
        });
        System.out.println(studentsList);
        /**
         * output:
         * [name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" , name= Nicolay, sex= m, age= 28, course= 2, avgGrade= 6.4" , name= Ivan, sex= m, age= 22, cour           se= 3, avgGrade= 8.3" , name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" , name= Petr, sex= m, age= 35, course= 4, avgGrade= 7.0" ]

         */
        
        Collections.sort(studentsList, (stud1, stud2) -> stud1.course-stud2.course); // тоже самое только с лямбда выражением
    }
}
