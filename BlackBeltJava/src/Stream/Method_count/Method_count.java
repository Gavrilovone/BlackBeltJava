package Stream.Method_count;
// метод count() считает количество элемнетов в стриме и возвращает long(t), является turned метод, тоесть нельзя использовать в цепочке

import java.util.stream.Stream;

public class Method_count {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println(stream.count()); // 8
        System.out.println(stream.distinct().count()); // Exeption stream has already been operated upon or closed
        /**
         * потому что есть одно важное правило! стрим нельзя переиспользовать, мы уже ипользовали его, методом count,  но если закоментировать строчку 10, то output
         * выдаст нам 5(количество уникадьных элементов стрим)
         */

    }
}
