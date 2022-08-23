
package LambdaExpressions.Supplier;
import java.util.ArrayList;
import java.util.function.Supplier;
/**
 * Supplier  - переводится как поставщик, у него есть метод T get() который не принимает никакой параметр, а возвращает объект типа T (T это generiks )
 */
public class Interface_Supplier { // метод который оздает 3 машины(какие конкретно, мы будем задавать в лямда выражении)
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSuplier){
        ArrayList<Car> al = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            al.add(carSuplier.get()); // добавляем элемент который будет поставлять наш Supplier
        }
        return al;
    }
    
    public static void main(String[] args) {
        ArrayList<Car> ourCars =  createThreeCars(() -> new Car("Nissan Tiida", "Silver Metalic", 1.6));
        System.out.println("ourCars: " + ourCars); // ourCars: [Car:model= Nissan Tiida, color= Silver Metalic, engine= 1.6, Car:model= Nissan Tiida, color= Silver Metalic, engine= 1.6, Car:model= Nissan Tiida, color= Silver Metalic, engine= 1.6]
    }
}


class Car{
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car:" + "model= " + model + ", color= " + color + ", engine= " + engine ;
    }
    
    
}