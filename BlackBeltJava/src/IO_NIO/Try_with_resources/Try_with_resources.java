
package IO_NIO.Try_with_resources;

import java.io.FileWriter;
import java.io.IOException;

public class Try_with_resources {
    /**
     * Очень часто программисты забывают закрывать ресурсы которе они используют, чтобы этого не делать, тоесть вообще чтобы не  закрывать
     * ресурс был придуман механизм который называется Try_with_resources
     * после try в круглых скобках мы можем записать ресурсы которые будут автоматически закрыты
     */
    
    
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n " +
                       "Непонятного нет для меня под луной.\n" +
                       "Мне известно, что мне ничего не известно,\n" +
                       "Вот последний секрет из постигнутых мной.\n";
        
        try ( FileWriter writer = new FileWriter("Test2.txt")) { // если ресурс один точку заптой можно не ставить

            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
                /**
                 * таким образом мы передаем в лупе наш rubai посимвольно и с помощью метода write записываем в наш файл
                 */
                writer.write(rubai); // можно без лупа записать в файл так
            }
            System.out.println("Done!");
        } // из-за того что пр компиляции создается finally блок, то catch блок можно не писать, но ели хотим чтобы исключение обрабатывалось его стоит писать
    }
}

/**
 * на самом деле после компиляции, компилятор внутренее переведет этот Try with resources в обычный try и finally блок как было сделано до этого
 * 
 * ресурсы которые используют Try with resources должны имплементировать интерфейс AutoCloseable
 */


