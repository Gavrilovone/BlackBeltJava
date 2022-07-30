package Collection.TreeMap;
import java.util.TreeMap;
/**
 * TreeMap - переводится как дерево.Элементами TreeMap являются пары ключ/значение.В TreeMap элементы хранятся в отсортированном по возрастанию порядке
 */
public class TreeMap {

    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
    }
}

class Student {

    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }
}
