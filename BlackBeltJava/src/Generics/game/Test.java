
package Generics.game;

public class Test {
    public static void main(String[] args) {
        Schoolar scoolar1 = new Schoolar("Иван", 13);
        Schoolar scoolar2 = new Schoolar("Мария", 15);
        
        Student student1 = new Student("Николай", 20);
        Student student2 = new Student("Ксения", 18);
        
        Employee employee1 = new Employee("Алексей", 34);
        Employee employee2 = new Employee("Константин", 43);
        
        Team schoolarTeam = new Team("Драконы");
        schoolarTeam.addNewParticipant(student1);
        schoolarTeam.addNewParticipant(student2);
        /**
         * тут мы сталктваемся с первой проблемой, оказывается мы можем в команду школьников добавить и студентов и работников
         * так происходит потому, что метод addNewParticipant принимает в параметр любого Participant, поэтому и школьник и студент и работник 
         * наследники его и являются Participant( мы конечно можем создать 3 класса Team для каждой группы, но зачем дублировать код, можно использовать 
         * дженерики) см.Generics.game_with_generics
         */
    }
}
