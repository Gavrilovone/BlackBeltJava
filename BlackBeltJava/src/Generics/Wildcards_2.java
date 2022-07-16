
package Generics;
import java.util.ArrayList;
import java.util.List;
public class Wildcards_2 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();
//        list.add("Привет"); ошибка компилятора
    
    /**
     * потому что когда мы используем <?> мы говорим компилятору, здесь может быть что угодно, по-этому этот wildcard это 
     * тоже самое, что  и какой-то неизвстный тип.И каждый раз когда мы пытаемся добавить в лист созданный с помощью wildcard какой-то
     * элемент, компилятор пытается сверить тип нашего элемента(который известен это String в данном случе) c типом нашего листа List  
     * который неизвестен и он считает очень рискованнм добавлять элемент в лист тип которого неизветсен и учитывая, что основная цель дженериков
     * это type safe то компилятор не позволяет вообще ничего добавлять в такие листы
     * 
     * таким образом в таких листах компилятор будет запрещать нам вызывать методы которые изменяют объект, метод add() изменяет объект
     */
    
    /**
     * можно поставить ограничение, использовать bounded wildcard(ограниченный подстановочный знак):
     */
    
     List<? extends Number> list2 = new ArrayList<Number>();
//   List<? extends Number> list3 = new ArrayList<String>(); String написать уже нельзя
    List<? super Number> list4 = new ArrayList<Object>();
    /**
     * эта запись <? super Number> означает, что  элементом ArrayList может быть  Number или любой другой класс, который является супер классом для Number
     */




    ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(summ(ald)); // 9.45

    }
    
    /**
     * напишем метод который находит сумму всех элементов ArrayListа  если он Number:
     */
    
    public static double summ(ArrayList<?  extends Number> al){
        double summ = 0;
            for(Number n: al){
                summ+=n.doubleValue(); 
                /**
                 * doubleValue () - это встроенный в java метод, который эквивалентен методу sum (), 
                 * то есть возвращает текущее значение суммы
                 */
            }
            return summ;
    }
    
}
