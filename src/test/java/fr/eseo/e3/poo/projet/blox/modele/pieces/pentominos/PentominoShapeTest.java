package fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos;

import fr.eseo.e3.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PentominoShapeTest {

    @Test
    public void testIPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        IPentomino piece = new IPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(0, 1),
                new Coordonnees(0, 2)
        ));
    }

    @Test
    public void testFPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        FPentomino1 piece = new FPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(-1, 0),
                new Coordonnees(0, -1),
                new Coordonnees(1, -1)
        ));
    }

    @Test
    public void testFPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        FPentomino2 piece = new FPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(1, 0),
                new Coordonnees(0, -1),
                new Coordonnees(-1, -1)
        ));
    }

    @Test
    public void testLPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        LPentomino1 piece = new LPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(1, 1)
        ));
    }

    @Test
    public void testLPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        LPentomino2 piece = new LPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(-1, 1)
        ));
    }

    @Test
    public void testNPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        NPentomino1 piece = new NPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(-1, 0),
                new Coordonnees(-1, 1)
        ));
    }

    @Test
    public void testNPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        NPentomino2 piece = new NPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(1, 0),
                new Coordonnees(1, 1)
        ));
    }

    @Test
    public void testPPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        PPentomino1 piece = new PPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(1, 0),
                new Coordonnees(1, -1),
                new Coordonnees(0, -1)
        ));
    }

    @Test
    public void testPPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        PPentomino2 piece = new PPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, 1),
                new Coordonnees(-1, 0),
                new Coordonnees(-1, -1),
                new Coordonnees(0, -1)
        ));
    }

    @Test
    public void testTPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        TPentomino piece = new TPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(1, 0),
                new Coordonnees(-1, 0),
                new Coordonnees(0, 1),
                new Coordonnees(0, 2)
        ));
    }

    @Test
    public void testUPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        UPentomino piece = new UPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(1, 0),
                new Coordonnees(1, -1),
                new Coordonnees(-1, 0),
                new Coordonnees(-1, -1)
        ));
    }

    @Test
    public void testVPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        VPentomino piece = new VPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, -2),
                new Coordonnees(-1, 0),
                new Coordonnees(-2, 0)
        ));
    }

    @Test
    public void testWPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        WPentomino piece = new WPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(1, 0),
                new Coordonnees(1, -1),
                new Coordonnees(0, 1),
                new Coordonnees(-1, 1)
        ));
    }

    @Test
    public void testXPentominoShape() {
        Coordonnees ref = new Coordonnees(0, 0);
        XPentomino piece = new XPentomino(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(1, 0),
                new Coordonnees(-1, 0),
                new Coordonnees(0, 1),
                new Coordonnees(0, -1)
        ));
    }

    @Test
    public void testYPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        YPentomino1 piece = new YPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(-1, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, 1),
                new Coordonnees(0, 2)
        ));
    }

    @Test
    public void testYPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        YPentomino2 piece = new YPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(1, 0),
                new Coordonnees(0, -1),
                new Coordonnees(0, 1),
                new Coordonnees(0, 2)
        ));
    }

    @Test
    public void testZPentomino1Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        ZPentomino1 piece = new ZPentomino1(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(-1, -1),
                new Coordonnees(0, 1),
                new Coordonnees(1, 1)
        ));
    }

    @Test
    public void testZPentomino2Shape() {
        Coordonnees ref = new Coordonnees(0, 0);
        ZPentomino2 piece = new ZPentomino2(ref, Couleur.ROUGE);
        Element[] elements = piece.getElements();
        assertEquals(ref, elements[0].getCoordonnees());
        assertCoordsMatch(elements, Set.of(
                new Coordonnees(0, 0),
                new Coordonnees(0, -1),
                new Coordonnees(1, -1),
                new Coordonnees(0, 1),
                new Coordonnees(-1, 1)
        ));
    }

    private void assertCoordsMatch(Element[] elements, Set<Coordonnees> expectedCoords) {
        Set<Coordonnees> actualCoords = Arrays.stream(elements)
                .map(Element::getCoordonnees)
                .collect(Collectors.toSet());
        assertEquals(expectedCoords, actualCoords);
    }
}
