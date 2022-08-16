package LambdaExpressions.Part_1;

import java.util.ArrayList;

public class StudentInfo_2 {
    
    /**
     * нам достаточно написать один метод:
     */
    
    void testStudents(ArrayList<Student> al, StudentChecks sc){ // StudentChecks sc -  это объект класса, который будет имплементировать интерфейс StudentChecks
        for(Student s: al){
            if(sc.check(s)){
                System.out.println(s);
            }
        }
        System.out.println("");
    }

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

        StudentInfo_2 info = new StudentInfo_2();
        info.testStudents(studentsList, new CheckOverGrade());
        /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
            name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1"
         */
         info.testStudents(studentsList, new StudentChecks(){ // создаем анонимный класс
            @Override
            public boolean check(Student s){
                return s.age < 30;
            }
        });
         /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Nicolay, sex= m, age= 28, course= 2, avgGrade= 6.4" 
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
            name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1"
         */
         info.testStudents(studentsList, (Student s) -> {return s.age < 30;}); // мы заменили анонимный класс лямбда выражением(это одно из возможных написаний)
        /**
         * Лямбда выражение сокращает код, не нужно писать new StudentChecks(),  @Override а только сам метод и позволяет нам в качестве параметра использовать метод(это функциональный стиль программирования)
         */
        info.testStudents(studentsList, (Student s) -> {return s.avgGrade >8;});
         /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
            name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1"
         */

        info.testStudents(studentsList, (Student s) -> {return s.age>20 && s.avgGrade<9 && s.sex=='f';});
        
    }

}

interface StudentChecks {

    boolean check(Student s);
    /**
     * этот интерфейс называется функциональным, функциональный это тот интерфейс который содержит всего один абстрактный метод(других статических или дефолтных
     * может быть сколько угодно, но абстрактный один) и благодаря этому, java понимает в лямбда выражении о каком методе идет речь
     */
}

/**
 * создадим класс, который будет имплементировать интерфейс StudentChecks и будет проводить фильтрацию подобно той, где мы выводил на экран студентов с 
 * оценкой меньше определенного значения:
 */

class CheckOverGrade implements StudentChecks{
    @Override
    public boolean check(Student s){
    return s.avgGrade > 8; 
    }
}

/**
 * этот подход не очень хороший, во первых потому, что нам приходитс вручную писать условие return s.avgGrade > 8; если нам понадобится например написать >9 
 * то придется писать еще один класс
 * 
 * заменить этот класс CheckOverGrade нам поможет анонимный класс
 * 
 * либо можно использовать лямбда выражения
 */