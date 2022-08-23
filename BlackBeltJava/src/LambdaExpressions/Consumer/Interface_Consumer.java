package LambdaExpressions.Consumer;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Interface_Consumer {

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSuplier) {
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(carSuplier.get());
        }
        return al;
    }

    public static void changeCar(Car car, Consumer<Car> carConsumer) { // метод который будет менять машину(как менять будет определяться при вызове этого метода)
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("Nissan Tiida", "Silver Metalic", 1.6));
        System.out.println("ourCars: " + ourCars);

        changeCar(ourCars.get(0), car -> {  // далее прописываем то, что происходит внутри метода accept
            car.color = "red"; //внутри метода мы говорим, как долже выглядеть метод consumer
            car.engine = 2.4;
            System.out.println("upgrade car: " + car);
        });
    }
}

/**   output:
 *    ourCars: [Car:model= Nissan Tiida, color= Silver Metalic, engine= 1.6, Car:model= Nissan Tiida, color= Silver Metalic, engine= 1.6, Car:model= Nissan Tiida,       color= Silver Metalic, engine= 1.6]  upgrade car: Car:model= Nissan Tiida, color= red, engine= 2.4
 */

class Car {

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
        return "Car:" + "model= " + model + ", color= " + color + ", engine= " + engine;
    }

}
