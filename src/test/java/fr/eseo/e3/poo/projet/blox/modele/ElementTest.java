package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    @Test
    public void testConstructeurCoordonnees() {
        Coordonnees coord = new Coordonnees(1, 2);
        Element e = new Element(coord);
        assertEquals(coord, e.getCoordonnees());
        assertEquals(Couleur.getDefault(), e.getCouleur());
    }

    @Test
    public void testConstructeurCoordonneesEtCouleur() {
        Coordonnees coord = new Coordonnees(3, 4);
        Element e = new Element(coord, Couleur.BLEU);
        assertEquals(coord, e.getCoordonnees());
        assertEquals(Couleur.BLEU, e.getCouleur());
    }

    @Test
    public void testConstructeurAbscisseOrdonnee() {
        Element e = new Element(5, 6);
        assertEquals(new Coordonnees(5, 6), e.getCoordonnees());
        assertEquals(Couleur.getDefault(), e.getCouleur());
    }

    @Test
    public void testConstructeurAbscisseOrdonneeEtCouleur() {
        Element e = new Element(7, 8, Couleur.VERT);
        assertEquals(new Coordonnees(7, 8), e.getCoordonnees());
        assertEquals(Couleur.VERT, e.getCouleur());
    }

    @Test
    public void testSetters() {
        Element e = new Element(0, 0);
        e.setCoordonnees(new Coordonnees(9, 10));
        e.setCouleur(Couleur.JAUNE);
        assertEquals(new Coordonnees(9, 10), e.getCoordonnees());
        assertEquals(Couleur.JAUNE, e.getCouleur());
    }

    @Test
    public void testToString() {
        Element e = new Element(2, 3, Couleur.VIOLET);
        assertEquals("(2, 3) - VIOLET", e.toString());
    }

    @Test
    public void testEqualsTrue() {
        Element e1 = new Element(1, 1, Couleur.CYAN);
        Element e2 = new Element(1, 1, Couleur.CYAN);
        assertEquals(e1, e2);
    }

    @Test
    public void testEqualsFalseCoordonnees() {
        Element e1 = new Element(1, 1, Couleur.CYAN);
        Element e2 = new Element(2, 1, Couleur.CYAN);
        assertNotEquals(e1, e2);
    }

    @Test
    public void testEqualsFalseCouleur() {
        Element e1 = new Element(1, 1, Couleur.CYAN);
        Element e2 = new Element(1, 1, Couleur.ROUGE);
        assertNotEquals(e1, e2);
    }

    @Test
    public void testEqualsNullEtAutreType() {
        Element e = new Element(0, 0);
        assertNotEquals(e, null);
        assertNotEquals(e, "pas un élément");
    }

    @Test
    public void testHashCode() {
        Element e1 = new Element(3, 4, Couleur.ORANGE);
        Element e2 = new Element(3, 4, Couleur.ORANGE);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testDeplacerDe() {
        Element e = new Element(4, 5, Couleur.ROUGE);
        e.deplacerDe(2, 3);
        assertEquals(new Coordonnees(6, 8), e.getCoordonnees());

        e.deplacerDe(-1, -2);
        assertEquals(new Coordonnees(5, 6), e.getCoordonnees());

        e.deplacerDe(0, 0); // déplacement nul
        assertEquals(new Coordonnees(5, 6), e.getCoordonnees());
    }

}