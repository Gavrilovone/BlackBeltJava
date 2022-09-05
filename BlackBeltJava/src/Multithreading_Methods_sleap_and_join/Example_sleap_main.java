
package Multithreading_Methods_sleap_and_join;
/**
 * Пример, что можно усыпить поток main
 */
public class Example_sleap_main {
    public static void main(String[] args) throws InterruptedException { // sleap выбрасывает исключение
        for(int i = 5; i > 0; i--){
            System.out.println(i);// 5 4 3 2 1 
            Thread.sleep(1000); // после каждого вывода main должен поспать 1 секунду
        }
        System.out.println("Поехали!!!");
    }
}
