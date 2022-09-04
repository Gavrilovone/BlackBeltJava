
package Multithreading_Variants_createOfthreading;
/**
 * допустим хоим по-быстрому создать поток не используя класс который имплементирует Runnable()
 * это моно сделать используя анонимный класс
 */
public class Variant_3 {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Privet");
            }
        }).start(); // Privet
        /**
         * этот поток создал не main поток, а поток который мы создали
         */
        
        new Thread(() -> System.out.println("Poka")).start(); // Poka
    }
}
