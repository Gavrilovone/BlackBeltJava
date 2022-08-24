
package Stream.Method_forEach;

import java.util.Arrays;

/**
 * forEach возвращает void, этот метод позволяет проходить по всем элементам и например выводить на экран эти элемнеты
 */
public class Method_forEach {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(el -> {el*=2; System.out.println(el);}); // никакой необъодимости в преобразовании стрима для вывода нет
        /** output:
         *  10
            18
            6
            16
            2
         */
        Arrays.stream(array).forEach(el -> System.out.println(el));
        /**
         * это напиание можно сократить:
         */
        Arrays.stream(array).forEach(System.out::println); 
        /**
         * это называется метод reference, тоесть мы даем ссылку на наш метод println, который находится в System.out и Java понимает, что в параметр println
         * мы должны вставить каждый элемент нашего стрима
         */
        /** output:
         *  5
            9
            3
            8
            1
         */
        
        
        Arrays.stream(array).forEach(el -> Utils.myMethod(el)); 
        Arrays.stream(array).forEach(Utils::myMethod); //  - тоже самое
        
        /**
         * это означает что каждый элемент потока помести в метот myMethod в качестве параметра, которы находится в классе Utils.Java понимает, что
         * в классе Utils есть myMethod, который принимает в качестве параметра int a(а наш поток содержит int) поэтому мы можем подставить в параметр элементы
         * шашего стрима
         * 
         *  output:
         *  Element = 10
            Element = 14
            Element = 8
            Element = 13
            Element = 6
         */
        
    }
}


class Utils{
    public static void myMethod(int a){
        a = a + 5;
        System.out.println("Element = " + a);
    }
}