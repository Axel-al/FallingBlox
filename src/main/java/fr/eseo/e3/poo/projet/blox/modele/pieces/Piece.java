package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public interface Piece {
    Element[] getElements();
    void setPosition(int abscisse, int ordonnee);

    default Couleur getCouleur() {
        return getElements()[0].getCouleur();
    }

    default Coordonnees getPosition() {
        return getElements()[0].getCoordonnees();
    }

    Puits getPuits();
    void setPuits(Puits puits);
}
