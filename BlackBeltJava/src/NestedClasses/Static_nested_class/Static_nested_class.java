package NestedClasses.Static_nested_class;

public class Static_nested_class {
    public static void main(String[] args) {
        /**
         * как создать объект класса Engine? обычным способом "Engine у = new Engine(256)" не получится
         */
        
        Car.Engine engine = new Car.Engine(256, 4); // показываем, что он статичный и находится  внутри класса Car
        System.out.println(engine); // My engine: horsePower=256
        /**
         * можно сделать вывод, что так как класс Engine статический, то это позволяет нам создавать его объект без создания класса Car.Единственное,
         * что мы должны указать в каком классе находится наш nested static класс, в данном случае в классе Car.Таким образом можно сказать , что
         * nested static класс ведет себя как обычный внешний класс
         */
        
        Car car = new Car("red", 4, engine);
        System.out.println(car); // My car: color=red, doorCount=4, engine= My engine: horsePower=256
        
        System.out.println(Car.Engine.countOfObject); // 1
        Car.Engine engine2 = new Car.Engine(256, 8);
        System.out.println(Car.Engine.countOfObject); // 2
         
        
    }
    
}

class Car {

    String color;
    int doorCount;
    Engine engine;
    static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: " + "color=" + color + ", doorCount=" + doorCount + ", engine=" + engine;
    }

    public static  class Engine {
        int horsePower;
        int tact;
        static int countOfObject;// static nested class может содержать как статические так и не статические элементы

        public Engine(int horsePower, int tact) {
            this.horsePower = horsePower;
            this.tact = tact;
            countOfObject++; // счетчик количества созданных объектов engine
            System.out.println(a); // в nested static classe можно обрщаться к private переменным внешнего класса, но только к статическим 
            // System.out.println(doorCount); к нестатическим нельзя, нельзя обращаться к non-static элементам из статического контектса!
           
        }
        
        void method(){
            /**
             * внешний класс может обращаться к элементам static nested класса даже private
             */
            System.out.println(Engine.countOfObject); // так как переменная статическая
            /**
             * но чтобы обратиться к нестатической переменной, нужно создать сначала его объект
             */
            Engine e = new Engine(160, 4);
            System.out.println(e.horsePower);
            
        }

        @Override
        public String toString() {
            return " My engine: " + "horsePower=" + horsePower;
        }
        
    }
}

class Z extends Car.Engine{ // можно наследовать nesteв class и nested class может наследоваться
  Z(){ // конструктор
  super(200, 4); // вызов конструктора parent класса Engine(200 лошадиных сил и 4 такта)
  }
}
