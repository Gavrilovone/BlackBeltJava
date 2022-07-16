
package Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * wildcards - название пришло из карточных игр и означает какую-то супер карту, например джокера
 * <?> - это и есть wildcards
 */
public class Wildcards {
    public static void main(String[] args) {
//      List<Number> list = new ArrayList<Integer>();  так писать нельзя (см.Subtiping)
        List<?> list1 = new ArrayList<Integer>();
        List<?> list2 = new ArrayList<String>();
        /**
         * но так можно, <?> означает, что вместо него может быть абсолютно любой класс
         * где это можно применить:
         * допустим мы хотим написать метод, который будет вводить на экран абсолютно любой лист
         */
        
        
        List<Double> list3 = new ArrayList<>();
        list3.add(3.14);
        list3.add(3.15);
        list3.add(3.16);
        showListInfo(list3); 
        
        List<String> list4 = new ArrayList<>();
        list4.add("Привет");
        list4.add("Пока");
        list4.add("Хорошо");
        showListInfo(list4); 
        /**
         * output:
                   Мой лист содержит следующие элементы: [3.14, 3.15, 3.16]
                   Мой лист содержит следующие элементы: [Привет, Пока, Хорошо]
         */
    }
    
    static void showListInfo(List<?> list){
        System.out.println("Мой лист содержит следующие элементы: " + list);
    }
}
/** 
 * при работе c wildcards есть ограничения см Wildcards_2
 */