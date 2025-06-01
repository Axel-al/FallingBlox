package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
    final static int LARGEUR_PAR_DEFAUT = 10;
    final static int PROFONDEUR_PAR_DEFAUT = 18;

    private int largeur;
    private int profondeur;

    private Piece pieceActuelle;
    private Piece pieceSuivante;

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
    }

    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setPieceSuivante(Piece pieceSuivante) {
        if (this.pieceSuivante != null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(this.largeur/2, -4);

        }
        this.pieceSuivante = pieceSuivante;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + largeur + " x " + profondeur +
                "\nPiece Actuelle : " + (pieceActuelle == null ? "<aucune>" : pieceActuelle.toString()) +
                "\nPiece Suivante : " + (pieceSuivante == null ? "<aucune>" : pieceSuivante.toString());
    }
}
