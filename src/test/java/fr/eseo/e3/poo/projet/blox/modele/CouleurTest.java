package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class CouleurTest {

    @Test
    public void testCouleursAssociées() {
        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }

    @Test
    public void testDefaultCouleur() {
        assertEquals(Couleur.ROUGE, Couleur.getDefault());
    }

    @Test
    public void testToutesLesValeurs() {
        Couleur[] couleurs = Couleur.values();
        assertEquals(7, couleurs.length);
        assertArrayEquals(
                new Couleur[]{Couleur.ROUGE, Couleur.ORANGE, Couleur.BLEU, Couleur.VERT, Couleur.JAUNE, Couleur.CYAN, Couleur.VIOLET},
                couleurs
        );
    }
}
