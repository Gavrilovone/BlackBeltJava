package Collection.Methods_ArrayList;

import java.util.ArrayList;
/**
 * set(int index, Data Type element) -> Data Type  - Вставляет на определенный индекс элемент ArrayList,  можно рассматривать как
 * replace, тоесть он заменитэлемент на указанном индексе, на элемент аррайлиста который мы укажем в параметре
 */
public class ArrayList_method_set {
public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add(1, "Михаил");
        System.out.println(arrayList1); // [Алексей, Михаил, Иван, Мария]
        
        arrayList1.set(1, "Маша");
        System.out.println(arrayList1); // [Алексей, Маша, Иван, Мария]
        
       
    }
}
