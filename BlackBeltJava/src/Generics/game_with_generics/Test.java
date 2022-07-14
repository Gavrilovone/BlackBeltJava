
package Generics.game_with_generics;

import Generics.game.*;

public class Test {
    public static void main(String[] args) {
        Schoolar scoolar1 = new Schoolar("Иван", 13);
        Schoolar scoolar2 = new Schoolar("Мария", 15);
        
        Schoolar scoolar3 = new Schoolar("Петр", 12);
        Schoolar scoolar4 = new Schoolar("Екатрина", 14);
        
        Student student1 = new Student("Николай", 20);
        Student student2 = new Student("Ксения", 18);
        
        Employee employee1 = new Employee("Алексей", 34);
        Employee employee2 = new Employee("Константин", 43);
        
        Team<Schoolar> schoolarTeam = new Team<>("Драконы");
        schoolarTeam.addNewParticipant(scoolar1);
        schoolarTeam.addNewParticipant(scoolar2);
        
        Team<Schoolar> schoolarTeam2 = new Team<>("Мудрецы");
        schoolarTeam2.addNewParticipant(scoolar3);
        schoolarTeam2.addNewParticipant(scoolar4);
        
        Team<Student> studentTeam = new Team<>("Стая"); 
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        
        Team<Employee> employeeTeam = new Team<>("Матерые"); 
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);
        
        schoolarTeam.playWith(schoolarTeam2);
       
        /**
         *  В команду Драконы Был добавлен новый участник по имени Иван
            В команду Драконы Был добавлен новый участник по имени Мария
            В команду Мудрецы Был добавлен новый участник по имени Петр
            В команду Мудрецы Был добавлен новый участник по имени Екатрина
            В команду Стая Был добавлен новый участник по имени Николай
            В команду Стая Был добавлен новый участник по имени Ксения
            В команду Матерые Был добавлен новый участник по имени Алексей
            В команду Матерые Был добавлен новый участник по имени Константин
            Выиграла команда Мудрецы
         */
       
    }
}
