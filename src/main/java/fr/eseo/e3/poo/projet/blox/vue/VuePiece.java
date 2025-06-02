package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.*;

public class VuePiece {
    public static final double MULTIPLIER_TEINTE = 0.5;
    private Piece piece;
    private int taille;

    public VuePiece(Piece piece, int taille) {
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur) {
        int r = couleur.getRed();
        int g = couleur.getGreen();
        int b = couleur.getBlue();
        int rr = (int)(r + (255 - r) * MULTIPLIER_TEINTE);
        int gg = (int)(g + (255 - g) * MULTIPLIER_TEINTE);
        int bb = (int)(b + (255 - b) * MULTIPLIER_TEINTE);
        return new Color(rr, gg, bb);
    }

    public void afficherPiece(Graphics2D g2D) {
        g2D.setColor(this.piece.getCouleur().getCouleurPourAffichage());
        for (Element e : this.piece.getElements()) {
            int x = e.getCoordonnees().getAbscisse();
            int y = e.getCoordonnees().getOrdonnee();
            g2D.fill3DRect(x * taille, y * taille, taille, taille ,true);
        }
    }
}