package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OTetromino extends Tetromino {
    private final Element[] elements;

    public OTetromino(Coordonnees coordonnees, Couleur couleur) {
        super();
        this.elements = new Element[4];
        setElements(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int abscisse = coordonnees.getAbscisse() + i;
                int ordonnee = coordonnees.getOrdonnee() - j;
                this.elements[i*2 + j] = new Element(new Coordonnees(abscisse, ordonnee), couleur);
            }
        }
    }

    public Element[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :\n\t" +
                Arrays.stream(elements).map(Element::toString).collect(Collectors.joining("\n\t"));
    }
}
