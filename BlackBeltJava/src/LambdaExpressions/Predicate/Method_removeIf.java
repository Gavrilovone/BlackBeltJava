
package LambdaExpressions.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Method_removeIf {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Privet");
        al.add("Poka");
        al.add("Ok");
        al.add("Uchim Java");
        al.add("A imenno Java");
        
        al.removeIf(element -> element.length() < 5);
       
        /**
         * Каждый элемент прошел через абстрактный метод test  который мы переопределили с помощью лямбда
         */
        System.out.println(al); // [Privet, Uchim Java, A imenno Java]
        
         Predicate<String> p = element -> element.length() < 5; // то же самое
         System.out.println(al);
       
       
    }
}
