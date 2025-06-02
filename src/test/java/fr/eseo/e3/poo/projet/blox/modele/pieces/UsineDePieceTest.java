package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.Pentomino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UsineDePieceTest {

    @Test
    public void testGenererTetrominoAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Tetromino piece = UsineDePiece.genererTetromino();

        assertNotNull(piece);
        assertEquals(new Coordonnees(2, 3), piece.getPosition());

        TypePiece type = findTypeFromClass(piece.getClass());
        assertEquals(type.getCouleurParDefaut(), piece.getCouleur());
    }

    @Test
    public void testGenererTetrominoAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Tetromino piece = UsineDePiece.genererTetromino();

        assertNotNull(piece);
        assertNotNull(piece.getCouleur());

        assertEquals(new Coordonnees(2, 3), piece.getPosition());
    }

    @Test
    public void testGenererTetrominoCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Set<TypePiece> types = new HashSet<>();

        TypePiece[] tetrominos = TypePiece.getTetrominos();

        Tetromino premier = UsineDePiece.genererTetromino();
        assertEquals(TypePiece.O, findTypeFromClass(premier.getClass()));

        for (int i = 1; i < tetrominos.length + 1; i++) {
            Tetromino piece = UsineDePiece.genererTetromino();
            assertNotNull(piece);
            assertEquals(new Coordonnees(2, 3), piece.getPosition());

            TypePiece type = findTypeFromClass(piece.getClass());
            assertEquals(type.getCouleurParDefaut(), piece.getCouleur());

            types.add(type);

            if (i == tetrominos.length) {
                assertEquals(TypePiece.O, type);
            }
        }

        assertEquals(Set.of(tetrominos), types);
    }

    @Test
    public void testGenererPentominoAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Pentomino piece = UsineDePiece.genererPentomino();
        assertNotNull(piece);
        assertEquals(new Coordonnees(2, 3), piece.getPosition());

        TypePiece type = findTypeFromClass(piece.getClass());
        assertEquals(type.getCouleurParDefaut(), piece.getCouleur());
    }

    @Test
    public void testGenererPentominoAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Pentomino piece = UsineDePiece.genererPentomino();
        assertNotNull(piece);
        assertNotNull(piece.getCouleur());
        assertEquals(new Coordonnees(2, 3), piece.getPosition());
    }

    @Test
    public void testGenererPentominoCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Set<TypePiece> types = new HashSet<>();

        TypePiece[] pentominos = TypePiece.getPentominos();

        Pentomino premier = UsineDePiece.genererPentomino();
        assertEquals(TypePiece.IP, findTypeFromClass(premier.getClass()));

        for (int i = 1; i < pentominos.length + 1; i++) {
            Pentomino piece = UsineDePiece.genererPentomino();
            assertNotNull(piece);
            assertEquals(new Coordonnees(2, 3), piece.getPosition());

            TypePiece type = findTypeFromClass(piece.getClass());
            assertEquals(type.getCouleurParDefaut(), piece.getCouleur());

            types.add(type);

            if (i == pentominos.length) {
                assertEquals(TypePiece.IP, type);
            }
        }

        assertEquals(Set.of(pentominos), types);
    }

    @Test
    public void testGenererPieceAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece);
        assertEquals(new Coordonnees(2, 3), piece.getPosition());

        TypePiece type = findTypeFromClass(piece.getClass());
        assertEquals(type.getCouleurParDefaut(), piece.getCouleur());
    }

    @Test
    public void testGenererPieceAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece);
        assertNotNull(piece.getCouleur());
        assertEquals(new Coordonnees(2, 3), piece.getPosition());
    }

    @Test
    public void testGenererPieceCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Set<TypePiece> types = new HashSet<>();

        TypePiece[] pieces = TypePiece.values();

        Piece premier = UsineDePiece.genererPiece();
        assertEquals(TypePiece.O, findTypeFromClass(premier.getClass()));

        for (int i = 1; i < pieces.length + 1; i++) {
            Piece piece = UsineDePiece.genererPiece();
            assertNotNull(piece);
            assertEquals(new Coordonnees(2, 3), piece.getPosition());

            TypePiece type = findTypeFromClass(piece.getClass());
            assertEquals(type.getCouleurParDefaut(), piece.getCouleur());

            types.add(type);

            if (i == pieces.length) {
                assertEquals(TypePiece.O, type);
            }
        }

        assertEquals(Set.of(pieces), types);
    }

    // Méthode utilitaire pour retrouver le TypePiece correspondant à une classe
    private TypePiece findTypeFromClass(Class<? extends Piece> clazz) {
        for (TypePiece type : TypePiece.values()) {
            if (type.getClasse().equals(clazz)) {
                return type;
            }
        }
        throw new IllegalArgumentException("TypePiece non trouvé pour : " + clazz.getSimpleName());
    }
}
