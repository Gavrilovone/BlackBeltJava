
package Stream.Method_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * reduce - переводится как уменьшить. когда мы применяем reduce для стрима, на выходе получаем всегда один элемент, тоесть уменьшаем n-e количество элементов
 * стрима до одного.тоесть очень удобно выполнять агрегированные функции(сложение, умножение))
 */
public class Method_reduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);
        /**
         * найдем произведение вех элементов
         */
        int result = list.stream().reduce((accumulator, element) ->
            accumulator*element).get();
            System.out.println(result); // 960
        /**
         * После того как мы вызываем на листе стрим, у нас появляется стрим который содержит элементы 5 8 2 4 3, мы работаем с двумя параметрами, и первому 
         * парметру (accumulator) присваивается первое значение нашего стрима (5), а второму параметру (element) присваиваетс второе значение стрима(8), после чего
         * 5*8 = 40 и 40 присваивается парметру (accumulator), а  параметру (element) присваивается  следующий элемент (2), потом 40*2 = 80, 80*4 = 320,
         * 320*3 = 960  
         * метод reduce возвращает optional,  и если не вызвать метод get() то будет ошибка компиляции, optional каким то образом оборачивает наше значение 960
         * является какбы контейнером для нашего конкретного значения? он может содержать null и not null значения  и могут быть много ситуаций, когда reduce
         * возвращает null и чтобы на ура не использовать метод get(), потму что может вернуться null значение, мы можем проверить на присутствие это значение
         * методом isPresent
         */
        
        List<Integer> list2 = new ArrayList<>();
            int result2 = list2.stream().reduce((accumulator, element) ->
            accumulator*element).get(); 
            System.out.println(result2); // NoSuchElementException: No value present
        /**
         * потому что мы не обезопасились и на прямую попытались вызвать метод get() не проверили на null, а так как наш лист пуст и соответственно стрим пуст,
         * то вылетает исключение, можно было сделать так:
         */
        Optional<Integer> o  = list2.stream().reduce((accumulator, element) ->
            accumulator*element);
        if(o.isPresent()){ // присутствует?
            System.out.println(o.get());
        } else {
            System.out.println("No present!");
        }
            
        /**
         * output: No present!
         */
        
        /**
         * Второй вариант использования метода reduce, мы можем добавить еще один параметр, он будет являться начальным значением параметра(accumulator)
         * при импользовании такого варианта null значения уже быть не может, потому что как минимум мы указали уже значение праметра accumulator, поэтому
         * здесь использовать метод get нет неободимости,reduce возвращает нам int
         */
        int result3 = list.stream().reduce(1, (accumulator, element) ->
            accumulator*element);
        /**
         * получается accumulator = 1,  element = 5 : 1*5=5, 5*8=40, 40*2=80, 80*4=320, 320*3=960 
         */
        
        /**
         * найдем для листа который содержит String конкатенацию всех его элемнетов:
         */
        List<String> list4 = new ArrayList<>();
        list4.add("privet");
        list4.add("kak dela?");
        list4.add("ok");
        list4.add("poka");
        String result4 = list4.stream().reduce((ac, el) -> ac + " " + el).get();
        System.out.println(result4); // privet kak dela? ok poka
        
    }
}
