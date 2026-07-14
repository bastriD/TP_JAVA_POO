package fr.diginamic.maison;

public class Maison {

    private Piece[] pieces;

    public Maison() {
        pieces = new Piece[0];
    }

    public void ajouterPiece(Piece piece) {

        if (piece == null) {
            System.out.println("Erreur : pièce null.");
            return;
        }

        if (piece.getSuperficie() < 0 || piece.getEtage() < 0) {
            System.out.println("Erreur : superficie ou étage invalide.");
            return;
        }

        Piece[] nouveauTableau = new Piece[pieces.length + 1];

        for (int i = 0; i < pieces.length; i++) {
            nouveauTableau[i] = pieces[i];
        }

        nouveauTableau[pieces.length] = piece;

        pieces = nouveauTableau;
    }

    public double superficieTotale() {

        double total = 0;

        for (Piece piece : pieces) {
            total += piece.getSuperficie();
        }

        return total;
    }

    public double superficieEtage(int etage) {

        double total = 0;

        for (Piece piece : pieces) {

            if (piece.getEtage() == etage) {
                total += piece.getSuperficie();
            }
        }

        return total;
    }

    public double superficieParType(Class<? extends Piece> typePiece) {

        double total = 0;

        for (Piece piece : pieces) {

            if (piece.getClass().equals(typePiece)) {
                total += piece.getSuperficie();
            }
        }

        return total;
    }

    public int nombrePiecesParType(Class<? extends Piece> typePiece) {

        int compteur = 0;

        for (Piece piece : pieces) {

            if (piece.getClass().equals(typePiece)) {
                compteur++;
            }
        }

        return compteur;
    }
}