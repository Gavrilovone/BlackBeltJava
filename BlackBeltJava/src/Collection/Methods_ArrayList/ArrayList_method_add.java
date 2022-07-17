package Collection.Methods_ArrayList;

import java.util.ArrayList;

/**
 * add(Data Type element) -> boolean - добавляет элемент в ArrayList
 * add(int index, Data Type element) -> boolean - если хотим поместить элемент на конкретный индекс в данном случае на 
 */
public class ArrayList_method_add {

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add(1, "Михаил"); // поместить элемент на конкретный индекс в данном случае на 1
        /**
         * можно использовать foreach loop, чтобы вывести на экран элементы ArrayList
         */
        for (String s : arrayList1) {
            System.out.print(s + " "); // Алексей Михаил Иван Мария
        }
    }
}
