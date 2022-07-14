
package Generics.game_with_generics;

import Generics.game.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> { 
    /** 
     * // extends Participant для того, чтобы мы не могли создавать команды других типов, а только тех кто наследуется от Participant тоесть школьников,
     * студентов и работников, так же если это не писать, то надо будет кастить participant в методе addNewParticipant так как у Т нет метода getName:
     * System.out.println("В команду " + name + " Был добавлен новый участник по имени " + ((Participant)participant).getName());
     */
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
   
    public void addNewParticipant(T participant){ // можем добавлять не любого Participant а только тип T
        participants.add(participant);
            System.out.println("В команду " + name + " Был добавлен новый участник по имени " + participant.getName());
            /**
             * нет необходимости кастить participant потому что компилятор понимает, что Т это сабкласс Participant или сам Participant
             */
    }
    
   
    public void playWith(Team team){
        String winnerName; 
        
        Random random = new Random();
        int i = random.nextInt(2);  
            if(i == 0){
                winnerName = this.name; 
            } else {
                winnerName = team.name; 
            }
            
            System.out.println("Выиграла команда " + winnerName );
    }
}
