package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        JFrame frame = new JFrame("Puits");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 40);

        JFrame frame = new JFrame("Puits et taille");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VuePuitsAffichageTest::new);
    }
}