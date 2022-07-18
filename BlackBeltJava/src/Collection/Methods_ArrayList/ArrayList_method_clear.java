package Collection.Methods_ArrayList;

import java.util.ArrayList;

/**
 * clear() - void - очищает ArrayList
 */
public class ArrayList_method_clear {

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1); // [Алексей, Иван, Мария]
        
        arrayList1.clear();
        System.out.println(arrayList1); // []  всп элементы были удалены
    }
}
