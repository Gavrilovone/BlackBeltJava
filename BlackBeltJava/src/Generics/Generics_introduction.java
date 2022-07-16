/**
 * Generics introduction(Дженерики введение)
 * Зачем нужны generics:
 * 2 основные причины существования дженериков это:
 * - Type safe
 * - Reusable code 
 */
package Generics;

import java.util.ArrayList;
import java.util.List;

public class Generics_introduction {
    public static void main(String[] args) {
//         List  list = new ArrayList();  rawtype(сырой тип) ели не указываем типа, так писать вообще не стоит
           List<String> list = new ArrayList<>();
        /**
         * Из-за того, что в основе ArrayList лежит массив object, мы можем добавить в него что угодно, различные типы данных:
           
             list.add("ok");
             list.add(5);
             list.add(new StringBuilder("Привет"));
             list.add(new Car());
            
         * но так практически никто не делает, можно столкнуться с определенными проблемами  
         */
        
              
        list.add("Привет");
        list.add("Пока");
        list.add("ок");
        list.add("Доброе утро");
        
//     for(String s : list ) так написать не можем потому, что когда мы не параметризируем наши листы они содержат Object
       for(Object o : list){
           System.out.println(o + " длина " + ((String)o).length()); // нужно кастить до String Object o, чтобы можно было узнать 
           
           /**
            * output:
            * Привет длина 6
              Пока длина 4
              ок длина 2
              Доброе утро длина 11
              * 
              * но если например мы получили список из вне и не знаем корректо ли там указаны типы, и если там будет кроме String другие типы например 
              * Саr или int,  то у нас вылетит ClassCastExeptions, потому что эти типы не могут кастится до String
              * 
              * одно из важнейших понятий связанных с дженериками это type save(типа безопасность), тоесть если мы захотим  в лист типа String 
              * List<String> list = new ArrayList<>(); добавить другой тип, нам уже на уровне компиляции выдаст ошибку
            */
           
           
       }    
    }
}
class Car{}
