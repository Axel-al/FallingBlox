package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics2D;

public class VuePiece {

    public static final double MULTIPLIER_TEINTE = 0.3;

    private final Piece piece;
    private final int taille;

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public static Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();

        r += (int) ((255 - r) * MULTIPLIER_TEINTE);
        g += (int) ((255 - g) * MULTIPLIER_TEINTE);
        b += (int) ((255 - b) * MULTIPLIER_TEINTE);

        return new Color(r, g, b);
    }

    public void afficherPiece(Graphics2D g2D) {
        if (piece == null) return;

        Element[] elements = piece.getElements();
        for (int i = 0; i < elements.length; i++) {
            Element element = elements[i];
            int x = element.getCoordonnees().getAbscisse() * taille;
            int y = element.getCoordonnees().getOrdonnee() * taille;

            Color couleur = element.getCouleur().getCouleurPourAffichage();
            if (i == 0) {
                couleur = teinte(couleur); // Élément de référence
            }

            g2D.setColor(couleur);
            g2D.fill3DRect(x, y, taille, taille, true);
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public int getTaille() {
        return taille;
    }
}
