package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordonneesTest {

    @Test
    public void testConstructeurEtGetters() {
        Coordonnees coord = new Coordonnees(3, 5);
        assertEquals(3, coord.getAbscisse());
        assertEquals(5, coord.getOrdonnee());
    }

    @Test
    public void testSetters() {
        Coordonnees coord = new Coordonnees(0, 0);
        coord.setAbscisse(7);
        coord.setOrdonnee(9);
        assertEquals(7, coord.getAbscisse());
        assertEquals(9, coord.getOrdonnee());
    }

    @Test
    public void testToString() {
        Coordonnees coord = new Coordonnees(2, 4);
        assertEquals("(2, 4)", coord.toString());
    }

    @Test
    public void testEqualsTrue() {
        Coordonnees coord1 = new Coordonnees(1, 2);
        Coordonnees coord2 = new Coordonnees(1, 2);
        assertEquals(coord1, coord2);
    }

    @Test
    public void testEqualsFalse() {
        Coordonnees coord1 = new Coordonnees(1, 2);
        Coordonnees coord2 = new Coordonnees(2, 1);
        assertNotEquals(coord1, coord2);
    }

    @Test
    public void testEqualsNullAndOtherType() {
        Coordonnees coord = new Coordonnees(0, 0);
        assertNotEquals(coord, null);
        assertNotEquals(coord, "pas une coordonnée");
    }

    @Test
    public void testHashCode() {
        Coordonnees coord1 = new Coordonnees(5, 8);
        Coordonnees coord2 = new Coordonnees(5, 8);
        assertEquals(coord1.hashCode(), coord2.hashCode());
    }
}