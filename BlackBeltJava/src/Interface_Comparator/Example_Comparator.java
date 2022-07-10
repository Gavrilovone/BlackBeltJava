package Interface_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example_Comparator {

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
         * в метод сорт в качестве второго параметра можем передать объект IdComparator, мы говорим сортируй используя этот Comparator
         * и теперь сортировка будет проходить по id
         */
        Collections.sort(list, new IdComparator());
        Collections.sort(list, new NameComparator()); // теперь сортировка будет проходить по имени 
        Collections.sort(list, new SalaryComparator()); // теперь сортировка будет проходить по зарплате
        System.out.println("After sorting \n " + list);
        
        /**
         *  можно совместить Comparator и Comparable см.Example_Comparator_with_Comparable
         */

    }
}

class Employee {

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


class IdComparator implements Comparator<Employee> {

    @Override
    /**
     * метод compare имеет ту же логику , что и compareTo, только в параметре вместо текущего объекта два работника
     */
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.id == emp2.id) { 
            return 0;
        } else if (emp1.id < emp2.id) {
            return -1;
        } else {
            return 1;
        }
    }
}

/**
 * создадим еще несколько классов компараторов
 */

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2){
        return emp1.name.compareTo(emp2.name);
        
    }
}

class SalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2){
        return emp1.salary-emp2.salary;
        
    }
}
