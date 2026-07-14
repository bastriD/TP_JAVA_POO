package fr.diginamic.essais;

import fr.diginamic.combat.*;

public class TestCreature {

    public static void main(String[] args) {

        Creature loup = new Loup();
        Creature gobelin = new Gobelin();
        Creature troll = new Troll();

        afficher(loup);
        afficher(gobelin);
        afficher(troll);
    }

    private static void afficher(Creature creature) {

        System.out.println("-----------------------");
        System.out.println("Nom : " + creature.getNom());
        System.out.println("Force : " + creature.getForce());
        System.out.println("Vie : " + creature.getPointsDeSante());
        System.out.println("Score : " + creature.getScore());
    }
}