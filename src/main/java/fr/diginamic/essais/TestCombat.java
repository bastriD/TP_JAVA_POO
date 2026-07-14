package fr.diginamic.essais;

import fr.diginamic.combat.Combat;
import fr.diginamic.combat.Loup;
import fr.diginamic.combat.Personnage;

public class TestCombat {

    public static void main(String[] args) {

        Personnage personnage = new Personnage();

        System.out.println("Personnage créé :");
        System.out.println(personnage);
        System.out.println();

        Combat combat = new Combat(
                personnage,
                new Loup()
        );

        combat.demarrer();
    }
}