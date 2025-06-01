package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OTetrominoTest {

    @Test
    public void testConstructeurEtElements() {
        OTetromino piece = new OTetromino(new Coordonnees(6, 5), Couleur.CYAN);
        Element[] elements = piece.getElements();

        assertNotNull(elements);
        assertEquals(4, elements.length);

        assertEquals(new Element(new Coordonnees(6, 5), Couleur.CYAN), elements[0]);
        assertTrue(containsElement(elements, new Coordonnees(7, 5), Couleur.CYAN));
        assertTrue(containsElement(elements, new Coordonnees(6, 4), Couleur.CYAN));
        assertTrue(containsElement(elements, new Coordonnees(7, 4), Couleur.CYAN));
    }

    @Test
    public void testSetElements() {
        OTetromino piece = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        piece.setElements(new Coordonnees(2, 2), Couleur.VERT);
        Element[] elements = piece.getElements();

        assertNotNull(elements);
        assertEquals(4, elements.length);

        assertEquals(new Element(new Coordonnees(2, 2), Couleur.VERT), elements[0]);
        assertTrue(containsElement(elements, new Coordonnees(3, 2), Couleur.VERT));
        assertTrue(containsElement(elements, new Coordonnees(2, 1), Couleur.VERT));
        assertTrue(containsElement(elements, new Coordonnees(3, 1), Couleur.VERT));
    }

    @Test
    public void testToStringFormat() {
        OTetromino piece = new OTetromino(new Coordonnees(6, 5), Couleur.CYAN);
        String result = piece.toString();

        assertTrue(result.startsWith("OTetromino :\n\t(6, 5) - CYAN\n"));
        assertTrue(result.contains("\t(7, 5) - CYAN"));
        assertTrue(result.contains("\t(6, 4) - CYAN"));
        assertTrue(result.contains("\t(7, 4) - CYAN"));
    }

    private boolean containsElement(Element[] elements, Coordonnees coord, Couleur couleur) {
        for (Element element : elements) {
            if (element.equals(new Element(coord, couleur))) {
                return true;
            }
        }
        return false;
    }
}
