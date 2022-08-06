
package Collection.Interface_Set;

import java.util.HashSet;

  /*
                                                                Set
                                                           /          \
                                                      HashSet       SortedSet
                                                        |               |
                                                    LinkedHasSet    NavigableSet
                                                                        |
                                                                      TreeSet
Set - это коллекция, хранящая уникальные элементы, методы этой коллекции очень быстры
В основе HashSet лежит урезанный HashMap(используется только ключ), тоесть при создании HashSet со значением "Alexey" создается HashMap у которого 
ключ будет "Alexey" , а значение не нужно потому что в HashSet используется только ключ, по-этому  HashMap просто как заглушку будет хранить какую-то константу
*/                

/**
 * Set - это коллекция, хранящая уникальные элементы, методы этой коллекции очень быстры В основе HashSet лежит урезанный HashMap(используется только ключ),
 * тоесть при создании HashSet со значением "Alexey" создается HashMap у которого ключ будет "Alexey" , а значение не нужно потому что в HashSet 
 * используется только ключ, по-этому  HashMap просто как заглушку будет хранить какую-то константу на которую HashSet не обращает никакого внимания
 * 
 * HashSet как и HashMap не запоминает порядок добавления
 * так же является not synchronized
 * 
 * если мы будем использовать в качестве ключа объект, то так же важно переопределить методы equals и hascode(так как в основе HashSet лежит HashMap)
 */
public class Interface_Set {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Alexey"); // когда мы вызываем метод add, то он под капотом вызывает метод put который принадлежит HashMap
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        set.add("Igor"); // когда java видит, что такой элемент уже существует во множестве, она просто его не добавляет
        
        System.out.println(set); // [Igor, Oleg, Alexey, Marina]
        
        set.remove("Marina");
        System.out.println(set); // [Igor, Oleg, Alexey]
        
        System.out.println(set.size()); // 3
        System.out.println(set.isEmpty()); // false  (проверяем пустой ли наш Set)
        System.out.println(set.contains("Oleg")); // true (содержит ли данный элемент)
        /**
         * все эти методы есть у всех коллекций которые имплементируют интерфейс Collections и Set это не исключение
         * в Set нет метода get? потому что в этом нет смысла.В HashMap мы искали значение по ключу, а тут только ключ
         */
        
         /**
         * так же можно с помощью foreach:
         */
        for(String s : set){
            System.out.println(s); 
            /**  output:
             *   Igor
                 Oleg
                 Alexey
             */
    
    }

        }
}
       