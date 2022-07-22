
package Collection.Methods_ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * toArray() -> Object[] - из нашего arrayLista получаем массив типа Object
 */
public class ArrayList_method_toArray {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
        arrayList1.add("Елена");
        Object[] array = arrayList1.toArray();
        /**
         * если же мы хотим получить массив String, а не Object, тогда мы будем использовать следующий  метод:
         * toArray(T [] a) -> T[]
         */
        
        String[] array2 = arrayList1.toArray(new String[5]);
        
        for(String s: array2){
            System.out.println(s);
        }
        /**
         * Алексей
           Иван
           Мария
           Петр
           Елена
           * 
           * если мы укажем в скобках (new String[7]) то создасться массив и 2 оставшихся элемента будут null, чтобы не думать о размере массива, 
           * если мы укажем например (new String[2) то java создаст массив необходимого размера, часто можно увидеть (new String[0]) чтобы не думать
           * о размере массива
         */
        
    }
}
