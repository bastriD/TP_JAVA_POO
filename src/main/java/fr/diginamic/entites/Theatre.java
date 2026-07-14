package fr.diginamic.entites;

public class Theatre {

    private String nom;
    private int capaciteMax;
    private int totalClients;
    private double recetteTotale;

    public Theatre(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.totalClients = 0;
        this.recetteTotale = 0;
    }

    public void inscrire(int nbClients, double prixPlace) {

        if (totalClients + nbClients <= capaciteMax) {

            totalClients += nbClients;
            recetteTotale += nbClients * prixPlace;

            System.out.println(nbClients + " clients inscrits.");

        } else {

            System.out.println("Erreur : capacité maximale atteinte !");
        }
    }

    public int getTotalClients() {
        return totalClients;
    }

    public double getRecetteTotale() {
        return recetteTotale;
    }
}