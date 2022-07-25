
package Collection.Equals_and_hascode;

import java.util.Objects;

/**
 * Есть правило в java, если вы переопределили метод equals то и переопределите hashcode, он может быть даже не понадобится, но если вдруг понадобится и 
 * он не будет переопределен, то в нашем коде появится очень много неожиданностей и ошибок
 */
public class Equals_and_hascode {
    
}

class Student{
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", course=" + course + '}';
    }
    
     
    
}