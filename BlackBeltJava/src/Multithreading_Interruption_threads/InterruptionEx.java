
package Multithreading_Interruption_threads;
/**
 * В старых версиях Java перрывание происходило с помощью stop метода, но теперь он устаревший и не рекомендован к использованию, потому что 
 * он просто прерывал поток(грубо) и некоторые объекты оставались в непонятном и неоконченном состоянии
 * теперь вмпсто этого используют метод interrupt(); только он не прерывает а лишь дает сигнал потоку о том, что его хотят прервать, также есть проверка 
 * isInterrupted() которая дает true если наш поток хотят прервать и в итоге мы сами принимем решение, можем прервать, можем нет
 * 
 * InterruptedException выбрасывается если мы будет обращение к потоку о том, что его хотят прервать в то время когда он спит, если сделать, что поток
 * thread спит 10 сек, то если бы небыло InterruptedException то мы узнали бы о том, чт о поток спит и его нельзя прервать только через 10 сек, потому, что
 * проверка isInterrupted() происходит во время работы потока, чтобы так долго не ждать, выбрасывается это исключение
 */
public class InterruptionEx {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");

        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt(); // из потока main прерываем наш поток thread
        /**
         * Только этот метод не прерывает поток, а лишь поток main подает сигнал потоку thread, что он хочет его прервать
         */
        
        thread.join(); // чтобы "Main ends" писался после получения результата
        System.out.println("Main ends");
    }

}


class InterruptedThread extends Thread {

    double sqrtSum = 0;

    @Override
    public void run() { // будем считать сумму корней всех чисел от 1 до миллиарда
        for (int i = 1; i <= 1000000000; i++) {
            if(isInterrupted()){ // возвращает true если нас хочет прервать другой поток
                System.out.println("Поток хотят прервать");
                System.out.println("Убедились, что состояние объектов нормальное" + ""
                        + " и решили закончить работу потока ");
                return; // чтобы завнршиь работу потока
            }
            sqrtSum += Math.sqrt(i);
        }
        System.out.println(sqrtSum);
    }
}


/**     Output:
 *      Main starts
        31622.776601683792
        Main ends
* 
*       после добавления проверки isInterrupted:
*       Main starts
        Поток хотят прервать
        Убедились, что состояние объектов нормальное и решили закончить работу потока 
        Main ends
 */