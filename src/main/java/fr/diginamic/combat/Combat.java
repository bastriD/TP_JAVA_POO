package fr.diginamic.combat;

import java.util.Random;

public class Combat {

    private final Personnage personnage;
    private final Creature creature;
    private final Random random;

    public Combat(Personnage personnage, Creature creature) {
        this.personnage = personnage;
        this.creature = creature;
        this.random = new Random();
    }

    public void demarrer() {

        System.out.println("Vous rencontrez un " + creature.getNom() + " !");
        System.out.println();

        while (personnage.estVivant() && creature.estVivante()) {

            int attaquePersonnage = personnage.attaquer();
            int attaqueCreature = creature.attaquer();

            System.out.println("Attaque personnage : " + attaquePersonnage);
            System.out.println(
                    "Attaque " + creature.getNom() + " : " + attaqueCreature
            );

            if (attaquePersonnage > attaqueCreature) {

                int degats = attaquePersonnage - attaqueCreature;

                creature.subirDegats(degats);

                System.out.println(
                        "Le personnage gagne le tour et inflige "
                                + degats
                                + " dégâts."
                );

            } else if (attaqueCreature > attaquePersonnage) {

                int degats = attaqueCreature - attaquePersonnage;

                personnage.subirDegats(degats);

                System.out.println(
                        creature.getNom()
                                + " gagne le tour et inflige "
                                + degats
                                + " dégâts."
                );

            } else {

                System.out.println("Égalité : aucun dégât.");
            }

            System.out.println(
                    "Vie personnage : "
                            + personnage.getPointsDeSante()
            );

            System.out.println(
                    "Vie "
                            + creature.getNom()
                            + " : "
                            + creature.getPointsDeSante()
            );

            System.out.println("-----------------------");
        }

        afficherResultat();

        personnage.terminerCombat();
    }

    private void afficherResultat() {

        if (personnage.estVivant()) {

            personnage.ajouterScore(creature.getScore());

            System.out.println();
            System.out.println(
                    "Victoire contre le "
                            + creature.getNom()
                            + " !"
            );

            System.out.println(
                    "Score : "
                            + personnage.getScore()
            );

            donnerRecompense();

        } else {

            System.out.println();
            System.out.println("Votre personnage est décédé.");

            System.out.println(
                    "Score final : "
                            + personnage.getScore()
            );
        }
    }

    private void donnerRecompense() {

        boolean recompenseObtenue = random.nextBoolean();

        if (!recompenseObtenue) {
            System.out.println("Aucune récompense obtenue.");
            return;
        }

        int recompense = random.nextInt(4);

        switch (recompense) {

            case 0:
                personnage.ajouterPotion(new PotionSoin());

                System.out.println(
                        "Récompense : Potion de soin"
                );
                break;

            case 1:
                personnage.ajouterPotion(
                        new PotionAttaqueMineure()
                );

                System.out.println(
                        "Récompense : Potion d'attaque mineure"
                );
                break;

            case 2:
                personnage.ajouterPotion(
                        new PotionAttaqueMajeure()
                );

                System.out.println(
                        "Récompense : Potion d'attaque majeure"
                );
                break;

            case 3:
                personnage.ajouterScore(5);

                System.out.println(
                        "Récompense : +5 points de score"
                );

                System.out.println(
                        "Nouveau score : "
                                + personnage.getScore()
                );
                break;

            default:
                break;
        }
    }
}