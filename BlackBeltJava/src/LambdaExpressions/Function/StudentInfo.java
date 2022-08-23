package LambdaExpressions.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StudentInfo {

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

        StudentInfo info = new StudentInfo();
        /**
         * Допустим перед нами стоит задача, мы хотим находить среднее арифмитическое у студентов по разным показателям? например курсов или возраста, но
         * код должен принимать в себя любой из этих показателей, в input должен быть студент,  а output например double.чтобы это реализовать, будем использовать
         * интерфейс function
         */
      
        
        double res = avgOfSmth(studentsList, stud -> stud.avgGrade);
        System.out.println(res); // 7.94 среднее арифметическое оценки
        
        double res2 = avgOfSmth(studentsList, stud -> (double)stud.course); // course не является double, но мы можем сделать casting
        System.out.println(res2); // 2.6 средний курс
        
        double res3 = avgOfSmth(studentsList, stud -> (double)stud.age); 
        System.out.println(res3); // 25.4 средний возраст
        
        /**
         * мы вызываем avgOfSmth, передаем arrayList наших студентов и должны с помощью лямбда выражения показать как работает метод apply, метод apply принимает в параметры студента, мы назвали эту переменную stud и возвращаем какой-то double (например avgGrade )
         */
    }
    
    private static double avgOfSmth(List<Student> list, Function<Student, Double> f){
        double result = 0;
        for(Student s: list){
            result+= f.apply(s); // это метод функционального интерфейса Function
        }
        result =  result/list.size();
        return result;
    }
}
