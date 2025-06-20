package fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class XPentomino extends Pentomino {
    public XPentomino(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        int abscisse = coordonnees.getAbscisse();
        int ordonnee = coordonnees.getOrdonnee();
        this.elements[0] = new Element(coordonnees, couleur);
        this.elements[1] = new Element(new Coordonnees(abscisse + 1, ordonnee), couleur);
        this.elements[2] = new Element(new Coordonnees(abscisse - 1, ordonnee), couleur);
        this.elements[3] = new Element(new Coordonnees(abscisse, ordonnee + 1), couleur);
        this.elements[4] = new Element(new Coordonnees(abscisse, ordonnee - 1), couleur);
    }

    @Override
    public void tourner(boolean sensHoraire) {};
}
