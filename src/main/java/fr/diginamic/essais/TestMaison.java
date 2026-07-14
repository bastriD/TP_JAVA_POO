package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {

    public static void main(String[] args) {

        Maison maison = new Maison();

        maison.ajouterPiece(new Chambre(15, 1));
        maison.ajouterPiece(new Chambre(12, 1));
        maison.ajouterPiece(new Cuisine(10, 0));
        maison.ajouterPiece(new Salon(30, 0));
        maison.ajouterPiece(new SalleDeBain(8, 1));
        maison.ajouterPiece(new WC(3, 0));

        System.out.println("Superficie totale : "
                + maison.superficieTotale());

        System.out.println("Superficie RDC : "
                + maison.superficieEtage(0));

        System.out.println("Superficie étage 1 : "
                + maison.superficieEtage(1));

        System.out.println("Superficie totale des chambres : "
                + maison.superficieParType(Chambre.class));

        System.out.println("Nombre de chambres : "
                + maison.nombrePiecesParType(Chambre.class));

        System.out.println("Superficie totale des WC : "
                + maison.superficieParType(WC.class));

        System.out.println("Nombre de WC : "
                + maison.nombrePiecesParType(WC.class));

        maison.ajouterPiece(null);

        maison.ajouterPiece(new Chambre(-10, 1));

        maison.ajouterPiece(new Cuisine(12, -1));
    }
}