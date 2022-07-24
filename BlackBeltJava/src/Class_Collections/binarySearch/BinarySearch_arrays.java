
package Class_Collections.binarySearch;

import java.util.Arrays;

public class BinarySearch_arrays {
    public static void main(String[] args) {
        int[] array = {-3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19};
        System.out.println(array);// если вывести на печать то будет [I@404b9385]
        System.out.println(Arrays.toString(array)); // -3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19]
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // [-30, -8, -3, 0, 1, 5, 8, 10, 12, 19, 150]
        int index3 = Arrays.binarySearch(array, 150);
        System.out.println(index3); // 10
    }
}
