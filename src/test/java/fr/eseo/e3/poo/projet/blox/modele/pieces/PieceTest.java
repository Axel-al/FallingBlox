package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testNombreElementsEtPosition(Piece piece) {
        assertTrue(piece instanceof Tetromino); // || piece instanceof Pentomino);
        boolean isTetromino = piece instanceof Tetromino;
        Element[] elements = piece.getElements();

        assertNotNull(elements);
        int expectedCount = isTetromino ? 4 : 5;
        assertEquals(expectedCount, elements.length);

        Coordonnees position = piece.getPosition();
        assertEquals(elements[0].getCoordonnees(), position);
        assertTrue(elementsWithinRange(elements, position, isTetromino));
    }

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testCouleur(Piece piece) {
        Couleur couleur = piece.getCouleur();
        for (Element element : piece.getElements()) {
            assertEquals(couleur, element.getCouleur());
        }
    }

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testSetPosition(Piece piece) {
        assertTrue(piece instanceof Tetromino); // || piece instanceof Pentomino);
        boolean isTetromino = piece instanceof Tetromino;

        Coordonnees newPosition = randomCoord();
        piece.setPosition(newPosition.getAbscisse(), newPosition.getOrdonnee());
        assertTrue(elementsWithinRange(piece.getElements(), newPosition, isTetromino));
    }

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testToString(Piece piece) {
        String result = piece.toString();
        String expected = piece.getClass().getSimpleName() + " :\n\t" + piece.getPosition().toString();

        assertTrue(result.startsWith(expected));

        for (Element element : piece.getElements()) {
            expected = "\t" + element.toString();
            assertTrue(result.contains(expected), "String manquante : " + expected);
        }
    }

    // Fournit toutes les pièces à tester
    private static Stream<Arguments> providePieces() {
        return Stream.of(
                // Tetrominos
                Arguments.of(new OTetromino(randomCoord(), Couleur.ROUGE)),
                Arguments.of(new ITetromino(randomCoord(), Couleur.BLEU)),
                Arguments.of(new JTetromino(randomCoord(), Couleur.VERT)),
                Arguments.of(new LTetromino(randomCoord(), Couleur.JAUNE)),
                Arguments.of(new STetromino(randomCoord(), Couleur.CYAN)),
                Arguments.of(new TTetromino(randomCoord(), Couleur.ORANGE)),
                Arguments.of(new ZTetromino(randomCoord(), Couleur.VIOLET))

                // Pentominos plus tard :
                // Arguments.of(new LPentomino(...)),
                // etc.
        );
    }

    private static Coordonnees randomCoord() {
        int abscisse = ThreadLocalRandom.current().nextInt(0, 100);
        int ordonnee = ThreadLocalRandom.current().nextInt(0, 100);
        return new Coordonnees(abscisse, ordonnee);
    }

    private static boolean elementsWithinRange(Element[] elements, Coordonnees position, boolean isTetromino) {
        int abscisseTolerance = isTetromino ? 1 : 2;
        int ordonneeTolerance = 2;
        for (Element element : elements) {
            if (Math.abs(element.getCoordonnees().getAbscisse() - position.getAbscisse()) > abscisseTolerance ||
                    Math.abs(element.getCoordonnees().getOrdonnee() - position.getOrdonnee()) > ordonneeTolerance)
                return false;
        }
        return true;
    }
}