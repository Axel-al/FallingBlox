package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;

public class Tas {

    private final Puits puits;
    private final List<Element> elements;
    private IntConsumer onLignesSupprimees;

    public Tas(Puits puits) {
        this(puits, 0, 0, null);
    }

    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, nbElements / puits.getLargeur() + 1, new Random(), null);
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random(), null);
    }

    public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
        this(puits, nbElements, nbLignes, rand, null);
    }

    public Tas(Puits puits, int nbElements, int nbLignes, Random rand, IntConsumer onLignesSupprimees) {
        this.puits = puits;
        this.elements = new ArrayList<>();
        this.onLignesSupprimees = onLignesSupprimees;
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

    public void setOnLignesSupprimees(IntConsumer onLignesSupprimees) {
        this.onLignesSupprimees = onLignesSupprimees;
    }

    public void ajouterElements(Piece piece) {
        for (Element e : piece.getElements()) {
            this.elements.add(new Element(e.getCoordonnees(), e.getCouleur()));
        }
        verifierEtSupprimerLignes();
    }

    public void verifierEtSupprimerLignes() {
        int largeur = puits.getLargeur();
        int lignesSupprimees = 0;

        for (int y = puits.getProfondeur() - 1; y >= 0; y--) {
            final int ligne = y;

            long nbElementsSurLigne = elements.stream()
                    .filter(e -> e.getCoordonnees().getOrdonnee() == ligne)
                    .map(e -> e.getCoordonnees().getAbscisse())
                    .distinct()
                    .count();

            if (nbElementsSurLigne == largeur) {
                supprimerLigneEtCompacter(ligne);
                lignesSupprimees++;
                y++; // revérifier la ligne maintenant occupée par un élément descendu
            }
        }

        if (lignesSupprimees > 0 && onLignesSupprimees != null) {
            onLignesSupprimees.accept(lignesSupprimees);
        }
    }

    private void supprimerLigneEtCompacter(int ligne) {
        elements.removeIf(e -> e.getCoordonnees().getOrdonnee() == ligne);

        for (Element e : elements) {
            if (e.getCoordonnees().getOrdonnee() < ligne) {
                e.deplacerDe(0, 1);
            }
        }
    }
}
