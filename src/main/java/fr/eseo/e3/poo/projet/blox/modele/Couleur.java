package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {
    ROUGE(Color.RED),
    ORANGE(Color.ORANGE),
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA);

    private final Color color;

    private Couleur(Color color) {
        this.color = color;
    }

    public Color getCouleurPourAffichage() {
        return this.color;
    }

    public static Couleur getDefault() {
        return Couleur.values()[0];
    }
}
