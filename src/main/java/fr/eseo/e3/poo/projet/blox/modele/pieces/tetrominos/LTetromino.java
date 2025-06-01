package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class LTetromino extends Tetromino {
    public LTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        int abscisse = coordonnees.getAbscisse();
        int ordonnee = coordonnees.getOrdonnee();
        for (int i = 0; i < 3; i++) {
            this.elements[i] = new Element(new Coordonnees(abscisse, ordonnee - i), couleur);
        }
        this.elements[3] = new Element(new Coordonnees(abscisse + 1, ordonnee), couleur);
    }
}
