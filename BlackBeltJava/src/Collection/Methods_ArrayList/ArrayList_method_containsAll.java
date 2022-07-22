
package Collection.Methods_ArrayList;
import java.util.ArrayList;
import java.util.List;
/**
 * containsAll(Collection<?> c) -> boolean - проверяет содержит ли наш аррайлист все элементы arrayLista указанного  в параметре
 */
public class ArrayList_method_containsAll {
     public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
             
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Иван");
        arrayList2.add("Мария");
        arrayList2.add("Игорь");
        
        /**
         * будем содержать результат работы метода в отделной переменной:
         */
        boolean result = arrayList1.containsAll(arrayList2); // содержит ли arrayList1 все элементы arrayList2 ?
         System.out.println(result); // false
        
        
    }
}
