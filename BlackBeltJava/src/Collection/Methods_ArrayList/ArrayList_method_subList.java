
package Collection.Methods_ArrayList;
import java.util.ArrayList;
import java.util.List;
/**
 * subList(int fromindex, int toindex) -> List<E> - создает из имеющегося аррайлиста sub лист, тоесть его отрывок, возвращает лист
 */
public class ArrayList_method_subList {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
        arrayList1.add("Елена");
        System.out.println(arrayList1); // [Алексей, Иван, Мария, Петр, Елена]
        List<String> myList = arrayList1.subList(1, 4); // с 1 по 3, 4ый не включается
        System.out.println(myList); // [Иван, Мария, Петр]
        
        /**
         * на самом деле это sub лист не существует по отдельности от этого аррайлиста, он лишь является его представлением
         */
        
        myList.add("Федор");
        System.out.println(myList); // [Иван, Мария, Петр, Федор]
        System.out.println(arrayList1); // [Алексей, Иван, Мария, Петр, Федор, Елена]
        
    }
}
