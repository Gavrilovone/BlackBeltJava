
package NestedClasses.Nested_Classes_intro;

public class Nested_Classes_intro {} // это тоже внешний клас

class Test{
  /**
   * данный класс является внешним, его называют еще Top Level, он принадлежит пакету, внутри него могут размещаться nested(вложенные) классы:
   */
    
    static class A{} // статический nested class
    
    class B{} // обычный inner class
    
    void method(){ // мы так же можем создавать классы внутри любого блока методов, конструкторов
        class C{} // такой класс в этом случе называется локальным классом
    }
    
    /**
     * так же есть 4й тип анонимные классы(см в уроках про ананимные классы)
     * 
     * Nested классы мы используем тогда когда нам нужно создать класс, который должен быть сильно связан с внешним классом, без которго, 
     * он чаще всего не используется
     */
    
    
}