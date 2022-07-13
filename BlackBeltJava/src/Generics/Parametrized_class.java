
package Generics;

public class Parametrized_class {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("Привет"); // вместо T пишем String 
        System.out.println(info1);// {[Привет]}
        String s = info1.getValue();
        
        Info<Integer> info2 = new Info<>(100); 
        System.out.println(info2); // {[100]}; 
        Integer i = info2.getValue();
    }
}

class Info <T>{ // у нас есть какой-то тип T и теперь везде  при создании объекта будет подстановка конретного типа вместо T
    /**
     * вместо <T> можно написать что угодно, но например используется часто:
     * <E> - если работают с ArrayList
     * <K> - если работают с какими-то ключами
     * <V> - если работают с value(K и V часто используются у map)
     * называется type placeholder(введите заполнитель или тип место держатель)
     * иногда можно писать 2 буквы в <>; см пример Parametrized_class_2
     */
    private  T value; // есть переменная value(она не может быть статичной, потому что она будет общей для всех объектов и будет расхождение по типам)
    public Info(T value){ // значение этого типа T мы передаем в конструкторе
        this.value = value; // и назначаем нашей переменной value
    }
    @Override
    public String toString(){ // пепеопределили toString просто, чтобы красиво было
        return "{[" + value + "]}";
    }
    
    public T getValue(){
        return value;
    }
}