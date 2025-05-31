package fr.eseo.e3.poo.projet.blox.modele;

public enum Couleur {
    ROUGE,
    ORANGE,
    BLEU,
    VERT,
    JAUNE,
    CYAN,
    VIOLET;

    public static Couleur getDefault() {
        return Couleur.values()[0];
    }
}
