package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tas {

    private final Puits puits;
    private final List<Element> elements;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new ArrayList<>();
    }

    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, nbElements / puits.getLargeur() + 1);
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
        this.puits = puits;
        this.elements = new ArrayList<>();
        construireTas(nbElements, nbLignes, rand);
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {
        int largeur = puits.getLargeur();
        int profondeur = puits.getProfondeur();

        if (nbLignes > profondeur || nbElements > nbLignes * largeur) {
            throw new IllegalArgumentException("Trop d’éléments ou trop de lignes pour le puits.");
        }

        int count = 0;
        boolean[][] occupied = new boolean[largeur][nbLignes];

        while (count < nbElements) {
            int x = rand.nextInt(largeur);
            int y = rand.nextInt(nbLignes);
            if (!occupied[x][y]) {
                Coordonnees coord = new Coordonnees(x, profondeur - 1 - y);
                Element element = new Element(coord);
                elements.add(element);
                occupied[x][y] = true;
                count++;
            }
        }
    }

    public Puits getPuits() {
        return puits;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void ajouterElements(Piece piece) {
        for (Element e : piece.getElements()) {
            this.elements.add(new Element(e.getCoordonnees(), e.getCouleur()));
        }
    }
}
