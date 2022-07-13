
package Generics;

import java.util.ArrayList;

public class Parametrized_method {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(10);
        al1.add(20);
        al1.add(5);
        int a =  GetMethod.getSecondElement(al1);
        System.out.println(a); // 20
        
        ArrayList<String> al2 = new ArrayList<>();
        al2.add("abc");
        al2.add("def");
        al2.add("ghi");
        String s =  GetMethod.getSecondElement(al2);
        System.out.println(s); // def 
    }
}

class GetMethod{
    public static<T> T getSecondElement(ArrayList<T> al){
        return al.get(1); // в методе хочу постоянно возвращать 2й элемент ArrayLista(этот элемент будет типа Т)
        
        /**
         * <T> говорит о том, что это параметризированный метод
         * Т - то что метод возвращает тип Т 
         */
    }
}
/**
 * примечание: если у нас есть праметризированный класс например class Info <V>{ } то place holder <V> можно не писать в методе, так как java и так
   понимает что за типбудет возвращаться в методе:
 */
class Info <V> {
    public V getInfo (V value){
        return value;
    }
    
   
}