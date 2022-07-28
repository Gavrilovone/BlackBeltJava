
package Collection.Equals_and_hascode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Есть правило в java, если вы переопределили метод equals то и переопределите hashcode, он может быть даже не понадобится, но если вдруг понадобится и 
 * он не будет переопределен, то в нашем коде появится очень много неожиданностей и ошибок
 * 
 * - Результат результат нескольких выполнений метода heshcode для одного и того же объекта должен быть одинаковый
 * - Если согласно методу equals 2 объекта равны, то и хешкод данных объектов должен быть одинаковым
 * - Если согласно методу equals 2 объекта НЕ равны, хешкод данных объектов не обязательно должен быть разным
 * 
 * в дефолтной реализации heshcode если не переопределять его , то там импользуется в алгоритме адрес объекта, поэтому каждый новый объект, даже при равенстве 
 * всех полей будет иметь уникальный heshcode
 */
public class Equals_and_hascode {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>(); // ключ будет Студент, оценка Double значение
        Student st1 = new Student("Алексей", "Гаврилов", 3);
        Student st2 = new Student("Сергей", "Петров", 1);
        Student st3 = new Student("Мария", "Иванова", 4);
        map.put(st1, 7.5);
        map.put(st2, 9.2);
        map.put(st3, 6.8);
        System.out.println(map); // {Student{name=Мария, surname=Иванова, course=4}=6.8, Student{name=Алексей, surname=Гаврилов, course=3}=7.5, Student{name=Сергей, surname=Петров, course=1}=9.2}
        
        Student st4 = new Student("Алексей", "Гаврилов", 3); // создадим копию студента
        boolean result = map.containsKey(st4);// проверяем есть ли такой студент в нашем map
        System.out.println("result = " + result); // false несмотря на то, что для equals объекты st1 и st4 одинаковые 
        System.out.println(st1.equals(st4)); // true
        /**
         * HashMap и HashSet относятся к колекциям которые используют хеширование при сравнении, тоесть даже если у нас переопределен правильно метод equals, 
         * без переопределенного heshcode наше сравнение будет неудачным
         * Если мы не переоределим equals а переопрелелим hashcode, то result будеь false, так как сравнение сначала идет по equals
         * 
         * в пердыдущем примере см.Interface_HashMap у нас все работало хорошо, потому что в классе String и equals и hascode переопределены, здесь в классе
         * double тоже, но вот в ключе которым является наш клас Studend нет
         */
        System.out.println(st1.hashCode()); // 1243857909 (1)
        System.out.println(st2.hashCode()); // 1605460291 (1)
        
        Student st5 = new Student("Николай", "Петров", 5);
        
        System.out.println(st1.hashCode());// 18 (2)
        System.out.println(st5.hashCode()); // 18 (2)
       
        
        /**
         * когда у разных объектов с разными полями одинаковый heshcode это называется коллизией, этого надо избегать, это значит 
         * что наш переопределенный heshcode не так хорош, тем меньше коллизий в нашем коде тем лучше, обычно в хешкоде какие-то значения
         * умножаются на простые числа, чтобы коллизий было меньше
         */
        
        System.out.println(st1.hashCode());// 269 (3)
        System.out.println(st5.hashCode()); // 247 (3)
        System.out.println(st4.hashCode()); // 269 (3)
    }
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

//  (1)  @Override    такой вариант перопределения предлагает netBeens 
//    public int hashCode() {
//        return Objects.hash(name, surname, course);
//    }
    
    /**
     * мы можем написать своюр еализацию hascode
     */
    
    
//  (2)  @Override
//    public int hashCode() {
//       return name.length() + surname.length() + course; // 
//    }

    @Override
   public int hashCode() {
     return name.length()*7 + surname.length()*23 + course*12; // (3)
   }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.course != other.course) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.surname, other.surname);
    }
    
     
    
}