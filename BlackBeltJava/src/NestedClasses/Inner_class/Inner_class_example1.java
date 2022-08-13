package NestedClasses.Inner_class;

/**
 * - Каждый объект Inner класса всегда ассоциируется с объектом внешнего класса
 * - Создавая объект inner класса, нужно перед этим создать объект внешнего класса
 * - Inner класс может содержать только non-statiс элементы
 * - Inner класс может обращаться даже к private элементам внешнего класса
 * - Внешний класс может обращаться даже к private элементам inner класса прежде создав его объкт
 * 
 */
public class Inner_class_example1 {

    public static void main(String[] args) {
        Car car = new Car("black", 4, 300);
        System.out.println(car); // My car: color=black, doorCount=4, engine= My engine: horsePower=300
    }
}

class Car {

    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, int horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsePower);
        /**
         * Мы присваиваем переменной engine новосозданный мотор, как он создается: мы с помощью this(который означает текущий объект класса Car) после 
         * которого ставим точку, показывая, что мы будем обращаться к какому-то его элементу и тут же создаем новый мотор.Так  создается объект inner класса, 
         * тоесть в создании объекта inner класса, всегда задействован объект(this) внешнего класса, тоесть  он всегда завязан на своем внешнем классе
         * 
         * можно создать мотор и по другому см Inner_class_example2
         */
    }

    @Override
    public String toString() {
        return "My car: " + "color=" + color + ", doorCount=" + doorCount + ", engine=" + engine;
    }

    public class Engine {

        int horsePower;
        /**
         * public static int a = 5;  inner класс не может содержать статические элементы!! одно из принципиальных отличий со статическим вложенным классом
         * но если сделать его final и константой то можно
         */
        public static final int A = 5;     
        

        public Engine(int horsePower) {
            this.horsePower = horsePower;

        }

        @Override
        public String toString() {
            return " My engine: " + "horsePower=" + horsePower;
        }

    }
}
