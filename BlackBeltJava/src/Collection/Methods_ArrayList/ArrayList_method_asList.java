
package Collection.Methods_ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList(Data Type[]) -> List<Data Type> - с помощью этого метода мы получаем лист из масива
 */
public class ArrayList_method_asList {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list =  Arrays.asList(array);
        System.out.println(list); // [A, B, C, D]
        /**
         * Длина его будет такой же как и у массива и измениться не может, он полностью связан с этим массивом.Если мы изменим элемент массива, 
         * то это отразится и в листе тоже: 
         */
        array[0].append("!!!");
        System.out.println(list);//  [A!!!, B, C, D]
        
        
    }
}
