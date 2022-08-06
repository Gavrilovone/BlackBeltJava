
package Collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Objects;
public class LinkedHashMap_example_with_constructor {
      public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16, 0.75f, false); 
        /**
         * 16 - InitialCapacity, 0.75f - loadFactor,  false - accessOrder(параметр который показывае как мы хотим сохранять порядок : 
         * добавление элементов(false), или использование элементов(true))
         */
        Student st1 = new Student("Иван", "Петров", 3);
        Student st2 = new Student("Николай", "Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр", "Васильев", 4);
        
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);
        lhm.put(7.2, st3);
        lhm.put(6.4, st2);
       
        System.out.println(lhm); 
       // {7.5=Student{name=Петр, surname=Васильев, course=4}, 5.8=Student{name=Иван, surname=Петров, course=3}, 7.2=Student{name=Елена, surname=Кошкина, course=1}, 6.4=Student{name=Николай, surname=Иванов, course=2}}
        LinkedHashMap<Double, Student> lhm2 = new LinkedHashMap<>(16, 0.75f, true); 
        Student st5 = new Student("Иван", "Петров", 3);
        Student st6 = new Student("Николай", "Иванов", 2);
        Student st7 = new Student("Елена", "Кошкина", 1);
        Student st8 = new Student("Петр", "Васильев", 4);
        
        lhm2.put(7.5, st5);
        lhm2.put(5.8, st8);
        lhm2.put(7.2, st7);
        lhm2.put(6.4, st6);
        
        System.out.println(lhm2);
          // {7.5=Student{name=Иван, surname=Петров, course=3}, 5.8=Student{name=Петр, surname=Васильев, course=4}, 7.2=Student{name=Елена, surname=Кошкина, course=1}, 6.4=Student{name=Николай, surname=Иванов, course=2}}
          /**
           * здесь элементы вывелись на экран в порядке использования, в данном случае методом put, первым добавился st5значит он первый отображается, последний
           * был добавлен st6 вообщем если стоит ccessOrder то порядок постоянно будет меняться в зависимости от того в каком порядке элементы будут использованы
           */
          System.out.println(lhm2.get(6.4));
          System.out.println(lhm2.get(7.2));
          
          System.out.println(lhm2);
          // {7.5=Student{name=Иван, surname=Петров, course=3}, 5.8=Student{name=Петр, surname=Васильев, course=4}, 6.4=Student{name=Николай, surname=Иванов, course=2}, 7.2=Student{name=Елена, surname=Кошкина, course=1}}
          /**
           * последним стал st7, пердпоследним st6
           */



    }
}
