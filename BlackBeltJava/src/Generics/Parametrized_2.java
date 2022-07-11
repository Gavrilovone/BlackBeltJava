
package Generics;

public class Parametrized_2 {
    public static void main(String[] args) {
       Pair<String, Integer> pair1 = new Pair<>("Привет", 100);
        System.out.println("Значение пары: value = " + pair1.getFirstValue() + ", value2 = " + pair1.getSecondValue()); // Значение пары: value = Привет, value2 = 100
        
        Pair<Integer, Double> pair2 = new Pair<>(156, 3.456);
        System.out.println("Значение пары: value = " + pair2.getFirstValue() + ", value2 = " + pair2.getSecondValue()); // Значение пары: value = 156, value2 = 3.456
        OtherPair<String> othp = new OtherPair<>("Привет", "Пока");
    }
}

class Pair<V1, V2>{
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    
    public V1 getFirstValue(){
        return value1;
    }
    public V2 getSecondValue(){
        return value2;
    }
    
}
/**
 * если нам нужно создать такой же класс, но например, чтобы 2 переменные V1 и V2 всегда  были одного типа, то нужно в placeholder написать один
 */

class OtherPair<V>{
    private V value1;
    private V value2;

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    
    public V getFirstValue(){
        return value1;
    }
    public V getSecondValue(){
        return value2;
    }
    
}