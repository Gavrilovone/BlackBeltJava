
package Interface_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_Comparable {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Mariya", "Petrova", 12345);
        Employee emp2 = new Employee(15, "Aleksey", "Gavrilov", 6564);
        Employee emp3 = new Employee(123, "Aleksey", "Ышвщкщм", 8564);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n " + list);
        
        /** 
            Before sorting 
            [Employee{id=100, name=Mariya, surname=Petrova, salary=12345}, Employee{id=15, name=Aleksey, surname=Gavrilov, salary=6564}, 
            Employee{id=123, name=Alekse, surname=Sidorov, salary=8564}]
            * 
            * Collection.sort(list) - будет ошибка компилятора, потому что в отличие от Strin и integer  джава не знает по каким критериям сортировать объект
            * их надо будет задать, допустим мы будем сравнивать их по id(для этого иплементируем интерфейс Comparable)
         */
        Collections.sort(list);
        System.out.println("After sorting \n " + list);
        
        /**
         * [Employee{id=15, name=Aleksey, surname=Gavrilov, salary=6564}, Employee{id=100, name=Mariya, surname=Petrova, salary=12345}, Employee{id=123, 
         * name=Aleksey, surname=Ышвщкщм, salary=8564}]
         */
        
              
    }
}
class Employee implements Comparable<Employee>{
   
    /**
     * логика этого метода такова: мы сравниваем текущий объект который мы создадим с обхектом в параметре метода compareTo enotherEmp
     * и должны возвратить какое то число, если текущий объект больше этого объекта в параметре, мы должны вернуть положительное число,
     * если меньше отрицательное, если равны ноль.есть несколько вариантов кода внутри метода compareTo
     */

     /**
      * Способ 1:
      */
    @Override
    public int compareTo(Employee anotherEmp) {
       if(this.id == anotherEmp.id){ // допустим мы решили сравнивать по id
           /**
            *  очень рекомендуется, но не является обязятельным тот факт, что если при таком сравнении return 0 то-есть объекты равны, то и чтобы
            * метод equals для этих двух объектов так же возвращал true
            */
           return 0;
       } else if(this.id < anotherEmp.id){
           return -1;
       } else {
           return 1;
       }
       
       /** 
        * Способ 2:
        * 
        *  public int compareTo(Employee anotherEmp){
        *     return this.id-anotherEmp.id;
        * }
        *  в основном все так пишут
        */
       
        /** 
        * Способ 3 в случае если Integer id вместо int id:
        * 
        *  public int compareTo(Employee anotherEmp){
        *     return this.id.СompareTO(anotherEmp.id);
        * }
        * потому что Integer как и String например имплементирует Comparable, но это более редкий способ
        */
        
        /**
         * если мы решили сравнивать по имени и фамилии:
         * 
         * public int compareTo(Employee enotherEmp){
         *      int result = this.name.СompareTO(anotherEmp.name);
         *      if(result == 0){
         *          result = this.surname.compareTO(anotherEmp.surname);
         *              return result;
         * }
         * 
         */
        
    }
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + '}';
    }
    
    
}
