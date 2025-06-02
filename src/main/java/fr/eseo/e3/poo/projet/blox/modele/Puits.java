package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {
    public final static int LARGEUR_PAR_DEFAUT = 10;
    public final static int PROFONDEUR_PAR_DEFAUT = 18;

    private int largeur;
    private int profondeur;

    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private Tas tas;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Puits() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.profondeur = PROFONDEUR_PAR_DEFAUT;
        this.tas = new Tas(this);
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.tas = new Tas(this);
    }

    public Puits(int largeur, int profondeur, int nbElements) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.tas = new Tas(this, nbElements);
    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.tas = new Tas(this, nbElements, nbLignes);
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

    public Tas getTas() {
        return tas;
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    public void setPieceSuivante(Piece pieceSuivante) {
        if (this.pieceSuivante != null) {
            Piece ancienne = this.pieceActuelle;
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(this.largeur / 2, -4);
            pcs.firePropertyChange("pieceActuelle", ancienne, this.pieceActuelle);
        }
        this.pieceSuivante = pieceSuivante;
    }

    public void setLargeur(int largeur) {
        int ancienne = this.largeur;
        this.largeur = largeur;
        pcs.firePropertyChange("largeur", ancienne, largeur);
    }

    public void setProfondeur(int profondeur) {
        int ancienne = this.profondeur;
        this.profondeur = profondeur;
        pcs.firePropertyChange("profondeur", ancienne, profondeur);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    private void gererCollision() {
        this.getTas().ajouterElements(this.pieceActuelle);
        this.setPieceSuivante(UsineDePiece.genererTetromino(this)); // Ou alea selon le mode
    }

    public void gravite() {
        if (this.pieceActuelle == null) return;

        try {
            this.pieceActuelle.deplacerDe(0, 1);
        } catch (BloxException e) {
            if (e.getType() == BloxException.BLOX_COLLISION) {
                gererCollision();
            } else if (e.getType() == BloxException.BLOX_SORTIE_PUITS) {
                // On ne fait rien, car ce cas ne devrait pas survenir verticalement
            }
        }
    }

    @Override
    public String toString() {
        return "Puits : Dimension " + largeur + " x " + profondeur +
                "\nPiece Actuelle : " + (pieceActuelle == null ? "<aucune>" : pieceActuelle.toString()) +
                "\nPiece Suivante : " + (pieceSuivante == null ? "<aucune>" : pieceSuivante.toString());
    }
}
