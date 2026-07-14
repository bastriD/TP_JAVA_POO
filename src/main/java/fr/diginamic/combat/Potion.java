package fr.diginamic.combat;

public abstract class Potion {

    protected String nom;

    public Potion(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract void utiliser(Personnage personnage);
}