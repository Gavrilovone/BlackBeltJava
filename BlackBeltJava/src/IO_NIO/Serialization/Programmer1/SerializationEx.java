
package IO_NIO.Serialization.Programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Сериализация - это процесс преобразования объекта в последовательность байт
 * Десериализация - это процесс восстановления объекта, из этих байт
 * 
 * Для реализации этого используются 2 класса:
 * 
 * ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test2.bin"));
 * ObjectOutputStream outputputStream = new ObjectOutputStream(new FileOutputStream("test2.bin"));
 * ObjectInputStream делает сериализацию, а ObjectOutputStream байты превращает обратно в объект
 */
public class SerializationEx {
    /**
     * По заданию нам необходимо одному программисту (пакет Programmer_1) передеать другому (пакет Programmer_2) список работников, которые должны получить бонус
     */
    
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Alexey");
        employees.add("Ivan");
        employees.add("Elena");
        
        try (ObjectOutputStream outputputStream = new ObjectOutputStream(new FileOutputStream("employees1.bin"));
                ) {
            outputputStream.writeObject(employees); // записываем
            System.out.println("Done");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
          
        } catch (IOException e) {
            e.printStackTrace();
     
        }
    }
}

/**
 * output:
 * Done
 * 
 * в корне создастся файл employee1.bin
 */