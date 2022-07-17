package Collection.Methods_ArrayList;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayList_method_remove_obj {

}

class Student {

    String name;
    char sex;
 

    Student(String name, char sex) {
        this.name = name;
        this.sex = sex;
     

    }
    @Override
     public String toString(){
         return "Имя: " + name + " Пол: " + sex; 
     }
   
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student st1 = new Student("Иван", 'm');
        Student st2 = new Student("Николай", 'm');
        Student st3 = new Student("Елена", 'f');
        Student st4 = new Student("Петр", 'm');
        Student st5 = new Student("Мария", 'f');
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);
        System.out.println(list); // [Имя: Иван Пол: m, Имя: Николай Пол: m, Имя: Елена Пол: f, Имя: Петр Пол: m, Имя: Мария Пол: f]
        list.remove(st5);
        System.out.println(list);// [Имя: Иван Пол: m, Имя: Николай Пол: m, Имя: Елена Пол: f, Имя: Петр Пол: m]
        /**
         * но если мы захотим удалить элемент из ArrayLista которого нет:
         */
        Student st6 = new Student("Петр", 'm');
        list.remove(st6);
        System.out.println(list); // [Имя: Иван Пол: m, Имя: Николай Пол: m, Имя: Елена Пол: f, Имя: Петр Пол: m]
        /**
         * то мы увидим, что элемент не удалился, так происходит потому, что когда мы пытаемся удалить элемент(объект) ArrayLista, происходит
         * поиск этого объекта в ArrayListe и если такой элемент есть он удаляется, если нет, не удаляется.это происходит с помощью метода equals,
         * который в ArrayListe не переопределен(тоесть он такой, какой он предоставляется класcом Object, а метод equals в Objecte такой же как и == т.е
         * 2 объета считаются равными друг другу если они ссылаются на один объект в памяти) Здесь же у нас, не смотря на то, что st4 и st6 имеют одинаковые
         * параметры, они ссылаются на разные объекты и при сравнении дают false.Поэтому если мы хотим, чтобы элемент Петр удалился при написании 
         * list.remove(st6); а не  list.remove(st4); нужно переопределить метод equals
         */
        
       
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
        if (this.sex != other.sex) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
     
    /**
     * после переопределения equals объекты считаются равными, если у них равны поля и не важно что это разные объекты, после чего элемент удалился
     */
   }
