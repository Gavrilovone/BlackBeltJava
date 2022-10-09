
package IO_NIO.BufferedWriter_and_BufferedReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

   /**
     * Использование буферизации в стримах позволяет достичь большей эффективности при чтении и записи в него
     * 
     * BufferedWriter writer = new BufferedWriter(new FileWriter("file1.txt"));
     * BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));
     * 
     * BufferedWriter и BufferedReader используют FileWriter и FileReader, BufferedWriter и BufferedReader это обертки которые оборачивают 
     * FileWriter и FileReader и добавляют функционал буферизации
     * 
     * при работе FileReader, он посимвольно читает текст , при этом каждый раз(на каждом символе) обращается к файлу, это времязатратно
     * при работе BufferedReader, создается буфер определенного размера и туда помещаются часть символов или все если текст небольшой, и таким образом
     * обращение к файлу происходит один раз или во всяком случае гораздо меньшее количество раз, что заметно увеличивает производительность
     * аналогично с BufferedWriter, просто речь идет о записи
     */

/**
 * Почитаем файл Test2 и перенесем его в другой файл Test3
 */
public class FileCopyEx {
    public static void main(String[] args) {
        try ( BufferedReader reader = new BufferedReader(new FileReader("Test2.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("Test3.txt")); // Test3 создастся сам
                ){ 
            int character;
            while((character = reader.read()) !=-1){
                writer.write(character);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



    
