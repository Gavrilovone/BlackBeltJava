
package Stream.Method_flatMap;
/**
 * метод flatMap мы используем тогда, когда нам нужно поработать не с самими элементами нашей коллекции, а с элементами элементов нашей коллекции
 * так же является является (i) - intermediate
 */
import java.util.ArrayList;
import java.util.List;

public class Method_flatMap {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nicolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
        
        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Applied mathematics"); // прикладная математика
        
        f1.addStudentOnFaculty(st1);
        f1.addStudentOnFaculty(st2);
        f1.addStudentOnFaculty(st3);
        f2.addStudentOnFaculty(st4);
        f2.addStudentOnFaculty(st5);
        
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);
        
        /**
         * например мы хотим вывести имена всех студентов из всех факультетов
         */
        
        facultyList.stream().flatMap(faculty -> faculty.getstudentsOnFaculty().stream()).forEach(el -> System.out.println(el.getName()));
        /**
         * С помощью метода flatMap и вызова метода stream на каждом елементе листа факультетов мы для каждой нашей коллекции создаем отдельный стрим и
         * все эти стримы, можно сказать в итоге, образуют один большой стрим из всех элементов facultyList
         */
        
        /**
         * output:
         *          Ivan
                    Nicolay
                    Elena
                    Petr
                    Mariya
         */
    }
}

class Faculty{
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }
    /**
     * создаем конструктор и в конструкторе создаем новый arrayList
     */
    
    public List<Student> getstudentsOnFaculty(){
        return studentsOnFaculty;
    }
    
    public void addStudentOnFaculty(Student st){ // метод который добавляет студентов в лист
        studentsOnFaculty.add(st);
    }
}