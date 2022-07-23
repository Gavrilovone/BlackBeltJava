package Collection.Interface_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_example {

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Алексей");
        arrayList1.add("Иван");
        arrayList1.add("Мария");
        arrayList1.add("Петр");
        arrayList1.add("Елена");

        Iterator<String> iterator = arrayList1.iterator();
        while(iterator.hasNext()) // пока есть следующий элемент
            System.out.println(iterator.next());
        
        /** output:
         *          Алексей
                    Иван
                    Мария
                    Петр
                    Елена
         */
      
        
        /**
         * одно из отличий от foreach loopa это то, что при использовании Iteratora мы можем удалить элемент
         */
        Iterator<String> iterator2 = arrayList1.iterator();
        while (iterator2.hasNext()) { // с помощью hasNext проверяем есть ли след элемент
            iterator2.next(); // с помощью next() мы получаем этот элемент, если мы его не используем будет exception при попытке удалить элемнет
            iterator2.remove(); // с помощью remove() мы удаляем этот элемент
        }
        System.out.println(arrayList1); // []
    }

}
