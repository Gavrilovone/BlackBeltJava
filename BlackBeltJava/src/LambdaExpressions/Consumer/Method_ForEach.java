
package LambdaExpressions.Consumer;

import java.util.ArrayList;
import java.util.List;

public class Method_ForEach {
    public static void main(String[] args) {
        List<String> list  = List.of("privet", "kak dela", "normalno", "poka");
        /**
         * если нам нужно было вывести по одному все элементы этого листа, мы использовали foreach loop:
         */
        
        for(String s: list){
            System.out.println(s);
            /**
             *  privet
                kak dela
                normalno
                poka
             */
        }
        
        /**
         * но можно сделать это по-другому:
         */
        list.forEach(s -> System.out.println(s));
        
        /**
         *  privet
            kak dela
            normalno
            poka
         */
        
        /**
         * метод forEach принимает в качестве параметра consumer, мы передаем ему, что нужно сделать для каждого элемента? потому что consumer это потребитель
         * мы передаем элемент и дальше как его нужно потребить, как мы его должны использовать.Каждый элемнт данного листа это String (пусть это будет 
         * переменная s) - это действие будет происходитьь для каждого элемента нашего листа
         */
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
       
        list2.forEach(element ->{
            System.out.println(element); // вывест на экран
            element*=2; // увеличить в 2 раза
            System.out.println(element); // снова вывести на экран
        });
        
        /**
         *  1 
            2 увеличился в 2 раза
            2 вывелся на экран  
            4 увеличился в 2 раза
            3 вывелся на экран
            6
            4
            8
            5
            10
         */
    }
}
