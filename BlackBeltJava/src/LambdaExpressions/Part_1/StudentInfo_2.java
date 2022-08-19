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
        
        /**
         * Варианты более короткой записи лямбда выражения:
         */
        info.testStudents(studentsList,  s ->  s.age < 30);
        info.testStudents(studentsList,  s ->  s.avgGrade >8);
        info.testStudents(studentsList,  s ->  s.age>20 && s.avgGrade<9 && s.sex=='f');
        
        /**
         * в лямбда выражениях оператор стрелка разделяет параметры метода и тело метода
         * В лямбда выражении справа от оператора стрелка находится тело метода, которое было бы у соответствующего класса, имплементировавшего 
         * наш интерфейс с единственным методом
         * мы можем писать смешанный тип лямбда выражения, слева например полный а справа короткий и наоборот, но если используем полный справа, то 
         * должны написать return и точка с запятой(тоесть если есть фигурные скобки, должен быть return и ;)
         * Левая часть лямбда выражения может быть написана в краткой форме, если метод интерфейса принимает только один параметр, если параметров несколько, 
         * то нужно брать их в скобки(например если бы в интерфейсе StudentChecks в методе было бы 2 параметра boolean check(Student s, int p) )то
         * info.testStudents(studentsList,  (s,р) ->  s.age меньше  30
         * Если даже в левой части метод имеет 1 параметр, но мы хотим например для читабельности использовать его тип(писать его тип) , то тип вместе с
         * переменной нужно взять в скобки info.testStudents(studentsList,  (Student s) ->  s.age мепньше 30);
         * если в правой части больше одного стейтманта, то обязательно нужны фигурные скобки и точки с запятой например:
         */
        info.testStudents(studentsList,  s ->  {
            System.out.println("Hello"); // первый statement
            return s.age < 30; }); // // второй statement
        /**
         * если наш абстрактный метод не принимал бы никаких параметров, то зпись выглядела бы так:
         *  info.testStudents(studentsList,  () ->  s.age < 30);
         */
        /**
         * можно вообще вынести лямбда выражение из параметра и например присвоить его :
         */
        StudentChecks sc =  s ->  s.age < 30; // и теперь пр вызове метода testStudents на info можно записать так:
        info.testStudents(studentsList, sc); 
        /**
         * разница только в том, что если мы помещаем лямбда выражение в переменную, то потом, можем использовать его несколько раз, а  впервом случае
         * мы используем его 1 раз
         */
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