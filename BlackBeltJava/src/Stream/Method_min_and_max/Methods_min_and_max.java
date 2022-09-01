
package Stream.Method_min_and_max;
/** 
 * методы min i max являются (t)
 */
import java.util.ArrayList;
import java.util.List;

public class Methods_min_and_max {
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
         * найдем минимального студента
         */
        Student min = studentsList.stream().min((x,y) -> x.getAge() - y.getAge() ).get(); 
        /**
         * java не знает какой из студентов является минимальныйм поэтому метод min ожидает, что мы опишем в нем компаратор(будем читать, что минимальный студент 
         * тот, который младше всех)
         */
        System.out.println(min); // name=Elena, sex=f, age=19, course=1, avgGrade=8.9
        
        /**
         * найдем таким же образом максимального студента
         */
        Student max = studentsList.stream().max((x,y) -> x.getAge()-y.getAge()).get();
        System.out.println(max); // name=Petr, sex=m, age=35, course=4, avgGrade=7.0
    }
}
