
package Generics;

import java.util.ArrayList;
import java.util.List;


public class Subtyping {
    public static void main(String[] args) {
        X x  = new Y();
        /**
         * мы можем так написать, потому что  можно назначать прееменной parent класса объект child класса, но так написать уже не можем:
         * List<X> list = new ArrayList<Y>();
         * 
         * несмотя на то, что ArrayList это child класс List-а, но в совоукпности ArrayList вместе с инжериком <Y> не является сабклассом листа List<X> 
         * поэтому мы можем написать только так:
         */
        List<X> list = new ArrayList<X>();
        List<X> list = new ArrayList<>(); // это одно и тоже
        
        List<Number> list2 = new ArrayList<Integer>();
        list2.add(18);
        list2.add(3.14);
        /**
         *  double 3,14 является сабклассом Number, но динамически run time будет ошибка, потому что Integer не может содержать в себе double
         * по-этому уже на стадии компиляции уже будет ошибка 
         */
      
    }
}

class X{}

class Y extends X{}

