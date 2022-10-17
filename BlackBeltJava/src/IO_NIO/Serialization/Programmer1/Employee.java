package IO_NIO.Serialization.Programmer1;

import java.io.Serializable;

/**
 * Теперь нам надо передать лучшего работника месяца, но одного ArrayList нам уже будет недостаточно,так как уже необходимо передавать имя, возраст, отдел и так далее
 */
public class Employee implements Serializable{ 
    /**
     * чтобы объект можно было сериализировать, он должен имплементировать интерфейс Serializable иначе будет исключение, этот  интерфейс не содержит ни 
     * одного метода, это просто интерфейс маркер(метка) в прошлом примере когда мы сериализировали ArrayList у нас не возникало проблем, потому, что он 
     * импелемнтирует Serializable и String тоже
     * Причем если мы хотим сериализовать класс, то все поля должны имплементировать интерфейс Serializable, в данном случае класс Car, если не имплементирует,
     * то будет исключение
     * если мы не хотим, чтобы поле записывалось в файл при сериализации, мы пишем перед ним ключевое слово transient(временнный) и тогда после сериализации объекта 
     * Employee salary=0.0 потому что дефолтное значение его =0
     * 
     * Может быть ситуация когда работают несколько программистов и один например решил изменить объект Employee добавив например фамилию, и он будет сериализовать
     * этот объект по новому виду, а другой программист не успел обновить класс и десиариализует его по старому виду(без фамилии) в этом случае будет исключение
     * InvalidClassException и будет указано в нем , что разные версии при сериализации.Но желательно указывать версию сериализации явно как это сделанов строчке
     * 23,  и не полагаться на автоматическое присвоение номера UID и тогда exception будет выглядеть так:
     * java.io.InvalidClassException: Multithreading.Serialization.Programmer1.Employee; local class incompatible: 
     * stream classdesc serialVersionUID = 2, local class serialVersionUID = 1 
     * 
     */
    static final long serialVersionUID = 1;
//    String surname;
    String name;
    String department;
    int age;
    transient double salary;
    Car car;

    public Employee(String name,
//            String surname,
            String department,
            int age, double salary, Car car) {
        this.name = name;
//        this.surname = surname;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

   
    @Override
    public String toString() {
        return "Employees:" + 
                ", name=" + name +
//                ", surname=" + surname+ 
                ", department=" + department + ", age=" + age + ", salary=" + salary + ", car=" + car;
    }

}
