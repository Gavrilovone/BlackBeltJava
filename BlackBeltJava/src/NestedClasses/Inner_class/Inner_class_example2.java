package NestedClasses.Inner_class;

public class Inner_class_example2 {

    public static void main(String[] args) {
        Car car = new Car("black", 4); // на данный момент наш объект car без мотора, он null
        Car.Engine engine = car.new Engine(250);
    //  Car.Engine engine = car.new Car.Engine(250); - так писать нельзя!
        System.out.println(car); // My car: color=black, doorCount=4, engine=null
        
        /**
         * то же самое, что в Inner_class_example1, только вместо this наш объект car
         */
        car.setEngine(engine); 
        System.out.println(engine);// My engine: horsePower=250
        System.out.println(car); // My car: color=black, doorCount=4, engine= My engine: horsePower=250
        
        /**
         * можем одновременно создать внешний класс и внутренний:
         */
        
        Car.Engine engine2 = new Car("yellow", 4).new Engine(180); // но здесь теряется ссылка на объект Car, остается только ссылка на момтор
        System.out.println(engine2); //  My engine: horsePower=180
    }
}

class Car {

    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
    }
    
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: " + "color=" + color + ", doorCount=" + doorCount + ", engine=" + engine;
    }

    public class Engine {

        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;

        }

        @Override
        public String toString() {
            return " My engine: " + "horsePower=" + horsePower;
        }

    }
}
