
package Collection.HashTable;


import java.util.Hashtable;

/**
 * HashTable - это устаревший класс, который работает по тем же принципам, что и HashMap, в отличие от HashMap является synchronized(тоесть его можно
 * использовать при работе с многопоточностью), по этой причине его методы далеко не такие быстрые
 * 
 * в отличие от HashMap в HashTable ни ключ ни значение не могут быть null
 * 
 * даже если поддержка многопоточности, HashTable лучше не использовать, лучше использовать ConcurrentHashMap
 */


public class HashTable {
    public static void main(String[] args) {
        Hashtable<Double, Student> ht = new Hashtable<>(); // даже хинт подсказывает Obsolete Collection (устаревшая коллекция)
        
        Student st1 = new Student("Иван", "Петров", 3);
        Student st2 = new Student("Николай", "Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр", "Васильев", 4);
        ht.put(7.8, st1);
        ht.put(9.3, st2);
        ht.put(5.8, st3);
        ht.put(6.0, st4);
    }
}
