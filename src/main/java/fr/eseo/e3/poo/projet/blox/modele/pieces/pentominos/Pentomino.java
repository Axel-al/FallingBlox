package fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Pentomino implements Piece {
    protected final Element[] elements;

    private Puits puits;

    public Pentomino(Coordonnees coordonnees, Couleur couleur) {
        this.elements = new Element[5];
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    @Override
    public Element[] getElements() {
        return elements;
    }

    @Override
    public void setPosition(int abscisse, int ordonnee) {
        setElements(new Coordonnees(abscisse, ordonnee), getCouleur());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " :\n\t" +
                Arrays.stream(elements).map(Element::toString).collect(Collectors.joining("\n\t"));
    }

    @Override
    public Puits getPuits() {
        return this.puits;
    }

    @Override
    public void setPuits(Puits puits) {
        this.puits = puits;
    }
}
