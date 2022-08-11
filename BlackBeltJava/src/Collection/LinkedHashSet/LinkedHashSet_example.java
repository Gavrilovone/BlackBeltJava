
package Collection.LinkedHashSet;

import java.util.LinkedHashSet;

/**
 *  LinkedHashSet -  является наследником HashSet.Хранит информацию о порядке добавления элементов.Производительность методов немного ниже, чем у методов HashSet
 *  В основе LinkedHashSet лежит не LinkedHashMap а просто HashMap(по-этому в нем не реализована возможность запоминать последовательность элементов, в зависимости от их последнего использования как у LinkedHashMap).У элементов данного HashMap: ключи - это элементы LinkedHashSet, значения - это константа заглушка  
 * 
 * Его надо использовать тогда, когда нам нужен HashSet, но который запоминает последоательность добавления элементов
 */
public class LinkedHashSet_example {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        
        System.out.println(lhs); // [5, 3, 1, 8, 10]
        lhs.remove(8);
        System.out.println(lhs); // [5, 3, 1, 10]
        System.out.println(lhs.contains(8)); // false 
        System.out.println(lhs.contains(10)); // true 
        
    }
}
