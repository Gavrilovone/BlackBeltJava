package Class_Collections.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch_example {

    public static void main(String[] args) {
        Employee emp1 = new Employee(100, "Zaur", 12345);
        Employee emp2 = new Employee(15, "Ivan", 6542);
        Employee emp3 = new Employee(123, "Petr", 8542);
        Employee emp4 = new Employee(15, "Mariya", 5678);
        Employee emp5 = new Employee(182, "Kolya", 125);
        Employee emp6 = new Employee(15, "Sasha", 9874);
        Employee emp7 = new Employee(250, "Elena", 1579);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);
        System.out.println(employeeList); // [Employee {id= 100, name= Zaur, salary= 12345}, Employee {id= 15, name= Ivan, salary= 6542}, Employee {id= 123, name= Petr, salary= 8542}, Employee {id= 15, name= Mariya, salary= 5678}, Employee {id= 182, name= Kolya, salary= 125}, Employee {id= 15, name= Sasha, salary= 9874}, Employee {id= 250, name= Elena, salary= 1579}]
        
        Collections.sort(employeeList);
        System.out.println(employeeList); // [Employee {id= 15, name= Ivan, salary= 6542}, Employee {id= 15, name= Mariya, salary= 5678}, Employee {id= 15, name= Sasha, salary= 9874}, Employee {id= 100, name= Zaur, salary= 12345}, Employee {id= 123, name= Petr, salary= 8542}, Employee {id= 182, name= Kolya, salary= 125}, Employee {id= 250, name= Elena, salary= 1579}]
        
        int index2 = Collections.binarySearch(employeeList, emp5); // ищем работника с полями как у Kolya
        System.out.println(index2); // 5
    }
}

class Employee implements Comparable<Employee> { // чтобы сравнивать объект Employee надо либо использовать компоратор либо имплементировать интерфейс Comparable

    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {"
                + "id= " + id
                + ", name= " + name
                + ", salary= " + salary + "}";
    }

    @Override
    /**
     * Будем сравнивать по id, а при равенстве id будем сравнивать имена
     */
    public int compareTo(Employee anotherEmp) {
        int result = this.id-anotherEmp.id;
            if(result == 0){
                result = this.name.compareTo(anotherEmp.name);
        }
            return result;
    }

}
