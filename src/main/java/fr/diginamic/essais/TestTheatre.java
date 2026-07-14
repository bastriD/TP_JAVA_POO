package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympia", 100);

        theatre.inscrire(30, 25);
        theatre.inscrire(20, 25);
        theatre.inscrire(40, 25);
        theatre.inscrire(15, 25);

        System.out.println();
        System.out.println("Total clients : " + theatre.getTotalClients());
        System.out.println("Recette totale : " + theatre.getRecetteTotale() + " €");
    }
}