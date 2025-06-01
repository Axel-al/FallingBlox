package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TetrominoShapeTest {

    @Test
    public void testOTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        OTetromino piece = new OTetromino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(1, 0),
                new Coordonnees(0, -1), new Coordonnees(1, -1)
        ));
    }

    @Test
    public void testITetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        ITetromino piece = new ITetromino(ref, Couleur.BLEU);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 1), new Coordonnees(0, -1),
                new Coordonnees(0, -2), new Coordonnees(0, 0)
        ));
    }

    @Test
    public void testJTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        JTetromino piece = new JTetromino(ref, Couleur.VERT);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(-1, 0),
                new Coordonnees(0, -1), new Coordonnees(0, -2)
        ));
    }

    @Test
    public void testLTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        LTetromino piece = new LTetromino(ref, Couleur.JAUNE);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(1, 0),
                new Coordonnees(0, -1), new Coordonnees(0, -2)
        ));
    }

    @Test
    public void testSTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        STetromino piece = new STetromino(ref, Couleur.CYAN);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(0, -1),
                new Coordonnees(-1, 0), new Coordonnees(1, -1)
        ));
    }

    @Test
    public void testTTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        TTetromino piece = new TTetromino(ref, Couleur.ORANGE);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(-1, 0),
                new Coordonnees(1, 0), new Coordonnees(0, 1)
        ));
    }

    @Test
    public void testZTetrominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        ZTetromino piece = new ZTetromino(ref, Couleur.VIOLET);
        Element[] elements = piece.getElements();

        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0), new Coordonnees(0, -1),
                new Coordonnees(1, 0), new Coordonnees(-1, -1)
        ));
    }

    private void assertCoordsMatch(Element[] elements, Set<Coordonnees> expectedCoords) {
        Set<Coordonnees> actualCoords = Arrays.stream(elements)
                .map(Element::getCoordonnees)
                .collect(Collectors.toSet());
        assertEquals(expectedCoords, actualCoords);
    }
}
