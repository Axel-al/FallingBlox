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

        assertTrue(containsElement(elements, new Coordonnees(6, 5), Couleur.CYAN));
        assertTrue(containsElement(elements, new Coordonnees(7, 5), Couleur.CYAN));
        assertTrue(containsElement(elements, new Coordonnees(6, 4), Couleur.CYAN));
        assertTrue(containsElement(elements, new Coordonnees(7, 4), Couleur.CYAN));
    }

    @Test
    public void testToStringFormat() {
        OTetromino piece = new OTetromino(new Coordonnees(6, 5), Couleur.CYAN);
        String result = piece.toString();

        assertTrue(result.startsWith("OTetromino :\n"));
        assertTrue(result.contains("(6, 5) - CYAN"));
        assertTrue(result.contains("(7, 5) - CYAN"));
        assertTrue(result.contains("(6, 4) - CYAN"));
        assertTrue(result.contains("(7, 4) - CYAN"));
    }

    private boolean containsElement(Element[] elements, Coordonnees coord, Couleur couleur) {
        for (Element element : elements) {
            if (element.getCoordonnees().equals(coord) && element.getCouleur() == couleur) {
                return true;
            }
        }
        return false;
    }
}
