package fr.diginamic.combat;

import java.util.Random;

public abstract class Creature {

    protected String nom;
    protected int force;
    protected int pointsDeSante;

    protected Random random = new Random();

    public Creature(String nom,
                    int forceMin,
                    int forceMax,
                    int vieMin,
                    int vieMax) {

        this.nom = nom;

        this.force = random.nextInt(forceMax - forceMin + 1) + forceMin;
        this.pointsDeSante = random.nextInt(vieMax - vieMin + 1) + vieMin;
    }

    public int attaquer() {
        return force + random.nextInt(10) + 1;
    }

    public void subirDegats(int degats) {

        pointsDeSante -= degats;

        if (pointsDeSante < 0) {
            pointsDeSante = 0;
        }
    }

    public boolean estVivante() {
        return pointsDeSante > 0;
    }

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeSante() {
        return pointsDeSante;
    }

    public abstract int getScore();
}