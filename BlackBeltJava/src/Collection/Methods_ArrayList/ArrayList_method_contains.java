package Collection.Methods_ArrayList;

import java.util.ArrayList;
/**
 * contains(Object element) -> boolean - определяет содержит ли наш ArrayList объект указанный в параметре метода и возвращает true если содержит
 * или false если не содержит.здесь так же используется для сравнения метод equals
 */
public class ArrayList_method_contains {
public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
       
        System.out.println(arrayList1.contains("Николай")); // false
        System.out.println(arrayList1.contains("Мария")); // true
    }
}

