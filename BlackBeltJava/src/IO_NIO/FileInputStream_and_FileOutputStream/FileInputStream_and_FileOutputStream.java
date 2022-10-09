
package IO_NIO.FileInputStream_and_FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * FileInputStream и FileOutputStream используются для работы с бинарными файлами(к примеру картинка является бинарным файлом)
 * 
 * FileInputStream inputStream = new FileInputStream("test2.bin");
 * FileOutputStream inputStream = new FileOutputStream("test2.bin");
 */
public class FileInputStream_and_FileOutputStream {
        public static void main(String[] args) {
        try(FileInputStream imputStream  = new FileInputStream("C:\\Users\\User\\Desktop\\java.jpg");
              FileOutputStream outputStream = new FileOutputStream("java.jpg"); // создастся в корне нашего проекта при такой записи
                ){
            int i;
            while((i = imputStream.read()) !=-1 ){ // пока картинка закончится, когда мы ее прочтем, метод read вернет нам -1
                outputStream.write(i); // пока картинка не закончится(ее чтение)мы будем записывать ее в корень нашего проекта в файл
            }
            
        }   catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
    }
}

/**
 * таже для них  возможна буферизация
 */
