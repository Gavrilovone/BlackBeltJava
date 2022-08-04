package Collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * LinkedHashMap является наследником HashMap.Хранит информацию о порядке добавления элементов или порядке использования, 
 * производительность методов немного ниже, чем у методов HashMap
 */
public class LinkedHashMap_example {

    public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>();
        Student st1 = new Student("Иван", "Петров", 3);
        Student st2 = new Student("Николай", "Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр", "Васильев", 4);
        
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);
        lhm.put(7.2, st3);
        lhm.put(6.4, st2);
       
        /**
         *  в каком порядке мы добавили, в таком и будут содержаться эти элементы
         */
        
        System.out.println(lhm); // {7.5=Student{name=Петр, surname=Васильев, course=4}, 5.8=Student{name=Иван, surname=Петров, course=3}, 7.2=Student{name=Елена, surname=Кошкина, course=1}, 6.4=Student{name=Николай, surname=Иванов, course=2}}






    }

}





