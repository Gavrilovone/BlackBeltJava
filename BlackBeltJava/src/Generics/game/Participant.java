package Generics.game;

/**
 * <?> - любой класс
 * <? extends X> - класс X или любой его сабкласс
 *
 * participnt - участники
 *
 * создадим игру по типу что? где? когда? где будет в команде 2 человека играют команда против команды, 3 лиги школьная студенческая и работников
 */
public abstract class Participant {

    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

