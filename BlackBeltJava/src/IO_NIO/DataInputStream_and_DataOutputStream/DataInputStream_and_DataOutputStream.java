package IO_NIO.DataInputStream_and_DataOutputStream;

import java.io.*;



/**
 * DataInputStream и DataOutputStream позволяют записывать в файл  и читать из него примитивные типы данных
 * 
 * DataInputStream inputStream =  new DatainputStream(new FileInputStream("test2.bin"));
 * DataOutputStream outputStream =  new DataOutputStream(new FileOutputStream("test2.bin"));
 */
public class DataInputStream_and_DataOutputStream {
    public static void main(String[] args) {
        try(DataOutputStream outputStream =  new DataOutputStream(new FileOutputStream("my_test.bin"));
      DataInputStream inputStream =  new DataInputStream(new FileInputStream("my_test.bin"));          
                ){
            
            outputStream.writeBoolean(true);
            outputStream.writeByte(5);
            outputStream.writeShort(120);
            outputStream.writeInt(500);
            outputStream.writeLong(1_000_000);
            outputStream.writeFloat(3.14F);
            outputStream.writeDouble(123.456);
            
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readDouble());
            
            
            
        
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
           
        }
    }
}


/**
output:

true
5
120
500
1000000
3.14
123.456
* 
* так же в корне проекта создался файл my_test.bin
 */