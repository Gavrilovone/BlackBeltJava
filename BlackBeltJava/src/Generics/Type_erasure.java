/**
 * Type erasure - стирание типа
 * 
 * Genegics появились с 5й java и нужно было поддерживать backward compatibility(обратная совместимость) тесть код который использует genegics должен 
 * был работатьс кодом который не использует generics для этого и был использован механизм type erasure
 */
package Generics;

import java.util.ArrayList;

public class Type_erasure {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        /**
         * Компилятор это видит и все отлично, но Runtime вся информация о generics удаляется, тоесть информацию о generics видит только компилятор, 
         * для необходимых ему проверок, JVM видит это так:
         * 
         *         ArrayList al = new ArrayList();       
         * по-этому когда мы пишем:
         */
        int i = al.get(0);
        /**
         * компилятор его видит в таком виде:
         * 
         *  int i = (Integer)al.get(0);
         * 
         * происходит casting и без кастинга эта запись al.get(0); возвращает Object и Object кастится до Integer и потом назначается переменной i
         * этот процесс называется type erasure
         */
    }
    
    
    
    
    /**
     * создадим еще 2 метода:
     */
    
//    public void abc(Info<String> info){
//        String s = info.getValue();
//    }
//    
//     public void abc(Info<Integer> info){
//        Integer i = info.getValue();
//    }
    
    /**
     * ошибка компилятора, потому что несмотря на разную сигнатуру, для JVM после стирания типов будут выглядеть абсолютно одинаково
     * JVM будет видеть их так: abc(Info info) потому что вся информация о дженериках стираетсяюпоэтому мы не можем создавать такие overloaded методы
     */



    
}


class Info <T>{ 
   
    private  T value; 
    public Info(T value){ 
        this.value = value; 
    }
    @Override
    public String toString(){ 
        return "{[" + value + "]}";
    }
    
    public T getValue(){
        return value;
    }
}

/** 
 * пример связанный с проблемой overriding:
 */

class Parent{
    public void abc(Info<String> info){
        String s = info.getValue();
    }
}

//class Child extends Parent{
//     public void abc(Info<Integer> info){
//        Integer i = info.getValue();
//    }
//}

/**
 * так же будет ошибка компилятора, так как происходит конфликт имен, оба метода имеют одинаковое стирание и при кастинге в сабклассе будут возникать проблемы
 */