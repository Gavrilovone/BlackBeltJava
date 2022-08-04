package Collection.TreeMap;

import java.util.Objects;
import java.util.TreeMap;

public class TreeMap_example3 {

    public static void main(String[] args) {
        TreeMap<Student, Double> treeMap = new TreeMap<>();
        Student st1 = new Student("Иван", "Петров", 3);
        Student st2 = new Student("Николай", "Иванов", 2);
        Student st3 = new Student("Елена", "Кошкина", 1);
        Student st4 = new Student("Петр", "Васильев", 4);
        Student st5 = new Student("Мария", "Захарова", 3);
        Student st6 = new Student("Александр", "Калинкин", 4);
        Student st7 = new Student("Анатолий", "Антонов", 1);
        /**
         * допустим наши ключи добавлены по возрастанию
         */
        treeMap.put(st1, 5.8);
        treeMap.put(st2, 6.4);
        treeMap.put(st3, 7.2);
        treeMap.put(st4, 7.5);
        treeMap.put(st5, 7.9);
        treeMap.put(st6, 8.2);
        treeMap.put(st7, 9.1);
       
        /**
         * при создании дерева, даже если мы будем добавлять элементы в таком порядке(в этом случае получится цепочка из узлов у которых нет 
         * левых сыновей и поиск элемента в таком дереве будет идти очень долго) 
         *          5.8
         *            \
         *            6.4
         *               \
         *               7.2
         *                  \
         *                  7.5
         *                    \
         *                    7.9
         *                      \
         *                      8.2
         *                        \
         *                        9.1
         * 
         * но красно-черное дерево самобаалансирующее, оно в какой-то момент поймет это и с помощью опеределенного алгаритма сбалансирует его
         * 
         *                            7.5
         *                         /       \
         *                       6.4       8.2
         *                      /   \     /   \
         *                     5.8  7.2  7.9  9.1
         * 
         * с помощью такого красного-черного дерева, такие методы как containsKey, get, put, remove обрабатываются за O(log n)
         */
        
     
    }
}


