
package IO_NIO.FileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Stream(поток) для работы с файлами - это упорядоченная последовательность данных
 * 
 * Файлы разделяются на:
 * - читабельне для человека - text files;
 * - нечитабельные для человека - binary files
 * 
 * При работе с текстовыми и биарными файлами нам необходимо использовать разные типы стримов FileReader и FileWriter исользуются 
 * для работы с текстовыми файлами
 * 
 * 
 */
public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n " +
                       "Непонятного нет для меня под луной.\n" +
                       "Мне известно, что мне ничего не известно,\n" +
                       "Вот последний секрет из постигнутых мной.\n";
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\User\\Desktop\\Test1.txt");// - абсолютный тип к файлу
            writer = new FileWriter("Test2.txt"); // относительный путь(относительно корня нашего проекта)
            
            for(int i = 0; i < rubai.length(); i++){
                writer.write(rubai.charAt(i));
                /**
                 * таким образом мы передаем в лупе наш rubai посимвольно и с помощью метода write записываем в наш файл
                 */
                writer.write(rubai); // можно без лупа записать в файл так
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}

/**
 * после выполнения программы, стих записался в созданый на рабочем столе текстовый файл, путь его указан в параметре FileWriter
 * если в строке 40 не зарыть стрим методом close(); то ничего не запишется(но можно этого не делать см.Try_with_resources)
 * можно файл не создавать заранее, он создастся сам строка 40, в этом случае он создастся в корне нашего проекта 
 */