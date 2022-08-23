package LambdaExpressions.Predicate;

import LambdaExpressions.Part_1_2.*;
import java.util.ArrayList;
import java.util.function.Predicate;

public class StudentInfo_2 {
    
    void testStudents(ArrayList<Student> al, Predicate<Student> pr){  // тепепрь вместо нашего by thatcf? прописываем Predicate
        for(Student s: al){
            if(pr.test(s)){ // вызываем абстрактный метод predicate
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
     
   
        info.testStudents(studentsList, (Student s) -> {return s.age < 30;}); 
        
        info.testStudents(studentsList, (Student s) -> {return s.avgGrade >8;});
         
        info.testStudents(studentsList, (Student s) -> {return s.age>20 && s.avgGrade<9.3 && s.sex=='f';});

       /**output:
        * name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
          name= Nicolay, sex= m, age= 28, course= 2, avgGrade= 6.4" 
          name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
          name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 

          ame= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
          name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
          name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 

          name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 
        */
   
        /**
         * В общем все тоже самое, только мы не создаем свой функциональный интерфейс, а используем готовый Predicate
         */
        
        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';
        info.testStudents(studentsList, p1);
        /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Elena, sex= f, age= 19, course= 1, avgGrade= 8.9" 
            name= Mariya, sex= f, age= 23, course= 3, avgGrade= 9.1" 
         */
        info.testStudents(studentsList, p2);
        /** output:
         *  name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
            name= Nicolay, sex= m, age= 28, course= 2, avgGrade= 6.4" 
            name= Petr, sex= m, age= 35, course= 4, avgGrade= 7.0 
         */
        /**
         * эти две фильтрации можно объеденить методом and()
         */
         info.testStudents(studentsList, p1.and(p2)); // name= Ivan, sex= m, age= 22, course= 3, avgGrade= 8.3" 
         
         /**
          * есть еще метод or(),  который говорит:
          */
        info.testStudents(studentsList, p1.or(p2)); // выведи всех студентов, которые проходят хотябы по одной проверке либо p1 либо p2
        
        info.testStudents(studentsList, p1.negate()); // это отрицание , противоположность проверки p1, тоесть выведутся студенты с оценкой не выше 7.5
    }

}

