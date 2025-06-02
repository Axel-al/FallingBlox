package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TasTest {

    @Test
    public void testConstructeurVide() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits);
        assertEquals(puits, tas.getPuits());
        assertTrue(tas.getElements().isEmpty());
    }

    @Test
    public void testConstructeurAvecElementsAutoLignes() {
        Puits puits = new Puits(10, 18);
        Tas tas = new Tas(puits, 20);
        assertEquals(20, tas.getElements().size());
    }

    @Test
    public void testConstructeurAvecElementsEtLignes() {
        Puits puits = new Puits(10, 18);
        Tas tas = new Tas(puits, 30, 3);
        assertEquals(30, tas.getElements().size());
    }

    @Test
    public void testConstructeurAvecRandomFixe() {
        Puits puits = new Puits(10, 18);
        Random rand = new Random(1234);
        Tas tas = new Tas(puits, 5, 2, rand);
        List<Element> elements = tas.getElements();
        assertEquals(5, elements.size());
        for (Element e : elements) {
            assertTrue(e.getCoordonnees().getOrdonnee() >= 16); // 18-1-1 = 16 max
        }
    }

    @Test
    public void testConstructeurTropDeLignes() {
        Puits puits = new Puits(10, 5);
        assertThrows(IllegalArgumentException.class, () -> new Tas(puits, 10, 6));
    }

    @Test
    public void testConstructeurTropDElements() {
        Puits puits = new Puits(5, 5);
        assertThrows(IllegalArgumentException.class, () -> new Tas(puits, 100, 2));
    }

    @Test
    public void testAjouterElements() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits);
        puits.setTas(tas);

        Piece piece = TypePiece.T.creerInstance(new Coordonnees(4, 16), Couleur.VIOLET);
        piece.setPuits(puits);

        tas.ajouterElements(piece);

        for (Element e : piece.getElements()) {
            assertTrue(tas.getElements().contains(e),
                    "L'élément " + e + " aurait dû être ajouté au tas.");
        }
    }

}
