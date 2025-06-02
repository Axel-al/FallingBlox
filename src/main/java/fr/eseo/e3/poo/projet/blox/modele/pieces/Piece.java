package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public interface Piece {
    Element[] getElements();
    void setPosition(int abscisse, int ordonnee);

    default void deplacerDe(int deltaX, int deltaY) {
        // Vérification du vecteur de déplacement
        if (deltaY < 0 || Math.abs(deltaX) > 1 || deltaY > 1 || (deltaX != 0 && deltaY != 0)) {
            throw new IllegalArgumentException("Déplacement non autorisé : uniquement gauche, droite ou bas.");
        }

        for (Element e : this.getElements()) {
            e.deplacerDe(deltaX, deltaY);
        }
    }


    default Couleur getCouleur() {
        return getElements()[0].getCouleur();
    }

    default Coordonnees getPosition() {
        return getElements()[0].getCoordonnees();
    }

    Puits getPuits();
    void setPuits(Puits puits);
}
