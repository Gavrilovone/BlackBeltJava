package Interface_Comparable;
/**
 * Интерфейс Comparator используется для сравнения объектов, используя неестественный порядок и так же имеет один метод который нужно переопределять
 * int compare (Element e1, Element e2)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *  Самый эффективный способ это совместить comparable и comparator
 * например наш класс Employee имплементируют Сomparable по id если это сранение нужно чаще всего, тоесть если мы считаем, что естественная сортировка должна
 * быть по id и создали пару классов которе имплементят Сomparator, таким образом если у нас есть имплементация Comparable, то в методе sort можно не использовать
 * второй параметр Collections.sort(list), но если в какой-то момент, нам понадобится сортировка например по зарплате, то вместо того, чтобы постоянно менять
 * метод compareTo(а в некоторых случаях это невозможно) мы можем в качестве второго параметра указать Collections.sort(list, new SalaryComparator()); и правило 
 * сортировки по id перезаписывается(перечеркивается) и сортировка уже идет по зарплате
 * 
 * Comparator нам необходим в случаях например при сортинге String (который импементирует интерфейс Comparable) когда мы захотим сортировать не по стественному 
 * порядку, а наоборот или по количеству слов или символов, мы же не можем перезаписать метод cpmpareTo
 * 
 * Если мы используем объект Comparator один раз, то можно не создавать отдельный класс Comparator, а использовать анонимный класс или лямда выражения
 * 
 */
public class Example_Comparator_with_Comparable {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Mariya", "Petrova", 12345);
        Employee emp2 = new Employee(15, "Aleksey", "Gavrilov", 6564);
        Employee emp3 = new Employee(123, "Aleksey", "Sidorov", 8564);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n " + list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting \n " + list);

    }
}

class Employee implements Comparable<Employee> {

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

    @Override
    public int compareTo(Employee anotherEmp) {
        if (this.id == anotherEmp.id) { // допустим мы решили сравнивать по id
            return 0;
        } else if (this.id < anotherEmp.id) {
            return -1;
        } else {
            return 1;
        }
    }

}


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
