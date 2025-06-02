package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.*;
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
        assertTrue(piece instanceof Tetromino || piece instanceof Pentomino);
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
        assertTrue(piece instanceof Tetromino || piece instanceof Pentomino);
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

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testSetEtGetPuits(Piece piece) {
        Puits puits = new Puits();
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testDeplacerDe(Piece piece) {
        Coordonnees origine = piece.getPosition();

        // Test déplacement valide : gauche
        piece.deplacerDe(-1, 0);
        assertEquals(origine.getAbscisse() - 1, piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee(), piece.getPosition().getOrdonnee());

        // Revenir à la position d’origine
        piece.deplacerDe(1, 0);

        // Test déplacement valide : droite
        piece.deplacerDe(1, 0);
        assertEquals(origine.getAbscisse() + 1, piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee(), piece.getPosition().getOrdonnee());

        // Revenir à la position d’origine
        piece.deplacerDe(-1, 0);

        // Test déplacement valide : bas
        piece.deplacerDe(0, 1);
        assertEquals(origine.getAbscisse(), piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee() + 1, piece.getPosition().getOrdonnee());

        // Test déplacement invalide : vers le haut
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));

        // Test déplacement invalide : diagonale
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(1, 1));

        // Test déplacement invalide : trop grand déplacement horizontal
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));
    }

    // Fournit toutes les pièces à tester
    private static Stream<Arguments> providePieces() {
        return Stream.of(TypePiece.values())
                .map(type -> Arguments.of(type.creerInstance(randomCoord())));
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