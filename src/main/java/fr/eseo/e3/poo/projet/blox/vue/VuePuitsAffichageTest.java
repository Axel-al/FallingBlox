package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
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
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        puits.setPieceSuivante(UsineDePiece.genererTetromino());
        puits.setPieceSuivante(UsineDePiece.genererTetromino());

        VuePuits vuePuits = new VuePuits(puits, 40);

        JFrame frame = new JFrame("Puits et taille dynamique");
        frame.setContentPane(vuePuits);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Mise à jour dynamique après 2 secondes
        Timer timer = new Timer(2000, e -> {
            puits.setLargeur(12);      // déclenche mise à jour de la taille
            puits.setProfondeur(20);   // idem
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VuePuitsAffichageTest::new);
    }
}
