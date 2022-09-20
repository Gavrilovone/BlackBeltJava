
package Multithreading__Synchronizer_CountDownLatch;

import static java.lang.Thread.sleep;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CountDownLatch - замок с обратным отсчетом, данный синхронизатор позволяет нескольким потокам ждать до те пор, пока не закончится обратный отсчет, 
 * тоесть не настанет 0, другими словами CountDownLatch позволяет любому количеству потоков ожидать до тех пор, пока не закончится определенное количество
 * операций, после окончания этих операций, потоки будут отпущены, чтобы продолжить свою деятельность.В конструктор CountDownLatch обязательно должно быть
 * передано количество операци, которые должны быть выполнены, чтобы он освободил заблокированные потоки
 */
public class CountDownLatchExample {
    /**
     * Представим ситуацию, что наступила черная пятница и в магазинах огромные скидки и мы с друзьями пришли пораньше одни из первых, чтобы занять очередь,но
     * мы не можем приступить к покупкам пока не выполнятся ряд операций:
     * 1 - работники магазина должны прийти на работу
     * 2 - все в магазине должно быть разложено по полкам, свет должен быть включен
     * 3 - Магазин должен открыться
     */
    static  CountDownLatch countDownLatch = new CountDownLatch(3);
    
    private static void marketStaffIsOnPlace() throws InterruptedException{ // метод, что персонал должен быть на месте
        sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown(); // этим методом мы уменьшаем счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount()); // с помощью getCount() можем получить значение счетчика
    }
    
        private static void everythingIsReady() throws InterruptedException{ // все готово
        sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown(); 
        System.out.println("countDownLatch = " + countDownLatch.getCount()); 
    
    }
        
        private static void openMarket() throws InterruptedException{ // магазин открылся
        sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown(); 
        System.out.println("countDownLatch = " + countDownLatch.getCount()); 
    
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Friend("Алексей", countDownLatch);
        new Friend("Ольга", countDownLatch);
        new Friend("Мария", countDownLatch);
        new Friend("Андрей", countDownLatch);
        new Friend("Елена", countDownLatch);
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
        
          
        
    }
}


class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start(); // чтобы при создании объекта Friend сразу запускалс поток
    }
    
    @Override
    public void run(){
        try {
            countDownLatch.await(); // если счетчик сountDownLatch > 0, наш поток будет заблокирован до тех пор пока счетчик не станет = 0
            System.out.println(name + "Приступил(а) к покупкам "); // после того как счетчик станет 0 и поток выйдет из блокировки, будем выводить
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }
    }
    
}

/**
output:
Market staff came to work
countDownLatch = 2
Everything is ready, so let's open market
countDownLatch = 1
Market is opened
ЕленаПриступил(а) к покупкам 
АлексейПриступил(а) к покупкам 
АндрейПриступил(а) к покупкам 
МарияПриступил(а) к покупкам 
ОльгаПриступил(а) к покупкам 
countDownLatch = 0
 */