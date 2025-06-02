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

        piece.deplacerDe(-1, 0);
        assertEquals(origine.getAbscisse() - 1, piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee(), piece.getPosition().getOrdonnee());

        piece.deplacerDe(1, 0);

        piece.deplacerDe(1, 0);
        assertEquals(origine.getAbscisse() + 1, piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee(), piece.getPosition().getOrdonnee());

        piece.deplacerDe(-1, 0);

        piece.deplacerDe(0, 1);
        assertEquals(origine.getAbscisse(), piece.getPosition().getAbscisse());
        assertEquals(origine.getOrdonnee() + 1, piece.getPosition().getOrdonnee());

        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(1, 1));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));
    }

    @ParameterizedTest
    @MethodSource("providePieces")
    public void testTourner(Piece piece) {
        Element[] beforeRotation = deepCopy(piece.getElements());

        piece.tourner(true); // sens horaire

        if (piece instanceof OTetromino || piece instanceof XPentomino) {
            // Ces pièces ne doivent pas tourner
            for (int i = 0; i < beforeRotation.length; i++) {
                assertEquals(beforeRotation[i].getCoordonnees(), piece.getElements()[i].getCoordonnees(),
                        piece.getClass().getSimpleName() + " ne devrait pas tourner");
            }
        } else {
            boolean auMoinsUnElementBouge = false;
            for (int i = 0; i < beforeRotation.length; i++) {
                if (!beforeRotation[i].getCoordonnees().equals(piece.getElements()[i].getCoordonnees())) {
                    auMoinsUnElementBouge = true;
                    break;
                }
            }
            assertTrue(auMoinsUnElementBouge, "La pièce aurait dû changer après rotation.");
        }
    }

    private static Element[] deepCopy(Element[] original) {
        Element[] copy = new Element[original.length];
        for (int i = 0; i < original.length; i++) {
            Coordonnees c = original[i].getCoordonnees();
            copy[i] = new Element(c.getAbscisse(), c.getOrdonnee(), original[i].getCouleur());
        }
        return copy;
    }

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
