
package NestedClasses.Inner_local_inner_class;

public class Local_inner_example2 {
    public static void main(String[] args) {
        class Slogenie implements Math2{
            @Override
            public int doOperation(int a, int b){
                return a+b;
            }
        }
        
        Slogenie s = new Slogenie();
        System.out.println(s.doOperation(5, 3)); // 8
    }
}

interface Math2{
    int doOperation(int a, int b);
}

/**
 * таким образом можно использовать local inner class, но в этом случае обычно используются анонимные классы
 */