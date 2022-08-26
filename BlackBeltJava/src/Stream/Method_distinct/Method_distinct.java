
package Stream.Method_distinct;

import java.util.stream.Stream;

/**
 * метод distinct возвращает стрим уникальных элементов, а проверяет он с помощью метода equals ,является (i) методом
 */
public class Method_distinct {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,1,2,3);
        stream.distinct().forEach(System.out::println);
        /**
         * output:
         *  1
            2
            3
            4
            5
         */
    }
}
