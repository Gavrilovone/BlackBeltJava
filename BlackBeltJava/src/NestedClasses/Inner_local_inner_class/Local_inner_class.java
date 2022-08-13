
package NestedClasses.Inner_local_inner_class;
/**
 * по агналогии с локальными переменными, локальные inner классы работают только внутри блока кода в котором они определены
 * очень редки на практики но повышают наш encapsulation
 * 
 * - Local inner class располагается в блоках кода таких как, например, метод или конструктор
 * - Local inner class не может быть static
 * - Область видимости Local inner classa - это блок в котором он находится
 * - Local inner class может обращаться даже к private элементам внешнего класса
 * - Local inner class может обращаться к элементам блока, в котром он написан при условии, что они final или effectively final см Local_inner_class_example 
 *   effectively final переменная это такая перемнная которая потом не меняется , задали значение и после не меняем
 */
public class Local_inner_class {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult(); 
        /**output:
         * Delimoe = 21
           Delitel = 4
           Chastnoe = 5
           Oststok = 1
         */
    }
}

class Math{
    public void getResult(){
        class Delenie{
            private int delimoe;
            private int delitel;
            
            public int getDelimoe(){
                return delimoe;
            }
            public void setDelimoe(int delimoe){
                this.delimoe = delimoe;
            }

            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }
            
            public int getChastnoe(){
                return delimoe/delitel;
            }
            
            public int getOstatok(){
                return delimoe%delitel;
            }
            
        }
        
        Delenie delenie = new Delenie();
        delenie.setDelimoe(21);
        delenie.setDelitel(4);
        System.out.println("Delimoe = " + delenie.getDelimoe());
        System.out.println("Delitel = " + delenie.getDelitel());
        System.out.println("Chastnoe = " + delenie.getChastnoe());
        System.out.println("Oststok = " + delenie.getOstatok());
        
    }
}