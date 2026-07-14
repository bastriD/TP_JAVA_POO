package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personnage {

    private int force;
    private int pointsDeSante;
    private int score;

    private int bonusAttaque;
    private int combatsBonusRestants;

    private final Random random;
    private final List<Potion> inventaire;

    public Personnage() {

        random = new Random();

        force = random.nextInt(7) + 12;
        pointsDeSante = random.nextInt(31) + 20;
        score = 0;

        bonusAttaque = 0;
        combatsBonusRestants = 0;

        inventaire = new ArrayList<>();

        inventaire.add(new PotionSoin());
        inventaire.add(new PotionAttaqueMineure());
        inventaire.add(new PotionAttaqueMajeure());
    }

    public int attaquer() {
        return force + bonusAttaque + random.nextInt(10) + 1;
    }

    public void subirDegats(int degats) {

        pointsDeSante -= degats;

        if (pointsDeSante < 0) {
            pointsDeSante = 0;
        }
    }

    public boolean estVivant() {
        return pointsDeSante > 0;
    }

    public void ajouterScore(int points) {
        score += points;
    }

    public void ajouterVie(int points) {
        pointsDeSante += points;
    }

    public void appliquerBonusAttaque(int bonus, int nombreCombats) {
        bonusAttaque = bonus;
        combatsBonusRestants = nombreCombats;
    }

    public void terminerCombat() {

        if (combatsBonusRestants > 0) {

            combatsBonusRestants--;

            if (combatsBonusRestants == 0) {
                bonusAttaque = 0;
                System.out.println("Le bonus d'attaque est terminé.");
            }
        }
    }

    public void ajouterPotion(Potion potion) {

        if (potion != null) {
            inventaire.add(potion);
        }
    }

    public void afficherInventaire() {

        if (inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide.");
            return;
        }

        System.out.println("Inventaire :");

        for (int i = 0; i < inventaire.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + inventaire.get(i).getNom()
            );
        }
    }

    public boolean utiliserPotion(int numeroPotion) {

        int index = numeroPotion - 1;

        if (index < 0 || index >= inventaire.size()) {
            System.out.println("Numéro de potion invalide.");
            return false;
        }

        Potion potion = inventaire.get(index);

        potion.utiliser(this);

        inventaire.remove(index);

        return true;
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeSante() {
        return pointsDeSante;
    }

    public int getScore() {
        return score;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getCombatsBonusRestants() {
        return combatsBonusRestants;
    }

    public List<Potion> getInventaire() {
        return inventaire;
    }

    @Override
    public String toString() {

        return "Personnage{" +
                "force=" + force +
                ", pointsDeSante=" + pointsDeSante +
                ", score=" + score +
                ", bonusAttaque=" + bonusAttaque +
                ", combatsBonusRestants=" + combatsBonusRestants +
                ", nombrePotions=" + inventaire.size() +
                '}';
    }
}