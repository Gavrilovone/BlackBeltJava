package Collection.Methods_ArrayList;

import java.util.ArrayList;

/**
 * isEmpty() -> boolean - возвращает true если наш ArraList пуст и false если он не пуст
 */
public class ArrayList_method_isEmpty {

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1.isEmpty()); // false
        arrayList1.clear();
        System.out.println(arrayList1.isEmpty()); // true
    }
}
