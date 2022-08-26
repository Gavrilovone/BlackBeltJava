
package Stream.Method_peek;

import java.util.stream.Stream;

/**
 * метод peek() работате как и forEach, но в отличие от него возвращает не void а стрим , является (i) - intermediate тоесть можно использовать в цепочке
 * обычно используется, чтобы посмотреть как проходит поэтапно наш метод chaining
 */
public class Method_peek {
    public static void main(String[] args) {
         Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
         System.out.println(stream.distinct().peek(System.out::println).count()); 
         /**
          * output:
          *         1
                    2
                    3
                    4
                    5
                    5 - count вернул количество оставшихся элементов
          */
    }
}
