package fr.diginamic.operations;

public class CalculMoyenne {

    private double[] valeurs;

    public CalculMoyenne() {
        valeurs = new double[0];
    }

    public void ajout(double valeur) {

        double[] nouveauTableau = new double[valeurs.length + 1];

        for (int i = 0; i < valeurs.length; i++) {
            nouveauTableau[i] = valeurs[i];
        }

        nouveauTableau[valeurs.length] = valeur;

        valeurs = nouveauTableau;
    }

    public double calcul() {

        if (valeurs.length == 0) {
            return 0;
        }

        double somme = 0;

        for (double valeur : valeurs) {
            somme += valeur;
        }

        return somme / valeurs.length;
    }
}