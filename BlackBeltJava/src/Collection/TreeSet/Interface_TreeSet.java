
package Collection.TreeSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet хранит элементы в отсортированном по возрастанию порядке.В основе TreeSet лежит TreeMap(Красно-черное дерево).У элементов данного TreeMap: 
 * ключи - это элементы TreeSet, значения - это константа заглушка 
 */
public class Interface_TreeSet {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(10);
//      treeSet.add(null); так же как и TreeMap null хранить не может
        System.out.println(treeSet); // [1, 2, 5, 8, 10]
        treeSet.remove(2);
        System.out.println(treeSet); // [1, 5, 8, 10]
        System.out.println(treeSet.contains(1)); // true
    }
}
