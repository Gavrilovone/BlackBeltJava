package Collection.Interface_Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator расширяет возможности Iterator и можно работать не только со следующим элементом используя метод next() но и с предыдущим используя метот previous()
 */
public class ListIterator_example {

    /**
     * будем проверять какой-то стринг на предмет палиндром ли он
     */

    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) { // с помощью метода toCharArray наш String преобразуется в массив char
            list.add(ch);
        }
        /**
         * будем проходится двумя итераторами с 2х сторон и сравнивать char
         */
        
        ListIterator<Character> iterator = list.listIterator(); // этот итератор начинает с нуля по умолчанию
        ListIterator<Character> reverseiterator = list.listIterator(list.size()); // этот итератор начинает с конца
        
        /**
         * создадим переменную, с помощью которой будем проверять полиндром ли наш стринг
         */
        
        boolean isPalindrome = true; // пока true? будем читать что он палиндром 
        while(iterator.hasNext() && reverseiterator.hasPrevious()){
            if(iterator.next() != reverseiterator.previous()){
                isPalindrome = false;
                break; // как только надем первое несовпадение, цикл можно закончить
            }
                
        }
        if(isPalindrome){
            System.out.println(s + " - Палиндром");
        } else{ 
            System.out.println(s + " - Не палиндром");
        }
    }
}

/**
 * output: madam - Палиндром
 */