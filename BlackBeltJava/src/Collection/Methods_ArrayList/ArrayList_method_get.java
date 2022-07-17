package Collection.Methods_ArrayList;

import java.util.ArrayList;

/**
 * get(int index) -> data type - возвращает элемент на определенной позиции, с определенным индексом такого же типа как и элемент нашего ArrayLista
 */
public class ArrayList_method_get {

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add(1, "Михаил");

        System.out.println(arrayList1.get(2)); // Иван
        
        for(int i = 0; i < arrayList1.size(); i++){
            System.out.println(arrayList1.get(i));
                                                   /**
                                                    *  Алексей
                                                       Михаил
                                                       Иван
                                                       Мария
                                                    */
        }
    }
}
