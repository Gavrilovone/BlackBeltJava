package Collection.Methods_ArrayList;

import java.util.ArrayList;
/**
 * size() -> int - показывает размер ArrayLista
 */
public class ArrayList_method_size {
 public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1.size()); // 3 - размер arrayList1 равен трем
        
        
    }
}
