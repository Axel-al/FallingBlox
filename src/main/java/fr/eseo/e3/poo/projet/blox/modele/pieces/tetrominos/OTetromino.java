package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class OTetromino extends Tetromino {
    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        int abscisse = coordonnees.getAbscisse();
        int ordonnee = coordonnees.getOrdonnee();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.elements[i*2 + j] = new Element(new Coordonnees(abscisse + j, ordonnee - i), couleur);
            }
        }
    }

    @Override
    public void tourner(boolean sensHoraire) {};
}
