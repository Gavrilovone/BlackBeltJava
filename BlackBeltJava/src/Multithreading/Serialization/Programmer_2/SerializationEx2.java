
package Multithreading.Serialization.Programmer_2;

import Multithreading.Serialization.Programmer1.Employee;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



public class SerializationEx2 {
    public static void main(String[] args) {
        Employee bestemployee;
        try ( ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("employees2.bin")
        )) {
        bestemployee = (Employee) inputStream.readObject(); 
            System.out.println(bestemployee);
    }   catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}