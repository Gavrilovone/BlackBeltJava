
package IO_NIO.Serialization.Programmer_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SerializationEx {
    public static void main(String[] args) {
        List<String> employees;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees1.bin"));
                ) {
            
           employees = (ArrayList) inputStream.readObject();
           /**
            * так как readObject(); возвращает Object, нам приходися кастить
            */
            System.out.println(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }

}

/** output:
 * [Alexey, Ivan, Elena]
 */