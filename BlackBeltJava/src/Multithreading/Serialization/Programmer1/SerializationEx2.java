
package Multithreading.Serialization.Programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializationEx2 {

    public static void main(String[] args) {
        Car car = new Car("Toyota vensa", "black");
        Employee employee = new Employee("Mariya",
//                "Ivanova", 
                "IT", 28, 500, car);
        try ( ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("employees2.bin")
        )) {
            outputStream.writeObject(employee);
            System.out.println("Done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

