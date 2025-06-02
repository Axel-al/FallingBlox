package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class VuePuitsTest {

    @Test
    public void testConstructeurAvecTailleParDefaut() {
        Puits puits = new Puits();
        VuePuits vue = new VuePuits(puits);

        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vue.getTaille());
        assertEquals(puits, vue.getPuits());
    }

    @Test
    public void testConstructeurAvecTailleSpecifiee() {
        Puits puits = new Puits();
        int taille = 42;
        VuePuits vue = new VuePuits(puits, taille);

        assertEquals(taille, vue.getTaille());
        assertEquals(puits, vue.getPuits());
    }

    @Test
    public void testSetTailleAjustePreferredSize() {
        Puits puits = new Puits(10, 20);
        VuePuits vue = new VuePuits(puits);
        vue.setTaille(40);

        assertEquals(40, vue.getTaille());
        assertEquals(new Dimension(400, 800), vue.getPreferredSize());
    }

    @Test
    public void testSetPuitsAjustePreferredSize() {
        Puits puits1 = new Puits(10, 20);
        VuePuits vue = new VuePuits(puits1, 30);

        Puits puits2 = new Puits(5, 10);
        vue.setPuits(puits2);

        assertEquals(puits2, vue.getPuits());
        assertEquals(new Dimension(150, 300), vue.getPreferredSize());
    }
}
