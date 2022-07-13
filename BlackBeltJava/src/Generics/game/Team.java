
package Generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    private String name;
    private List<Participant> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    /**
     * напишем метод который будет добавлять новых игроков в команду
     */
    
    public void addNewParticipant(Participant participant){
        participants.add(participant);
        System.out.println("В команду " + name + " Был добавлен новый участник по имени " + participant.getName());
    }
    
    /**
     * симитируем , что играет 2 команды
     */
    
    public void playWith(Team team){
        String winnerName; 
        /**
         * побеждает рандомно, кому повезло для этого:
         */
        Random random = new Random();
        int i = random.nextInt(2);  // 2 варианта всего 0 и 1
            if(i == 0){
                winnerName = this.name; // команда которая вызывает на себя этот метод
            } else {
                winnerName = team.name; // команда с которой мы играем
            }
            
            System.out.println("Выиграла команда winnerName");
    }
}
