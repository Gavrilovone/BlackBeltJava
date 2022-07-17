package Collection.Methods_ArrayList;
import java.util.ArrayList;
/**
 * remove(Object element) -> boolean удалает указанный в параметре метода элемент и возвращает true, если элемент найден и удален и false если элемент не найден
 * тоесть он спомощью метод equals сравнивает элемент(объект) который мы хотим удалить с элементами аррайлиста и если такой элемент есть, тоесть проверка 
 * дает true, то элемент удаляется, если такого элемента нет, то возвращается false( пример см.ArrayList_method_remove_obj)
 * e
 * remove(int index) -> Data Type
 * после удаления элементы смещяются влево
 */
public class ArrayList_method_remove {
public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add(1, "Михаил");
        System.out.println(arrayList1); // [Алексей, Михаил, Иван, Мария]
        
        arrayList1.remove(0); // удаляем элемент под 0 индеком - Алексей
        System.out.println(arrayList1); // [Михаил, Иван, Мария]
        
       
    }
}
