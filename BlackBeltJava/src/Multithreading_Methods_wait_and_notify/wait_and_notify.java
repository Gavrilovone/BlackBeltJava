
package Multithreading_Methods_wait_and_notify;
/**
 * Для извещения потоком других потоков о своих действиях часто используются следующие методы:
 * wait = освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify();
 * notify - НЕ освобождает монитор и будит поток, у которого ранее был вызван метод wait(); notifyAll - НЕ освобождает монитор и будит все потоки, у которых ранее был вызван метод wait();
 */
public class wait_and_notify {
/**
* пусть у нас будет магазин(маркет) котрый продает хлеб, на витрине в одно и тоже время может находится не больше 5 хлебов, поэтому продавец не может
* положить хлеб на витрину пока покупатель не купит хотябы один хлеб, что касается покупателя, то он не может купить хлеб пока он не появится.в день печется 
* для данного магазина 10 хлебов, производителя хлебя будем называть Producer , а потребитель Customer(потребитель) каждый представляет собой отдельный поток и
* они будут общаться с помощью wait и notify.когда хлеба нет, Custemer будет вызывать метод wait и ждать, как только появится один хлеб, producer вызывает метод 
* notify, давая понять потребителю, что хлеб появился и поток может просыпаться.метод notify будет поток custemer, но сам не засыпает.Если хлеба 5, то производитель
* может поспать вызвав метод wait.Поток потребителя купив один хлеб может вызвать метод notify, пробудив этм самым производителя 
*/
    
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        
    }
}

class Market{
    private int breadCount = 0;
    
    public synchronized void getBread(){ 
        while(breadCount < 1){ // если хлеба нет, пока он 0 ждем
            /**
             * используется  while а не if, это рекомендация Java doc  так как существует вероятность, что поток может проснуться без notify и в этом
             * случае нужно опять проверить условие, а при if,  проверятьс условие еще раз не будет и поток начнет бодорствовать когда должен спать
             */
           try{ wait();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
        breadCount--; // если хлеб есть, покупатель его берет уменьшая количество хлеба
        System.out.println("Потребитель купил один хлеб");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); // после того как мы взяли хотябы один хлеб, можно сообщить проиводителю просыпвйся, ты можешь добавлять хлеб
    }
    
    public synchronized void putBread(){
        while(breadCount >= 5){
             try{ wait(); // может принимать миллисикунды wait(1000); тоесть если другой поток в течение 1 сек не вызовет notify, он станет активным 
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
        breadCount++;
        System.out.println("Производитель добавил один хлеб");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); // извещаем потребителя , что хлеб добавился и потоку можно просыпаться
    }
     
}
/**
 * создем потоки производителя и потребителя
 */
class Producer implements Runnable{
    Market market;
    Producer(Market market){
        this.market = market;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){ // производит в день для этого маркета 10 хлебов
            market.putBread();
        }
    }
}

class Consumer implements Runnable{
    Market market;
    Consumer(Market market){
        this.market = market;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){ // производит в день для этого маркета 10 хлебов
            market.getBread();
        }
    }
}

/** output:
 *  Производитель добавил один хлеб
    Количество хлеба в магазине = 1
    Производитель добавил один хлеб
    Количество хлеба в магазине = 2
    Производитель добавил один хлеб
    Количество хлеба в магазине = 3
    Производитель добавил один хлеб
    Количество хлеба в магазине = 4
    Производитель добавил один хлеб
    Количество хлеба в магазине = 5
    Потребитель купил один хлеб
    Количество хлеба в магазине = 4
    Потребитель купил один хлеб
    Количество хлеба в магазине = 3
    Потребитель купил один хлеб
    Количество хлеба в магазине = 2
    Потребитель купил один хлеб
    Количество хлеба в магазине = 1
    Потребитель купил один хлеб
    Количество хлеба в магазине = 0
    Производитель добавил один хлеб
    Количество хлеба в магазине = 1
    Производитель добавил один хлеб
    Количество хлеба в магазине = 2
    Производитель добавил один хлеб
    Количество хлеба в магазине = 3
    Производитель добавил один хлеб
    Количество хлеба в магазине = 4
    Производитель добавил один хлеб
    Количество хлеба в магазине = 5
    Потребитель купил один хлеб
    Количество хлеба в магазине = 4
    Потребитель купил один хлеб
    Количество хлеба в магазине = 3
    Потребитель купил один хлеб
    Количество хлеба в магазине = 2
    Потребитель купил один хлеб
    Количество хлеба в магазине = 1
    Потребитель купил один хлеб
    Количество хлеба в магазине = 0
 */