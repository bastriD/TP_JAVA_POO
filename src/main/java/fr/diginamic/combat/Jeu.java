package fr.diginamic.combat;

import java.util.Random;
import java.util.Scanner;

public class Jeu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static Personnage personnage;

    public static void main(String[] args) {

        boolean quitter = false;

        while (!quitter) {

            afficherMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("Veuillez saisir un nombre.");
                scanner.nextLine();
                System.out.println();
                continue;
            }

            int choix = scanner.nextInt();

            switch (choix) {

                case 1:
                    creerPersonnage();
                    break;

                case 2:
                    lancerCombat();
                    break;

                case 3:
                    utiliserPotion();
                    break;

                case 4:
                    afficherScore();
                    break;

                case 5:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void afficherMenu() {

        System.out.println("================================");
        System.out.println("            RPG");
        System.out.println("================================");
        System.out.println("1 - Créer un personnage");
        System.out.println("2 - Combattre");
        System.out.println("3 - Utiliser une potion");
        System.out.println("4 - Afficher le score");
        System.out.println("5 - Quitter");
        System.out.print("Votre choix : ");
    }

    private static void creerPersonnage() {

        personnage = new Personnage();

        System.out.println();
        System.out.println("Personnage créé !");
        System.out.println(personnage);
    }

    private static void lancerCombat() {

        if (personnage == null) {
            System.out.println("Créez un personnage d'abord.");
            return;
        }

        if (!personnage.estVivant()) {
            System.out.println(
                    "Votre personnage est décédé. Il a obtenu le score de "
                            + personnage.getScore()
                            + " points. Veuillez créer un nouveau personnage."
            );
            return;
        }

        Creature creature = creerCreatureAleatoire();

        Combat combat = new Combat(personnage, creature);
        combat.demarrer();
    }

    private static Creature creerCreatureAleatoire() {

        int tirage = random.nextInt(3);

        switch (tirage) {

            case 0:
                return new Loup();

            case 1:
                return new Gobelin();

            default:
                return new Troll();
        }
    }

    private static void utiliserPotion() {

        if (personnage == null) {
            System.out.println("Créez un personnage d'abord.");
            return;
        }

        if (!personnage.estVivant()) {
            System.out.println(
                    "Votre personnage est décédé. "
                            + "Créez un nouveau personnage."
            );
            return;
        }

        personnage.afficherInventaire();

        if (personnage.getInventaire().isEmpty()) {
            return;
        }

        System.out.print("Choisissez une potion : ");

        if (!scanner.hasNextInt()) {
            System.out.println("Veuillez saisir un numéro valide.");
            scanner.nextLine();
            return;
        }

        int choix = scanner.nextInt();

        personnage.utiliserPotion(choix);
    }

    private static void afficherScore() {

        if (personnage == null) {
            System.out.println("Aucun personnage.");
            return;
        }

        System.out.println("Score : " + personnage.getScore());
    }
}