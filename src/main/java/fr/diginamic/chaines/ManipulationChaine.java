package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

public class ManipulationChaine {

    public static void main(String[] args) {

        String chaine = "Durand;Marcel;2 523.5";

        // 1
        char premierCaractere = chaine.charAt(0);
        System.out.println("1. Premier caractère : " + premierCaractere);

        // 2
        System.out.println("2. Longueur : " + chaine.length());

        // 3
        int indexPointVirgule = chaine.indexOf(';');
        System.out.println("3. Premier ';' à l'index : " + indexPointVirgule);

        // 4
        String nom = chaine.substring(0, indexPointVirgule);
        System.out.println("4. Nom : " + nom);

        // 5
        System.out.println("5. Nom en majuscules : " + nom.toUpperCase());

        // 6
        System.out.println("6. Nom en minuscules : " + nom.toLowerCase());

        // 7
        String[] morceaux = chaine.split(";");

        System.out.println("7. Tableau obtenu :");

        for (String morceau : morceaux) {
            System.out.println(morceau);
        }

        // 8 et 9
        String nomSalarie = morceaux[0];
        String prenomSalarie = morceaux[1];

        String salaireSansEspace = morceaux[2].replace(" ", "");
        double salaire = Double.parseDouble(salaireSansEspace);

        Salarie salarie = new Salarie(
                nomSalarie,
                prenomSalarie,
                salaire
        );

        System.out.println();
        System.out.println("8-9. Salarié créé :");
        System.out.println(salarie);
    }
}