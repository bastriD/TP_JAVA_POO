package fr.diginamic.combat;

public class PotionAttaqueMineure extends Potion {

    public PotionAttaqueMineure() {
        super("Potion d'attaque mineure");
    }

@Override
public void utiliser(Personnage personnage) {

    personnage.appliquerBonusAttaque(3, 1);

    System.out.println(
            "Bonus de +3 en attaque pour le prochain combat."
    );
}
}