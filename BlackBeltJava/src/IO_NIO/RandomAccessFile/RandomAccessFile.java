
package IO_NIO.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Класс RandomAccsessFile -  позволяет читать информацию из любого места и записывать информацию в любое место файла.Его можно сравнить 
 * с курсором(или правильно называть поинтер ), там где он, там и происходит чтение, если что-то написать, то поинтер автоматически сдвигается
 */
public class RandomAccessFile {

    public static void main(String[] args) {
        try ( java.io.RandomAccessFile file
                = new java.io.RandomAccessFile("twst10.txt", "rw")) { // второй параметр означает режим, тоесть "rw" можно как читать так и записывать
            
            int a = file.read(); // там где будет поинтер, тот символ и будет выводится, read возвращает int поэтому нужно кастить
            System.out.println((char)a); // первая буква H в тексте
            String s1 = file.readLine();// можем прочитать сразу строчку
            System.out.println(s1); // ad I the heavens' embroidered cloths,
            /**
             * если мы хотим начать чтение с конкретного байта, то мы можем его найти с помощью метода seek, который устанавливает поинтер туда, кудв нам нужно
             */
            file.seek(101); // начиная со 101 байта
            String s2 = file.readLine();
            System.out.println(s2); // and the dark cloths
            
            Long position = file.getFilePointer(); // показывает на какой позиции находится поинтер 
            System.out.println(position); // 123
            
            file.seek(0); 
            file.writeBytes("Prive"); // если мы добавим в начало слово привет, то он перезапишет первые  байты, а не добавит новые
            
            file.seek(file.length()-1); // так мы попали в конец файла
            file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats"); // \n\t\t\t\t\t перход на новую строку и 5 табов вправа для красоты
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
