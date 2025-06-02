package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public interface Piece {
    Element[] getElements();
    void setPosition(int abscisse, int ordonnee);

    default void deplacerDe(int deltaX, int deltaY) throws BloxException {
        if (deltaY < 0 || Math.abs(deltaX) > 1 || deltaY > 1 || (deltaX != 0 && deltaY != 0)) {
            throw new IllegalArgumentException("Déplacement non autorisé");
        }

        var elements = getElements();
        var puits = getPuits();
        for (Element e : elements) {
            int newX = e.getCoordonnees().getAbscisse() + deltaX;
            int newY = e.getCoordonnees().getOrdonnee() + deltaY;

            if (newX < 0 || newX >= puits.getLargeur()) {
                throw new BloxException("Sortie du puits", BloxException.BLOX_SORTIE_PUITS);
            }

            if (newY >= puits.getProfondeur()) {
                throw new BloxException("Collision avec le fond du puits", BloxException.BLOX_COLLISION);
            }

            for (Element fixe : puits.getTas().getElements()) {
                if (fixe.getCoordonnees().getAbscisse() == newX && fixe.getCoordonnees().getOrdonnee() == newY) {
                    throw new BloxException("Collision avec le tas", BloxException.BLOX_COLLISION);
                }
            }
        }

        for (Element e : elements) {
            e.deplacerDe(deltaX, deltaY);
        }
    }

    default Couleur getCouleur() {
        return getElements()[0].getCouleur();
    }

    default Coordonnees getPosition() {
        return getElements()[0].getCoordonnees();
    }

    default void tourner(boolean sensHoraire) throws BloxException {
        Coordonnees pivot = getPosition();
        int px = pivot.getAbscisse();
        int py = pivot.getOrdonnee();
        var elements = getElements();
        var puits = getPuits();

        Coordonnees[] nouvelles = new Coordonnees[elements.length];
        nouvelles[0] = pivot;

        for (int i = 1; i < elements.length; i++) {
            Coordonnees c = elements[i].getCoordonnees();
            int dx = c.getAbscisse() - px;
            int dy = c.getOrdonnee() - py;

            int rx = sensHoraire ? dy : -dy;
            int ry = sensHoraire ? -dx : dx;

            int newX = px + rx;
            int newY = py + ry;

            if (newX < 0 || newX >= puits.getLargeur()) {
                throw new BloxException("Sortie du puits lors de la rotation", BloxException.BLOX_SORTIE_PUITS);
            }
            if (newY >= puits.getProfondeur()) {
                throw new BloxException("Collision avec le fond du puits", BloxException.BLOX_COLLISION);
            }

            for (Element fixe : puits.getTas().getElements()) {
                if (fixe.getCoordonnees().getAbscisse() == newX && fixe.getCoordonnees().getOrdonnee() == newY) {
                    throw new BloxException("Collision avec le tas", BloxException.BLOX_COLLISION);
                }
            }

            nouvelles[i] = new Coordonnees(newX, newY);
        }

        for (int i = 1; i < elements.length; i++) {
            elements[i].setCoordonnees(nouvelles[i]);
        }
    }

    Puits getPuits();
    void setPuits(Puits puits);
}
