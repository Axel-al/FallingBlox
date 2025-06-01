package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.*;

import java.util.Arrays;

public enum TypePiece {

    // Tetrominos
    O(OTetromino.class, Couleur.ROUGE),
    I(ITetromino.class, Couleur.ORANGE),
    J(JTetromino.class, Couleur.JAUNE),
    L(LTetromino.class, Couleur.VERT),
    S(STetromino.class, Couleur.VIOLET),
    T(TTetromino.class, Couleur.BLEU),
    Z(ZTetromino.class, Couleur.CYAN),

    // Pentominos
    IP(IPentomino.class, Couleur.ROUGE),
    F1(FPentomino1.class, Couleur.BLEU),
    F2(FPentomino2.class, Couleur.BLEU),
    L1(LPentomino1.class, Couleur.JAUNE),
    L2(LPentomino2.class, Couleur.JAUNE),
    N1(NPentomino1.class, Couleur.VERT),
    N2(NPentomino2.class, Couleur.VERT),
    P1(PPentomino1.class, Couleur.CYAN),
    P2(PPentomino2.class, Couleur.CYAN),
    TP(TPentomino.class, Couleur.ORANGE),
    UP(UPentomino.class, Couleur.VIOLET),
    VP(VPentomino.class, Couleur.ROUGE),
    WP(WPentomino.class, Couleur.BLEU),
    XP(XPentomino.class, Couleur.JAUNE),
    Y1(YPentomino1.class, Couleur.VERT),
    Y2(YPentomino2.class, Couleur.VERT),
    Z1(ZPentomino1.class, Couleur.ORANGE),
    Z2(ZPentomino2.class, Couleur.ORANGE);

    private static final TypePiece[] TETROMINOS = Arrays.stream(values())
            .filter(TypePiece::estTetromino)
            .toArray(TypePiece[]::new);

    private static final TypePiece[] PENTOMINOS = Arrays.stream(values())
            .filter(TypePiece::estPentomino)
            .toArray(TypePiece[]::new);

    private final Class<? extends Piece> classe;
    private final Couleur couleurParDefaut;

    TypePiece(Class<? extends Piece> classe, Couleur couleur) {
        this.classe = classe;
        this.couleurParDefaut = couleur;
    }

    public Class<? extends Piece> getClasse() {
        return classe;
    }

    public Couleur getCouleurParDefaut() {
        return couleurParDefaut;
    }

    public static TypePiece[] getTetrominos() {
        return TETROMINOS;
    }

    public static TypePiece[] getPentominos() {
        return PENTOMINOS;
    }

    public boolean estTetromino() {
        return Tetromino.class.isAssignableFrom(classe);
    }

    public boolean estPentomino() {
        return Pentomino.class.isAssignableFrom(classe);
    }

    public Piece creerInstance(Coordonnees coordonnees) {
        return creerInstance(coordonnees, this.couleurParDefaut);
    }

    public Piece creerInstance(Coordonnees coordonnees, Couleur couleur) {
        try {
            return classe.getConstructor(Coordonnees.class, Couleur.class)
                    .newInstance(coordonnees, couleur);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de : " + this, e);
        }
    }
}
