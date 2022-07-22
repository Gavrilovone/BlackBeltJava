
package Collection.Methods_ArrayList;
import java.util.ArrayList;
import java.util.List;
/**
 * removeAll(Collection<?> с) -> boolean - удаляет из нашего ArrayLista все элементы arraylista указанного в параметре 
 */
public class ArrayList_method_removeAll {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
        System.out.println(arrayList1); // [Алексей, Иван, Мария, Петр]
        
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Иван");
        arrayList2.add("Мария");
        arrayList2.add("Игорь");
        
        arrayList1.removeAll(arrayList2);
        System.out.println(arrayList1); // [Алексей, Петр]
    }
}
