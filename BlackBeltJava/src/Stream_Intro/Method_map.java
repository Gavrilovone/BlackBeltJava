package Stream_Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Method_map {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("ok");
        list.add("poka");

        /**
         * допустим мы хотим изменить содержимое листа и вместо этих слов поставить их длину как мы могли это делать старым способом:
         */
        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list); // [6, 9, 2, 4]

        /**
         * Теперь создадим срим с помощью нашего листа:
         */
        list.stream().map(element -> element.length()).collect(Collectors.toList()); // на выходе мы имеем поток 6, 9, 2, 4

        /**
         * этот метод stream() возращает нам stream, его можно получить или создать несколькими способами, самый распространенный это создание его из коллекций путем вызова метода stream(), на выходе
         * мы имеем поток, этот поток ничего не исеет общего с многопоточностью(или к стримам с помощью которых мы читаем или записываем что-то в файл), это другое.Здесь мы преобразовали наш лист в
         * поток
         *
         * метод map() берет по очереди каждый элемент нашего стрима и сопоставляет ему элемент, который из него получается после применения на нем тех действий которые мы описываем внутри мапа с
         * помощью лямбда выражения метод map() принимает впараметр интерфейс function , поэтому в input может String а на выходе получаить int в нашем случае
         *
         * мы не можем присвоить теперь листу например List<Integer> list2 = list.stream().map(element -> element.length()); потому что не можем присвоить листу поток, его надо сначала преобразовать,
         * для этого используем метод collect, после чего :
         */
        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list2); // [6, 9, 2, 4]

        /**
         * все методы stream не меняют лист или массив на котором были вызваны!
         *
         * пример для массива:
         */
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(el -> {
            if (el % 3 == 0) { // если елемент нацело делится на 3
                el = el / 3;    // то делим этот элемент на 3
            }
            return el;
        }).toArray();// здесь вместо collect можно использовать toArray
        
        System.out.println(Arrays.toString(array)); // [5, 3, 1, 8, 1]
        
        /**
         * Пример с коллекцией Set:
         */
        
        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("ok");
        set.add("poka");
        System.out.println(set); // [kak dela?, ok, poka, privet]
        // в потоке мы получили 6, 9, 2, 4
        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(set2); // [2, 4, 6, 9] в сет происходит сортировка по-этому так
        /**
         * можем преобразовать и в list:
         */
        List<Integer> list3 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(list3); // [9, 2, 4, 6]
    }
}
