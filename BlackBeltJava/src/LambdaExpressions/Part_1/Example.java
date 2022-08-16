
package LambdaExpressions.Part_1;


public class Example {
    static void def(I i){
        System.out.println(i.abc("privet")); // вывод результата вызова метода abc с парметром "privet"
    }
    public static void main(String[] args) {
      def((String str) -> {return str.length();});
    }
}
/**
 * output: 6
 */


interface I{
int abc(String s);
}

/**
 * 
 */