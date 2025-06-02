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

    default void tourner(boolean sensHoraire) {
        Element[] elements = getElements();
        Coordonnees pivot = getPosition(); // élément de référence
        int pivotX = pivot.getAbscisse();
        int pivotY = pivot.getOrdonnee();

        for (int i = 1; i < elements.length; i++) {
            Coordonnees c = elements[i].getCoordonnees();

            // Translation vers l’origine
            int dx = c.getAbscisse() - pivotX;
            int dy = c.getOrdonnee() - pivotY;

            // Rotation autour de l’origine
            int rx, ry;
            if (sensHoraire) {
                rx = dy;
                ry = -dx;
            } else {
                rx = -dy;
                ry = dx;
            }

            // Translation inverse
            Coordonnees nouvelle = new Coordonnees(pivotX + rx, pivotY + ry);
            elements[i].setCoordonnees(nouvelle);
        }
    }

    Puits getPuits();
    void setPuits(Puits puits);
}
