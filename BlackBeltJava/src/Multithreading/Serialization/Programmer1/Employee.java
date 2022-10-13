package Multithreading.Serialization.Programmer1;

import java.io.Serializable;

/**
 * Теперь нам надо передать лучшего работника месяца, но одного ArrayList нам уже будет недостаточно,так как уже необходимо передавать имя, возраст, отдел и так далее
 */
public class Employee implements Serializable{ 
    /**
     * чтобы объект можно было сериализировать, он должен имплементировать интерфейс Serializable иначе будет исключение, этот  интерфейс не содержит ни 
     * одного метода, это просто интерфейс маркер(метка) в прошлом примере когда мы сериализировали ArrayList у нас не возникало проблем, потому, что он 
     * импелемнтирует Serializable и String тоже
     */

    String name;
    String department;
    int age;
    double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees:" + "name=" + name + ", department=" + department + ", age=" + age + ", salary=" + salary;
    }

}
