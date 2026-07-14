package fr.diginamic.combat;

public class Gobelin extends Creature {

    public Gobelin() {
        super("Gobelin", 5, 10, 10, 15);
    }

    @Override
    public int getScore() {
        return 2;
    }
}