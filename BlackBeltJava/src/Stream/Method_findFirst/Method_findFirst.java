package Stream.Method_findFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * метод findFirst - возвращаетпервый элемент нашего стрима, является (t) turned
 */
public class Method_findFirst {

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
        
               
        Student first = studentsList.stream().map(el -> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).filter(el -> el.getSex() == 'f').findFirst().get();
        System.out.println(first); // name=ELENA, sex=f, age=19, course=1, avgGrade=8.9
        
                

   
    }

}
