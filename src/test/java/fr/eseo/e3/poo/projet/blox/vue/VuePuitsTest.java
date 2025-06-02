package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

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
}
