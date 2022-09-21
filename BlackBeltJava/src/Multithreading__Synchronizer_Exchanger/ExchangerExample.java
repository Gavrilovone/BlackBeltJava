
package Multithreading__Synchronizer_Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exchanger - синхронизатор, позволяющий обмениваться данными между двумя потоками, обеспечивает то, что оба потока получат информацию друг от друга одновременно
 * тоесть если один поток готов передать информацию другому потоку, но второй не готов, то первый будет заблокирован до тех пор пока второй поток не будет готов,
 * обмен информации происходит одновременно(информация которой они обмениваются должна быть одного типа данных )
 */
public class ExchangerExample {
    /**
     * Допустим у нас есть игра камень ножницы бумага: если один игрок выбрасывает например ножницы, то второй не увидит их пока сам не покажет что-то, чтобы 
     * это происходило одноаременно
     */
    
    public static void main(String[] args) {
       Exchanger<Action> exchanger = new Exchanger<>();
       List<Action> friend1Action = new ArrayList<>(); // создаем лист action-ов для первого друга, тоесть что он будет выбрасывать камень, ножницы или бумагу 
       friend1Action.add(Action.НОЖНИЦЫ);
       friend1Action.add(Action.БУМАГА);
       friend1Action.add(Action.НОЖНИЦЫ);
       
       List<Action> friend2Action = new ArrayList<>(); 
       friend2Action.add(Action.БУМАГА);
       friend2Action.add(Action.КАМЕНЬ);
       friend2Action.add(Action.КАМЕНЬ);
       
       new BestFriend("Иван", friend1Action, exchanger);
       new BestFriend("Петр", friend2Action, exchanger);
       
    }
}   

enum Action{
КАМЕНЬ, НОЖНИЦЫ, БУМАГА;
}

class BestFriend extends Thread{
    private String name;
    private List<Action> myAction; // для того чтобы они играли 3 раза, будем задавать 3 разных варианта
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myAction, Exchanger<Action> exchanger) {
        this.name = name;
        this.myAction = myAction;
        this.exchanger = exchanger;
        this.start();
    }
    
    private void whoWins(Action myAction, Action friendAction) { //  в параметре что покажу я и что покажет мой друг
        if ((myAction == Action.КАМЕНЬ && friendAction == Action.НОЖНИЦЫ)
                || (myAction == Action.НОЖНИЦЫ && friendAction == Action.БУМАГА)
                || (myAction == Action.БУМАГА && friendAction == Action.КАМЕНЬ)) {
            System.out.println(name + " Победил!!!");
        }

    }
    
    @Override
    public void run(){
        Action reply; // ответ друга
        for(Action action: myAction ){
            try {
                reply = exchanger.exchange(action); // пердаю свой параметр, а в outpute на выходе параметр друга
                whoWins(action, reply);
                sleep(2000); // спим 2 секунды после того как первая игра закончилась
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
output:
Иван Победил!!!
Иван Победил!!!
Петр Победил!!!
 */
