
package IO_NIO.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("test2.txt");
            int character;
            while((character = reader.read()) !=-1){
                System.out.print((char)character);
        }
            System.out.println();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            reader.close();
        }
    }
}

/**
 * Стрим FileReader читает посимвольно  спомощью метода read() (строч.19), сразу мы присваеваем этот символ нашей переменной character, метод read()
 * возвращает int и это нужно нам, чтобы понять когда наступает конец файла(когда наступает конец файла, метод read будет возвращать -1) 
 */

/**
 * output:
Много лет размышлял я над жизнью земной.
Непонятного нет для меня под луной.
Мне известно, что мне ничего не известно,
Вот последний секрет из постигнутых мной.

Done
 */