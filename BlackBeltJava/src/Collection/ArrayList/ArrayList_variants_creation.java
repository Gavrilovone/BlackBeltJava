package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;
/**
 * В основе ArrayList лежит массив Object 
 */
public class ArrayList_variants_creation {

    public static void main(String[] args) {
        /**
         * Варианты создания:
         */
        ArrayList<String> arrayList1 = new ArrayList<String>();

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Алексей");
        arrayList2.add("Иван");
        arrayList2.add("Мария");
        System.out.println(arrayList2); // [Алексей, Иван, Мария]
        
        /**
         * Arraylist на 200 элементов:
         */
        ArrayList<String> arrayList3 = new ArrayList<>(200);
        /**
         * Дело в том, что когда мы создаем ArrayList, создается массив размером 10 это его size(размер), но capacity(вместимость) при этом 0
         * и если мы захотим добавить еще один или несколько элементов, то будет создан новый масив, который скопирует все наши элементы и добавится
         * еще несколько свободных мест.И это будет происходить каждый раз при добавлении элементов, соответственно это занимает время, поэтому если 
         * заранее извесно количиство элементов, лучше указать их в скобках, в данном примере это (200)
         */
        
        List<String> arrayList4 = new ArrayList<>();
        /**
         * ArrayList можно создавать таким образом, потому, что ArrayList имплементирует интерфейс List
         */
        
        ArrayList<String> arrayList5 = new ArrayList<>(arrayList2);
        /**
         * это 4й вариант создания ArrayList, когда мы в параметр нашего ArrayList помещаем другой
         */
        System.out.println(arrayList5); // [Алексей, Иван, Мария]
        /**
         * arrayList5 выглядит так же как и arrayList1, но arrayList5 не ссылается на него, создается новый объект с такими же элементами
         */
        
//        ArrayList<int> arrayList6 = new ArrayList<>();
        /**
         * мы не можем создавать ArrayList с примитивными типами данных, но у каждого примитивного ипа данных есть класс обертка wrapper class
         */
        ArrayList<Integer> arrayList6 = new ArrayList<>();
        
    }
}
