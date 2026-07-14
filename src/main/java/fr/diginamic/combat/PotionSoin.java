package fr.diginamic.combat;

import java.util.Random;

public class PotionSoin extends Potion {

    private Random random = new Random();

    public PotionSoin() {
        super("Potion de soin");
    }

    @Override
    public void utiliser(Personnage personnage) {

        int soin = random.nextInt(6) + 5;

        personnage.ajouterVie(soin);

        System.out.println(
                "Le personnage récupère "
                        + soin
                        + " points de vie."
        );
    }
}