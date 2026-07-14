package fr.diginamic.combat;

public class PotionAttaqueMajeure extends Potion {

    public PotionAttaqueMajeure() {
        super("Potion d'attaque majeure");
    }

@Override
public void utiliser(Personnage personnage) {

    personnage.appliquerBonusAttaque(5, 2);

    System.out.println(
            "Bonus de +5 en attaque pour les 2 prochains combats."
    );
}
}