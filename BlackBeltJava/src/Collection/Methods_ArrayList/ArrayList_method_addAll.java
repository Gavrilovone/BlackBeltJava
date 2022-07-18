package Collection.Methods_ArrayList;

import java.util.ArrayList;
/**
 * addAll(ArrayList aL) -> boolean - добавляет все элементы ArrayLista и размещает их в конец списка
 * addAll(int index, ArrayList aL) -> boolean - добавляет элементы начиная с определенной позиции
 */
public class ArrayList_method_addAll {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        System.out.println(arrayList1); // [Алексей, Иван, Мария]
        
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");
        
        arrayList1.addAll(arrayList2);
        System.out.println(arrayList1); // [Алексей, Иван, Мария, !!!, ???]
        
        arrayList1.addAll(0, arrayList2);
        System.out.println(arrayList1); // [!!!, ???, Алексей, Иван, Мария, !!!, ???]
    }
}
