package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.Pentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public final class UsineDePiece {
    public final static int ALEATOIRE_COMPLET = 0;
    public final static int ALEATOIRE_PIECE = 1;
    public final static int CYCLIC = 2;

    private static int mode = ALEATOIRE_PIECE;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private final static int INDEX_OTETROMINO = Arrays.asList(TypePiece.getTetrominos()).indexOf(TypePiece.O);
    private static int indexTetromino = INDEX_OTETROMINO;

    private final static int INDEX_IPENTOMINO = Arrays.asList(TypePiece.getPentominos()).indexOf(TypePiece.IP);
    private static int indexPentomino = INDEX_IPENTOMINO;

    private static int indexPiece = INDEX_OTETROMINO;

    private UsineDePiece() {
        throw new UnsupportedOperationException("Cette classe ne doit pas être instanciée");
    }

    public static void setMode(int mode) {
        UsineDePiece.mode = switch (mode) {
            case ALEATOIRE_PIECE -> ALEATOIRE_PIECE;
            case ALEATOIRE_COMPLET -> ALEATOIRE_COMPLET;
            case CYCLIC -> CYCLIC;
            default -> throw new IllegalArgumentException("Le mode choisi n'est pas valide");
        };

        if (mode == CYCLIC) {
            indexTetromino = INDEX_OTETROMINO;
            indexPentomino = INDEX_IPENTOMINO;
        }
    }

    public static Tetromino genererTetromino() {
        TypePiece tetrominoType;
        var coords = new Coordonnees(2, 3);

        switch (UsineDePiece.mode) {
            case CYCLIC:
                tetrominoType = TypePiece.getTetrominos()[indexTetromino++];
                indexTetromino %= TypePiece.getTetrominos().length;
                return (Tetromino) tetrominoType.creerInstance(coords);
            case ALEATOIRE_PIECE:
                tetrominoType = TypePiece.getTetrominos()[RANDOM.nextInt(TypePiece.getTetrominos().length)];
                return (Tetromino) tetrominoType.creerInstance(coords);
            case ALEATOIRE_COMPLET:
                tetrominoType = TypePiece.getTetrominos()[RANDOM.nextInt(TypePiece.getTetrominos().length)];
                var couleur = Couleur.values()[RANDOM.nextInt(Couleur.values().length)];
                return (Tetromino) tetrominoType.creerInstance(coords, couleur);
            default:
                throw new IllegalArgumentException("Le mode choisi n'est pas valide");
        }
    }

    public static Tetromino genererTetromino(Puits puits) {
        Tetromino tetromino = genererTetromino();
        tetromino.setPuits(puits);
        return tetromino;
    }

    public static Pentomino genererPentomino() {
        TypePiece pentominoType;
        var coords = new Coordonnees(2, 3);

        switch (UsineDePiece.mode) {
            case CYCLIC:
                pentominoType = TypePiece.getPentominos()[indexPentomino++];
                indexPentomino %= TypePiece.getPentominos().length;
                return (Pentomino) pentominoType.creerInstance(coords);
            case ALEATOIRE_PIECE:
                pentominoType = TypePiece.getPentominos()[RANDOM.nextInt(TypePiece.getPentominos().length)];
                return (Pentomino) pentominoType.creerInstance(coords);
            case ALEATOIRE_COMPLET:
                pentominoType = TypePiece.getPentominos()[RANDOM.nextInt(TypePiece.getPentominos().length)];
                var couleur = Couleur.values()[RANDOM.nextInt(Couleur.values().length)];
                return (Pentomino) pentominoType.creerInstance(coords, couleur);
            default:
                throw new IllegalArgumentException("Le mode choisi n'est pas valide");
        }
    }

    public static Pentomino genererPentomino(Puits puits) {
        Pentomino pentomino = genererPentomino();
        pentomino.setPuits(puits);
        return pentomino;
    }

    public static Piece genererPiece() {
        TypePiece pentominoType;
        var coords = new Coordonnees(2, 3);

        switch (UsineDePiece.mode) {
            case CYCLIC:
                pentominoType = TypePiece.values()[indexPiece++];
                indexPiece %= TypePiece.values().length;
                return pentominoType.creerInstance(coords);
            case ALEATOIRE_PIECE:
                pentominoType = TypePiece.values()[RANDOM.nextInt(TypePiece.values().length)];
                return pentominoType.creerInstance(coords);
            case ALEATOIRE_COMPLET:
                pentominoType = TypePiece.values()[RANDOM.nextInt(TypePiece.values().length)];
                var couleur = Couleur.values()[RANDOM.nextInt(Couleur.values().length)];
                return pentominoType.creerInstance(coords, couleur);
            default:
                throw new IllegalArgumentException("Le mode choisi n'est pas valide");
        }
    }

    public static Piece genererPiece(Puits puits) {
        Piece piece = genererPiece();
        piece.setPuits(puits);
        return piece;
    }
}
