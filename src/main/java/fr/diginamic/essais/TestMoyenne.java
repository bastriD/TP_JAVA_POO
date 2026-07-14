package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {

    public static void main(String[] args) {

        CalculMoyenne moyenne1 = new CalculMoyenne();

        moyenne1.ajout(10);
        moyenne1.ajout(20);
        moyenne1.ajout(30);

        System.out.println("Moyenne 1 = " + moyenne1.calcul());

        CalculMoyenne moyenne2 = new CalculMoyenne();

        moyenne2.ajout(5);
        moyenne2.ajout(15);
        moyenne2.ajout(25);
        moyenne2.ajout(35);

        System.out.println("Moyenne 2 = " + moyenne2.calcul());
    }
}