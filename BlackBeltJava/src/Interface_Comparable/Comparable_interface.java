/**
 * Из названия понятно, что этот интерфейс нужен для сравнения, но не просто на предмет равны они или нет, но чтобы узнавать какой например больше меньше
 * чтобы потом мы могли сортировать в какой-то коллекции
 * 
 * Интерфейс Comparable используется для сравнения объектов, используя естественный порядок
 * чтобы его имплементировать, нужно перезаписать его единственный метод int compareTo(Element E);
 */
package Interface_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Comparable_interface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Maria");
        list.add("Ivan");
        list.add("Aleksey");
        System.out.println("before sort");
        System.out.println(list);
        System.out.println("");
        System.out.println("after sort");
        Collections.sort(list);
        System.out.println(list);
        
        /**
         *  before sort
            [Maria, Ivan, Aleksey]

            after sort
            [Aleksey, Ivan, Maria]
         */
        
        
        
    }
}
