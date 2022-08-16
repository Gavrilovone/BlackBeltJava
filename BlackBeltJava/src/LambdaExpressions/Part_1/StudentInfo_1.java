package LambdaExpressions.Part_1;

import java.util.ArrayList;

public class StudentInfo_1 {

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

        StudentInfo_1 info = new StudentInfo_1();
        info.printStudentsOverGrade(studentsList, 8);  // вывод студентов, чьи оценки выше 8
        /**
         *  output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9
             name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1
         */
        
        info.printStudentsUnderAge(studentsList, 30); // вывод студентов которым меньше 30 лет
        /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Nicolay, sex= m, age= 28, course= 2, avgGrade= 6.4" 
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
            name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 
         */
        
        info.printStudentsMixCondition(studentsList, 20, 9.5, 'f');
        
        /** output:
         *  name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 
         */
    }

    /**
     * Допустим у нас есть 5 студентов, нередки случаи когда нам нужно фильтровать студентов по разным показателям, например по возрасту оценке или курсу.Создадим 3 метода:
     */
    void printStudentsOverGrade(ArrayList<Student> al, double grade) { // фильтровать по оценке
        for (Student s : al) {
            if (s.avgGrade > grade) { // если оценка больше указанной в параметре метода, то выводим на экран
                System.out.println(s);
            }
        }
        System.out.println("");
    }

    void printStudentsUnderAge(ArrayList<Student> al, int age) {
        for (Student s : al) {
            if (s.age < age) {
                System.out.println(s);
            }
        }
        System.out.println("");
    }

    void printStudentsMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
        for (Student s : al) {
            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
                System.out.println(s);
            }
        }
        System.out.println("");
    }
}

/**
 * Если нам понадобится новая фильтрация, то нам придется добавлять новый метод в класс StudentInfo, но это не всегда  удобно 
 * и не всегда можно достучаться до него.Мы можем в качестве второго варианта не писать эти методы, а создать интрефейс см.StudentInfo_2
 */ 