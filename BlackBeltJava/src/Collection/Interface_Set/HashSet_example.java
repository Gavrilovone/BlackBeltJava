
package Collection.Interface_Set;

import java.util.HashSet;

public class HashSet_example {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);
        System.out.println(hashSet1); // [1, 2, 3, 5, 8]
        
        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(5);
        hashSet2.add(3);
        hashSet2.add(8);
        System.out.println(hashSet2); // [3, 4, 5, 7, 8]
        
        
        /**
         * какие математические операции можно выполнять
         * операция union(объединение), объеденим наши множества с помощью метода addAll
         */
        
        HashSet<Integer> union = new HashSet<>(hashSet1);// так как в параметре hashSet1 то union такой же как и он
        union.addAll(hashSet2);
        System.out.println(union); // [1, 2, 3, 4, 5, 7, 8]
        
        /**
         * операция intersect(пересечение), пересечением является то, что является общим для обоих множеств, в данном случае это 5,7,8
         * за пересечене отвечает метод retainAll
         */
        
        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);
        System.out.println(intersect); // [3, 5, 8] пересечением являются эти числа
        
        /**
         * операция subtract(разность) если мы от первого множества отнимем второго, то останется часть, за эту операцию отвечает метод
         * removeAll
         */
        
        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);
        System.out.println(subtract); // [1, 2]
    }
}
