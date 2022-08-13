package NestedClasses.Inner_local_inner_class;

public class Local_inner_class_example {

    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
      
        /**output:
         * Delimoe = 21
           Delitel = 4
           Chastnoe = 5
           Oststok = 1
           * 
           * ничего не изменилось
         */

    }
}

class Math {

    public void getResult() {
        int delimoe = 21; // вынесли за перделы класса, но в пределах метода
        // delimoe = 20; не сможем использовать в local inner classe, потому что в этом случае переменная delimoe перестает быть effectively final
        class Delenie {

            private int delitel;

            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe() {
                return delimoe / delitel;
            }

            public int getOstatok() {
                return delimoe % delitel;
            }

        }

        Delenie delenie = new Delenie();
        delenie.setDelitel(4);
        System.out.println("Delimoe = " + delimoe);
        System.out.println("Delitel = " + delenie.getDelitel());
        System.out.println("Chastnoe = " + delenie.getChastnoe());
        System.out.println("Oststok = " + delenie.getOstatok());

    }
 }
