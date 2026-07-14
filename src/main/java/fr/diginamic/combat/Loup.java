package fr.diginamic.combat;

public class Loup extends Creature {

    public Loup() {
        super("Loup", 3, 8, 5, 10);
    }

    @Override
    public int getScore() {
        return 1;
    }
}