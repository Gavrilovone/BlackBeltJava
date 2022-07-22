
package Collection.Methods_ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * List.of(E..element) -> List<E> 
 * List.copyOf(Collection<E> c) -> List<E> - вышли после 8 java
 * оба эти метода на return type имеют элементы определенного типа например List<String> и эти коллекции, эти листы не изменяемы, их невозможно изменить и они не 
 * это очень важное праило! и они не могут содержать значения null
 */
public class ArrayList_method_List_of {
    public static void main(String[] args) {
             
        List<Integer> list1 = List.of(3, 8, 13);
        System.out.println(list1); // [3, 8, 13]
        /**
         * вот так по быстрому создали лист и добавили туда элементы без метода add
         */
        
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
        arrayList1.add("Елена");
        
        List<String> list2 = List.copyOf(arrayList1);
        System.out.println(list2); // [Алексей, Иван, Мария, Петр, Елена]
    }
}
