package Collection.Methods_ArrayList;

import java.util.ArrayList;
import java.util.Objects;
/**
 * indexOf(Object element) -> int - принимает в параметр объект и возвращает его позицию или -1 если такой объект 
 * в нашем ArrayListу не найден.Здесь так же работает сравнение искомого объекта среди элементов нашего  ArrayLista
 * с помощью метода equals, если несколько одинаковых элементов, то он находит первое совпадение
 * 
 * lastIndexOf((Object element) -> int ) тоже самое, только он находит последнее совпадение
 */
public class ArrayList_method_indexOf {

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
        
        Student st6 = new Student("Петр", 'm');
        int index = list.indexOf(st6);
        System.out.println(index); // -1
        /**
         * после переопределения метода equals, st6 будет сравниваться с другими объектами и объекты будут считаться равными если у них равные поля 
         * если работать например со String, то метод equals там переопределен изначально
         */
        
        System.out.println(index); // 3 под 3м индексом находится st4, поля st4 и st6 равны, объекты считаются равными
        
                     
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
}
      